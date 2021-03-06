import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/****************************************************************
 * Testovací třída {@code TestOsoby} slouží ke komplexnímu otestování
 * třídy {@link Osoby}.
 * 
 * @author    Pavel Herout
 * @version   5.00.000
 */
public class OsobaTest {

//== KONSTANTNI ATRIBUTY TRIDY ================================
  private static final SpravcePlatna SP = SpravcePlatna.getInstance();

//== PRIVATE POMOCNÉ INSTANČNÍ METODY =======================
  /**
   * Provede základní test jedné osoby 
   * testuje skutečné hodnoty dané osoby a to: souřadnice, výšku, šířku a barvu těla 
   * proti očekávaným hodnotám 
   * po skončení testu zobrazí dotaz pro uživatele na správnost testu
   * 
   * @param osoba testovaná osoba
   * @param x očekávaná x-souřadnice
   * @param y očekávaná y-souřadnice
   * @param sirka očekávaná šířka
   * @param vyska očekávaná výška
   * @param barva očekávaná barva
   */
  private void testJedneOsoby(Osoba osoba, int x, int y, int sirka, int vyska, Barva barva) {
    osoba.zobraz();
    assertEquals("Chybná x-souřadnice: ", x, osoba.getX());
    assertEquals("Chybná y-souřadnice: ", y, osoba.getY());
    assertEquals("Chybná šířka: ", sirka, osoba.getSirka());
    assertEquals("Chybná výška: ", vyska, osoba.getVyska());
    assertEquals("Chybná barva: ", barva, osoba.getBarvaTela());
//    assertEquals("Nepotvrzená správnost ", true, IO.souhlas("Je tato osoba správně?"));
  }
 
//Z DU_04
  /**
   * Provede základní test pozice jedné osoby 
   * testuje skutečné hodnoty dané osoby a to: souřadnice pozice 
   * proti očekávaným hodnotám
   * 
   * @param osoba testovaná osoba
   * @param pozice očekávaná pozice
   */
  private void testPoziceJedneOsoby(Osoba osoba, Pozice pozice) {
    osoba.zobraz();
    assertEquals("Chybná x-souřadnice: ", pozice.x, osoba.getX());
    assertEquals("Chybná y-souřadnice: ", pozice.y, osoba.getY());
  }
    
  /**
   * Test vykreslení obrazce na plátnu
   * 
   * @param chyboveHlaseni chybové hlášení Assertu
   * @param obrazec obrazec, terý má být vykreslen
   */
  private void testVykresleni(String chyboveHlaseni, IKresleny obrazec) {
    if (SP.poradi(obrazec) == -1) {
      assertEquals(chyboveHlaseni, 0, SP.poradi(obrazec));
    }
  }
    
