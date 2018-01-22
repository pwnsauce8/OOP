/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/************************************************************
 * Testovací třída {@code OsobaTest} slouží ke komplexnímu
 * otestování třídy {@link Osoba}.
 *
 * @author    Pavel Herout
 * @version   3.00.000
 */
public class OsobaTest {
//== PROMĚNNÉ INSTANČNÍ ATRIBUTY ============================
  private Osoba osStihlaVysoka;
  private Osoba osMalaTlusta;
  private Osoba osDiteChlapec;
  private Osoba osDiteDivka;
  private Osoba osBeznyMuz;
  private Osoba osBeznaZena;
  private Osoba osNoName;
  private Osoba osUrostlyGeneral;

//== PRIVATE POMOCNÉ INSTANČNÍ METODY =======================
  private String getNazevTvaru(String celyNazev) {
    int indexVNazvu = celyNazev.indexOf("_");
    return celyNazev.substring(0, indexVNazvu);
  }
  
//###########################################################
  /************************************************************
   * Inicializace předcházející spuštění každého testu a připravující tzv.
   * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
   */
  @Before
  public void setUp() {
    
  }

  /**********************************************************
   * Úklid po testu - tato metoda se spustí po vykonání každého testu.
   */
  @After
  public void tearDown() {
      // nepouzita
  }

//== TESTOVACÍ METODY =======================================

  @Test
  public void testStihlaVysoka() {
    osStihlaVysoka = new Osoba(0, 0, 60, 1.0/2, 4.0/1, Barva.HNEDA);
    assertEquals("Hlava: chybný tvar", "Elipsa", getNazevTvaru(osStihlaVysoka.getHlava().getNazev()));
    assertEquals("Hlava: chybná barva", Barva.RUZOVA, osStihlaVysoka.getHlava().getBarva());
    assertEquals("Tělo: chybný tvar", "Obdelnik", getNazevTvaru(osStihlaVysoka.getTelo().getNazev()));
    assertEquals("Chybná x-souřadnice hlavy: ", 0, osStihlaVysoka.getHlava().getX());
    assertEquals("Chybná y-souřadnice hlavy: ", 0, osStihlaVysoka.getHlava().getY());
    assertEquals("Chybná šířka hlavy: ", 60, osStihlaVysoka.getHlava().getSirka());
    assertEquals("Chybná výška hlavy: ", 60, osStihlaVysoka.getHlava().getVyska());
    assertEquals("Chybná x-souřadnice těla: ", 15, osStihlaVysoka.getTelo().getX());
    assertEquals("Chybná y-souřadnice těla: ", 60, osStihlaVysoka.getTelo().getY());
    assertEquals("Chybná šířka těla: ", 30, osStihlaVysoka.getTelo().getSirka());
    assertEquals("Chybná výška těla: ", 120, osStihlaVysoka.getTelo().getVyska());
    assertEquals("Chybná x-souřadnice celé osoby: ", 0, osStihlaVysoka.getX());
    assertEquals("Chybná y-souřadnice celé osoby: ", 0, osStihlaVysoka.getY());
    assertEquals("Chybná šířka celé osoby: ", 60, osStihlaVysoka.getSirka());
    assertEquals("Chybná výška celé osoby: ", 180, osStihlaVysoka.getVyska());
  //  assertEquals("Chybný název: ", "Osoba_1", osStihlaVysoka.getNazev());
  }


  @Test
  public void testMalaTlusta() {
    osMalaTlusta = new Osoba(100, 0, 60, 1.0/1, 1.0/2, Barva.CERNA);
    assertEquals("Chybná x-souřadnice hlavy: ", 130, osMalaTlusta.getHlava().getX());
    assertEquals("Chybná y-souřadnice hlavy: ", 0, osMalaTlusta.getHlava().getY());
    assertEquals("Chybná šířka hlavy: ", 60, osMalaTlusta.getHlava().getSirka());
    assertEquals("Chybná výška hlavy: ", 60, osMalaTlusta.getHlava().getVyska());
    assertEquals("Chybná x-souřadnice těla: ", 100, osMalaTlusta.getTelo().getX());
    assertEquals("Chybná y-souřadnice těla: ", 60, osMalaTlusta.getTelo().getY());
    assertEquals("Chybná šířka těla: ", 120, osMalaTlusta.getTelo().getSirka());
    assertEquals("Chybná výška těla: ", 60, osMalaTlusta.getTelo().getVyska());
    assertEquals("Chybná x-souřadnice celé osoby: ", 100, osMalaTlusta.getX());
    assertEquals("Chybná y-souřadnice celé osoby: ", 0, osMalaTlusta.getY());
    assertEquals("Chybná šířka celé osoby: ", 120, osMalaTlusta.getSirka());
    assertEquals("Chybná výška celé osoby: ", 120, osMalaTlusta.getVyska());
  }

 
  @Test
  public void testDiteChlapec() {
    osDiteChlapec = new Osoba(250, 0, 30, Barva.MODRA);
    assertEquals("Chybná x-souřadnice: ", 250, osDiteChlapec.getX());
    assertEquals("Chybná y-souřadnice: ", 0, osDiteChlapec.getY());
    assertEquals("Chybná šířka: ", 35, osDiteChlapec.getSirka());
    assertEquals("Chybná výška: ", 70, osDiteChlapec.getVyska());
    assertEquals("Chybná barva: ", Barva.MODRA, osDiteChlapec.getBarvaTela());
    assertEquals("Chybná barva: ", Barva.MODRA, osDiteChlapec.getTelo().getBarva());
  }

