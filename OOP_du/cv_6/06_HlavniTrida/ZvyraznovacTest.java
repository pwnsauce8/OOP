import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/****************************************************************
 * Testovací třída {@code ZvyraznovacTest} slouží k otestování
 * třídy {@link Zvyraznovac}.
 * 
 * @author    Pavel Herout
 * @version   1.00.000
 */
public class ZvyraznovacTest {

//== KONSTANTNI ATRIBUTY TRIDY ================================
  private static final SpravcePlatna SP = SpravcePlatna.getInstance();

//== PRIVATE POMOCNÉ INSTANČNÍ METODY =======================
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
    
// Testy z DU-05   

  @Test
  public void testZvyrazneniPozadi() {
    SP.odstranVse();
    Zvyraznovac zvyr = new Zvyraznovac();
    IZvyrazneny muz = Osoba.getBeznyMuz(new Pozice(120, 100));
    ((Osoba) muz).zobraz();
    Obdelnik zvyrObdelnik = zvyr.zvyrazniPozadi(muz, Barva.ZLUTA);
    testVykresleni("Zvýrazňující obdélník není vykreslen: ", zvyrObdelnik);
    
    assertEquals("Chybná x-souřadnice: ", 110, zvyrObdelnik.getX());
    assertEquals("Chybná y-souřadnice: ", 90, zvyrObdelnik.getY());
    assertEquals("Chybná šířka: ", 90, zvyrObdelnik.getSirka());
    assertEquals("Chybná výška: ", 160, zvyrObdelnik.getVyska());
    assertEquals("Chybná barva: ", Barva.ZLUTA, zvyrObdelnik.getBarva());
      
    assertEquals("Zvýrazňující obdélník překrývá osobu: ", 0, SP.poradi(zvyrObdelnik));
  }
  
  @Test
  public void testZvyrazneniPozadiVelkymObdelnikem() {
    SP.odstranVse();
    Zvyraznovac zvyr = new Zvyraznovac(50);
    IZvyrazneny muz = Osoba.getBeznyMuz(new Pozice(150, 100));
    ((Osoba) muz).zobraz();
    Obdelnik zvyrTvar = zvyr.zvyrazniPozadi(muz, Barva.STRIBRNA);
    testVykresleni("Zvýrazňující obdélník není vykreslen: ", zvyrTvar);

    assertEquals("Chybná x-souřadnice: ", 100, zvyrTvar.getX());
    assertEquals("Chybná y-souřadnice: ", 50, zvyrTvar.getY());
    assertEquals("Chybná šířka: ", 170, zvyrTvar.getSirka());
    assertEquals("Chybná výška: ", 240, zvyrTvar.getVyska());
    assertEquals("Chybná barva: ", Barva.STRIBRNA, zvyrTvar.getBarva());
  }
 
  @Test
  public void testZvyrazneniPozadiElipsou() {
    SP.odstranVse();
    Zvyraznovac zvyr = new Zvyraznovac();
    IZvyrazneny muz = Osoba.getBeznyMuz(new Pozice(120, 100));
    ((Osoba) muz).zobraz();
    Elipsa zvyrTvar = zvyr.zvyrazniPozadiElipsou(muz, Barva.ZLUTA);
    testVykresleni("Zvýrazňující elipsa není vykreslena: ", zvyrTvar);
    
    assertEquals("Chybná x-souřadnice: ", 110, zvyrTvar.getX());
    assertEquals("Chybná y-souřadnice: ", 90, zvyrTvar.getY());
    assertEquals("Chybná šířka: ", 90, zvyrTvar.getSirka());
    assertEquals("Chybná výška: ", 160, zvyrTvar.getVyska());
    assertEquals("Chybná barva: ", Barva.ZLUTA, zvyrTvar.getBarva());
  }

  @Test
  public void testZvyrazneniOblasti() {
    SP.odstranVse();
    Zvyraznovac zvyr = new Zvyraznovac();
    IZvyrazneny muz = Osoba.getBeznyMuz(new Pozice(120, 100));

    Oblast zvyrOblast = zvyr.zjistiOblastZvyrazneni(muz);
    assertEquals("Chybná x-souřadnice: ", 110, zvyrOblast.getX());
    assertEquals("Chybná y-souřadnice: ", 90, zvyrOblast.getY());
    assertEquals("Chybná šířka: ", 90, zvyrOblast.getSirka());
    assertEquals("Chybná výška: ", 160, zvyrOblast.getVyska());
  }
}