  /***************************************************************************
   * Prohodí pozice zadaných osob a nechá zkontrolovat, 
   * zda si osoby své pozice doopravdy vyměnily.
   *
   * @param o1 první osoba
   * @param o2 druhá osoba
   */
  private void pomProhodPozice(Osoba o1, Osoba o2) {
    Pozice p1 = o1.getPozice();
    Pozice p2 = o2.getPozice();
    o1.setPozice(p2.x, p2.y);
    o2.setPozice(p1);

    assertEquals("Chybná x-souřadnice: ", p1.x, o2.getX());
    assertEquals("Chybná y-souřadnice: ", p1.y, o2.getY());
    assertEquals("Chybná x-souřadnice: ", p2.x, o1.getX());
    assertEquals("Chybná y-souřadnice: ", p2.y, o1.getY());
  }

// Testy z DU-03
  @Test
  public void testRuznychOsob() {
    SP.odstranVse();
    Osoba osDiteChlapec = new Osoba(250, 0, 30, Barva.MODRA);
    testJedneOsoby(osDiteChlapec, 250, 0, 35, 70, Barva.MODRA);
    Osoba osDiteDivka = new Osoba(300, 0, 30, Barva.SEDA);
    osDiteDivka.setBarvaTela(Barva.CERVENA);
    testJedneOsoby(osDiteDivka, 300, 0, 35, 70, Barva.CERVENA);
    Osoba osBeznyMuz = new Osoba(120, 150, Barva.MODRA);
    testJedneOsoby(osBeznyMuz, 120, 150, 70, 140, Barva.MODRA);
    Osoba osBeznaZena = new Osoba(200, 150, Barva.CERVENA);
    testJedneOsoby(osBeznaZena, 200, 150, 70, 140, Barva.CERVENA);
    Osoba osNoName = new Osoba();
    testJedneOsoby(osNoName, 0, 0, 70, 140, Barva.SEDA);
    Osoba osUrostlyGeneral = new Osoba(350, 0, 30, 1.0/5, 8.0/6, Barva.KHAKI);
    testJedneOsoby(osUrostlyGeneral, 350, 0, 112, 180, Barva.KHAKI);
  }

////////////////////////////////////////////////////////////////////
// Testy z DU-04    
  @Test
  public void testKonstruktoruPozicRuznychOsob() {
    SP.odstranVse();
    Pozice pozice = new Pozice(250, 0);
    Osoba osDiteChlapec = new Osoba(pozice, 30, Barva.MODRA);
    testPoziceJedneOsoby(osDiteChlapec, pozice);
    testJedneOsoby(osDiteChlapec, 250, 0, 35, 70, Barva.MODRA);

    pozice = new Pozice(120, 150);
    Osoba osBeznyMuz = new Osoba(pozice, Barva.MODRA);
    testPoziceJedneOsoby(osBeznyMuz, pozice);
    testJedneOsoby(osBeznyMuz, 120, 150, 70, 140, Barva.MODRA);

    pozice = new Pozice(350, 0);
    Osoba osUrostlyGeneral = new Osoba(pozice, 30, 1.0/5, 8.0/6, Barva.KHAKI);
    testPoziceJedneOsoby(osUrostlyGeneral, pozice);
    testJedneOsoby(osUrostlyGeneral, 350, 0, 112, 180, Barva.KHAKI);
  }

  @Test
  public void testStatickaTovarniMetoda() {
    SP.odstranVse();
    Osoba osBeznyMuz = Osoba.getBeznyMuz(new Pozice(180, 130));
    osBeznyMuz.zobraz();
    testJedneOsoby(osBeznyMuz, 180, 130, 70, 140, Barva.MODRA);

    Osoba osBeznaZena = Osoba.getBeznaZena(new Pozice(260, 130));
    osBeznaZena.zobraz();
    assertEquals("Chybná barva těla: ", Barva.CERVENA, 
                   osBeznaZena.getBarvaTela());
    testJedneOsoby(osBeznaZena, 260, 130, 70, 140, Barva.CERVENA);
  }

  @Test
  public void testVytvoreniPodlePohlavi() {
    SP.odstranVse();
    Osoba osBeznyMuz = new Osoba(new Pozice(120, 150), Pohlavi.MUZ);
    osBeznyMuz.zobraz();
    testJedneOsoby(osBeznyMuz, 120, 150, 70, 140, Barva.MODRA);
    
    Osoba osBeznaZena = new Osoba(new Pozice(200, 150), Pohlavi.ZENA);
    osBeznaZena.zobraz();
    testJedneOsoby(osBeznaZena, 200, 150, 70, 140, Barva.CERVENA);
  }

