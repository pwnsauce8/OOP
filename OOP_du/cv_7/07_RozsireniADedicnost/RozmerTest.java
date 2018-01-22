/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/************************************************************
 * Testovací třída {@code RozmerTest} slouží ke komplexnímu
 *  otestování třídy {@code Rozmer}
 *
 * @author  Pavel Herout
 * @version 2.00.0000 — 2017-09-25
 */
public class RozmerTest {
//== PROMĚNNÉ INSTANČNÍ ATRIBUTY ============================
  private Rozmer rozmer;

//###########################################################
  /**********************************************************
   * Inicializace předcházející spuštění každého testu a připravující tzv.
   * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
   */
  @Before
  public void setUp() {
    rozmer = new Rozmer(200, 100);
  }

//== TESTOVACÍ METODY =======================================

  /**********************************************************
   * Test konstruktoru
   */
  @Test
  public void testKonstruktor() {
    assertEquals("Chybná šířka: ", 200, rozmer.getSirka());
    assertEquals("Chybná výška: ", 100, rozmer.getVyska());
  }
  
  /**********************************************************
   * Test přístupových práv atributů
   */
  @Test
  public void testAtributy() {
    assertEquals("Chybná šířka: ", 200, rozmer.sirka);
    assertEquals("Chybná výška: ", 100, rozmer.vyska);
  }
  
  /**********************************************************
   * Test toString()
   */
  @Test
  public void testToString() {
    assertEquals("Chybný toString(): ", "Rozmer[sirka=200, vyska=100]", rozmer.toString());
  }
}
