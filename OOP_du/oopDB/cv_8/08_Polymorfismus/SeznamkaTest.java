import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/****************************************************************
 * Testovací třída {@code Test} slouží ke komplexnímu otestování
 * třídy {@link Seznamka}.
 *
 * @author    Pavel Herout
 * @version   3.00.000
 */
public class SeznamkaTest {
//== KONSTANTNÍ ATRIBUTY TŘÍDY ================================
  private static final SpravcePlatna SP = SpravcePlatna.getInstance();

//== PŘÍPRAVA A ÚKLID PŘÍPRAVKU ===============================
  /************************************************************
   * Inicializace předcházející spuštění každého testu a připravující tzv.
   * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
   */
  @Before
  public void setUp() {
    SP.odstranVse();
  }

//== SOUKROMÉ A POMOCNÉ METODY INSTANCÍ =======================
  /**
   * @param po očekávaná pozice
   * @param ps skutečná pozice
   * @param nazevInstance název testované instance
   */
  private void testPozice(Pozice po, Pozice ps, String nazevInstance) {
	  assertEquals("Chybná x-souřadnice " + nazevInstance + ": ", po.x, ps.x);
	  assertEquals("Chybná y-souřadnice " + nazevInstance + ": ", po.y, ps.y);
	 }

//== VLASTNÍ TESTY ============================================
  @Test
  public void testSeznamky() {
    Seznamka seznamka = Seznamka.getSeznamka();
    seznamka.vymazVsechnyLidi();
    Pozice vznik = new Pozice(0, 0);
    Osoba m1 = Osoba.getBeznyMuz(vznik);
    Osoba m2 = new Superman();
    Osoba z1 = Osoba.getBeznaZena(vznik);
    Osoba z2 = new Superwoman();
    Pozice novySrazMuzu = new Pozice(10, 100);
    seznamka.setSrazMuzu(novySrazMuzu);
    seznamka.pridejMuze(m1);
    testPozice(novySrazMuzu, m1.getPozice(), "nový sraz mužů");
    seznamka.setSrazMuzu(vznik);
    seznamka.pridejMuze(m2);
	  Osoba m3 = new Osoba(vznik, 60, 1.0/1, 1.0/2, Barva.MODRA);
    seznamka.pridejMuze(m3);
    testPozice(vznik, m1.getPozice(), "m1 - původní sraz mužů");
    testPozice(vznik, m2.getPozice(), "m2 - původní sraz mužů");
    testPozice(vznik, m3.getPozice(), "m3 - původní sraz mužů");
    
    Pozice srazZen = new Pozice(350, 100);
    seznamka.setSrazZen(srazZen);
    seznamka.pridejZenu(z1);
    testPozice(srazZen, z1.getPozice(), "sraz žen");
    Pozice novySrazZen = new Pozice(350, 100);
    seznamka.setSrazZen(novySrazZen);
    seznamka.pridejZenu(z2);
	  Osoba z3 = new Osoba(vznik, 60, 1.0/2, 4.0/1, Barva.CERVENA);
    seznamka.pridejZenu(z3);
    testPozice(novySrazZen, z1.getPozice(), "z1 - nový sraz žen");
    testPozice(novySrazZen, z2.getPozice(), "z2 - nový sraz žen");
    testPozice(novySrazZen, z3.getPozice(), "z3 - nový sraz žen");
    
    seznamka.setPresouvac(10);
    seznamka.setMistoSchuzky(new Pozice(150, 50));
    
    assertEquals("Chybný počet uskutečněných setkání:", 7, 
             seznamka.realizujSchuzky(new Pozice(10, 150), 0));
  }
  
  @Test
  public void testSeznamkaSkupina() {
    Seznamka seznamka = Seznamka.getSeznamka();
    seznamka.vymazVsechnyLidi();
    Pozice pMuzi = new Pozice(450, 10);
    seznamka.setSrazMuzu(pMuzi);
    Barva barva = Barva.MODRA;
    for (int i = 1;  i <= 4;  i++) {
      int velikostHlavy = 30 + 5 * i; 
      seznamka.pridejMuze(new Osoba(pMuzi, velikostHlavy, barva));
      barva = barva.svetlejsi().svetlejsi();
    }
    seznamka.pridejMuze(new Superman());
    
    Pozice pZeny = new Pozice(10, 150);
    seznamka.setSrazZen(pZeny);
    barva = Barva.CERVENA;
    for (int i = 1;  i <= 3;  i++) {
      int velikostHlavy = 30 + 5 * i; 
      seznamka.pridejZenu(new Osoba(pZeny, velikostHlavy, barva));
      barva = barva.svetlejsi().svetlejsi();
    }
    seznamka.pridejZenu(new Superwoman());      
    int velikostHlavy = 50; 
    seznamka.pridejZenu(new Osoba(pZeny, velikostHlavy, barva));
    
    seznamka.setPresouvac(30);
    seznamka.setMistoSchuzky(new Pozice(200, 80));
    
    assertEquals("Chybný počet uskutečněných setkání:", 24, 
             seznamka.realizujSchuzky(new Pozice(10, 10), 0));
  }
}