  @Test
  public void testProhodPozice() {
    SP.odstranVse();
    Osoba osBeznaZena = new Osoba(250, 0, Barva.CERVENA);
    osBeznaZena.zobraz();
    Osoba osMalaTlusta = new Osoba(100, 0, 60, 1.0/1, 1.0/2, Barva.CERNA);
    osMalaTlusta.zobraz();
    testJedneOsoby(osBeznaZena, 250, 0, 70, 140, Barva.CERVENA);
    testJedneOsoby(osMalaTlusta, 100, 0, 120, 120, Barva.CERNA);

    IO.zprava("Před přesunem");
    pomProhodPozice(osBeznaZena, osMalaTlusta);
    assertEquals("Chybný rozměr beznaZena: ", "Rozmer[sirka=70, vyska=140]", 
                   osBeznaZena.getRozmer().toString());
    assertEquals("Chybná x-souřadnice hlavy malaTlusta: ", 280, osMalaTlusta.getHlava().getX());
    assertEquals("Nepotvrzená správnost ", true, IO.souhlas("Jsou obě osoby vykresleny?"));
  }

////////////////////////////////////////////////////////////////////
// Nove testy z DU-05   
  @Test
  public void testPresouvani() {
    SP.odstranVse();
    IPosuvny muz = Osoba.getBeznyMuz(new Pozice(0, 0));
    ((Osoba) muz).zobraz();
    IPosuvny zena = Osoba.getBeznaZena(new Pozice(350, 150));
    ((Osoba) zena).zobraz();
        
    Presouvac presRychl_5 = new Presouvac(5);
    presRychl_5.presunNa(200, 75, zena);
    assertEquals("Chybná cílová x-souřadnice: ", 200, zena.getPozice().x);
    assertEquals("Chybná cílová y-souřadnice: ", 75, zena.getPozice().y);

    Presouvac presRychl_1 = new Presouvac(1);
    presRychl_1.presunO(130, 75, muz);
  }

  @Test
  public void testRozmeru() {
    SP.odstranVse();
    IMeritelny general = new Osoba(new Pozice(200, 100), 30, 1.0/5, 8.0/6, Barva.KHAKI);
    ((Osoba) general).zobraz();
    assertEquals("Chybná šířka: ", 112, general.getSirka());
    assertEquals("Chybná výška: ", 180, general.getVyska());
    assertEquals("Chybná šířka: ", 112, general.getRozmer().sirka);
    assertEquals("Chybná výška: ", 180, general.getRozmer().vyska);
  }
  
  @Test
  public void testPresunuAZvyrazneni() {
    SP.odstranVse();
    Zvyraznovac zvyr = new Zvyraznovac();
    Osoba muz = Osoba.getBeznyMuz(new Pozice(15, 15));
    muz.zobraz();
    testJedneOsoby(muz, 15, 15, 70, 140, Barva.MODRA);
    Obdelnik zvyrObdelnik = zvyr.zvyrazniPozadi(muz, Barva.STRIBRNA);
    testVykresleni("Zvýrazňující obdélník není vykreslen: ", zvyrObdelnik);
       
    Osoba zena = Osoba.getBeznaZena(new Pozice(420, 140));
    zena.zobraz();
    testJedneOsoby(zena, 420, 140, 70, 140, Barva.CERVENA);
    Elipsa zvyrElipsa = zvyr.zvyrazniPozadiElipsou(zena, Barva.ZLATA);
    testVykresleni("Zvýrazňující elipsa není vykreslena: ", zvyrElipsa);
     
    IO.zprava("Počáteční stav");
          
    SP.odstran(zvyrObdelnik);
    SP.odstran(zvyrElipsa);
    assertEquals("Zvýrazňující obdélník JE vykreslen: ", -1, SP.poradi(zvyrObdelnik));
    assertEquals("Zvýrazňující elipsa JE vykreslena: ", -1, SP.poradi(zvyrElipsa));
    IO.zprava("Bez zvýraznění");
       
    Presouvac presRychl_5 = new Presouvac(5);
    presRychl_5.presunNa(250, 75, zena);
    presRychl_5.presunNa(180, 75, muz);
        
    zvyrObdelnik = zvyr.zvyrazniPozadi(muz, Barva.STRIBRNA);
    zvyrElipsa = zvyr.zvyrazniPozadiElipsou(zena, Barva.ZLATA);
    testJedneOsoby(muz, 180, 75, 70, 140, Barva.MODRA);
    testJedneOsoby(zena, 250, 75, 70, 140, Barva.CERVENA);
    testVykresleni("Zvýrazňující obdélník není vykreslen: ", zvyrObdelnik);
    testVykresleni("Zvýrazňující elipsa není vykreslena: ",zvyrElipsa);
  }
}