  @Test
  public void testDiteDivka() {
    osDiteDivka = new Osoba(300, 0, 30, Barva.SEDA);
    assertEquals("Chybná x-souřadnice: ", 300, osDiteDivka.getX());
    assertEquals("Chybná y-souřadnice: ", 0, osDiteDivka.getY());
    assertEquals("Chybná šířka: ", 35, osDiteDivka.getSirka());
    assertEquals("Chybná výška: ", 70, osDiteDivka.getVyska());
    IO.cekej(500);
    osDiteDivka.setBarvaTela(Barva.CERVENA);
    assertEquals("Chybná barva: ", Barva.CERVENA, osDiteDivka.getBarvaTela());
    assertEquals("Chybná barva: ", Barva.CERVENA, osDiteDivka.getTelo().getBarva());
  }

  @Test
  public void testBeznyMuz() {
    osBeznyMuz = new Osoba(120, 150, Barva.MODRA);
    assertEquals("Chybná x-souřadnice: ", 120, osBeznyMuz.getX());
    assertEquals("Chybná y-souřadnice: ", 150, osBeznyMuz.getY());
    assertEquals("Chybná šířka: ", 70, osBeznyMuz.getSirka());
    assertEquals("Chybná výška: ", 140, osBeznyMuz.getVyska());
    assertEquals("Chybná barva: ", Barva.MODRA, osBeznyMuz.getBarvaTela());
  }

  @Test
  public void testBeznaZena() {
    osBeznaZena = new Osoba(200, 150, Barva.CERVENA);
    assertEquals("Chybná x-souřadnice: ", 200, osBeznaZena.getX());
    assertEquals("Chybná y-souřadnice: ", 150, osBeznaZena.getY());
    assertEquals("Chybná šířka: ", 70, osBeznaZena.getSirka());
    assertEquals("Chybná výška: ", 140, osBeznaZena.getVyska());
    assertEquals("Chybná barva: ", Barva.CERVENA, osBeznaZena.getBarvaTela());
  }

  @Test
  public void testNoName() {
    osNoName = new Osoba();
    assertEquals("Chybná x-souřadnice: ", 0, osNoName.getX());
    assertEquals("Chybná y-souřadnice: ", 0, osNoName.getY());
    assertEquals("Chybná šířka: ", 70, osNoName.getSirka());
    assertEquals("Chybná výška: ", 140, osNoName.getVyska());
    assertEquals("Chybná barva: ", Barva.SEDA, osNoName.getBarvaTela());
  }

  @Test
  public void testUrostlyGeneral() {
    osUrostlyGeneral = new Osoba(350, 0, 30, 1.0/5, 8.0/6, Barva.KHAKI);
    assertEquals("Chybná x-souřadnice hlavy: ", 391, osUrostlyGeneral.getHlava().getX());
    assertEquals("Chybná y-souřadnice hlavy: ", 0, osUrostlyGeneral.getHlava().getY());
    assertEquals("Chybná šířka hlavy: ", 30, osUrostlyGeneral.getHlava().getSirka());
    assertEquals("Chybná výška hlavy: ", 30, osUrostlyGeneral.getHlava().getVyska());
    assertEquals("Chybná x-souřadnice těla: ", 350, osUrostlyGeneral.getTelo().getX());
    assertEquals("Chybná y-souřadnice těla: ", 30, osUrostlyGeneral.getTelo().getY());
    assertEquals("Chybná šířka těla: ", 112, osUrostlyGeneral.getTelo().getSirka());
    assertEquals("Chybná výška těla: ", 150, osUrostlyGeneral.getTelo().getVyska());
    assertEquals("Chybná x-souřadnice celé osoby: ", 350, osUrostlyGeneral.getX());
    assertEquals("Chybná y-souřadnice celé osoby: ", 0, osUrostlyGeneral.getY());
    assertEquals("Chybná šířka celé osoby: ", 112, osUrostlyGeneral.getSirka());
    assertEquals("Chybná výška celé osoby: ", 180, osUrostlyGeneral.getVyska());
  }
}
