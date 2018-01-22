import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/****************************************************************
 * Testovací třída {@code RandeTest} slouží ke komplexnímu otestování
 * třídy {@link Rande}.
 *
 * @author    Pavel Herout
 * @version   4.00.000
 */
public class RandeTest {

//== KONSTANTNÍ ATRIBUTY TŘÍDY ================================
  private static final SpravcePlatna SP = SpravcePlatna.getInstance();
  private Rande rande;
  private Pozice poziceM;
  private Pozice poziceZ;
  private Osoba muz;
  private Osoba zena;

  /**********************************************************
   * Inicializace předcházející spuštění každého testu a připravující tzv.
   * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
   */
  @Before
  public void setUp() {
    SP.odstranVse();
    poziceM = new Pozice(10, 10);
    poziceZ = new Pozice(400, 150);
    muz = Osoba.getBeznyMuz(poziceM);
    zena = Osoba.getBeznaZena(poziceZ);
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
   
  /**
   * Test vykreslení obrazce na plátnu
   * @param chyboveHlaseni chybové hlášení Assertu
   * @param obrazec obrazec, terý má být vykreslen
   */
  private void testVykresleni(String chyboveHlaseni, IKresleny obrazec) {
    if (SP.poradi(obrazec) == -1) {
      assertEquals(chyboveHlaseni, 0, SP.poradi(obrazec));
    }
  }

//== VLASTNÍ TESTY ============================================

  /*********************************************************
   * Zajistí zobrazení nezobrazené osoby
   */
  @Test
  public void testZobrazeni_True() {
    Rande rande = new Rande(muz, zena);
    SP.odstran(muz);
    assertEquals("Již byl zobrazen ", true, rande.zajistiZobrazeniOsoby(muz));
  }

  /*********************************************************
   * Ověří zobrazení zobrazené osoby
   */
  @Test
  public void testZobrazeni_False() {
    muz.zobraz();
    Rande rande = new Rande(muz, zena);
    assertEquals("Ještě nebyl zobrazen ", false, rande.zajistiZobrazeniOsoby(muz));
  }

  @Test
  public void testVzniku() {
    rande = new Rande(muz, zena);
    
    Osoba muzR = rande.getMuz();
    testPozice(poziceM, muzR.getPozice(), "muž");
    assertSame("Muži nejsou totožní: ", muz, muzR);
    
    Osoba zenaR = rande.getZena();
    testPozice(poziceZ, zenaR.getPozice(), "žena");
    assertSame("Ženy nejsou totožné: ", zena, zenaR);

    testVykresleni("Muž není vykreslen: ", muzR);
    testVykresleni("Žena není vykreslena: ", zenaR);

    testPozice(poziceM, rande.getDomaMuz(), "domaMuž");
    testPozice(poziceZ, rande.getDomaZena(), "domaŽena");

    assertEquals("Nepotvrzená správnost ", true, IO.souhlas("Jsou obě osoby vykresleny správně?"));
  }

  @Test
  public void testSetkaniUprostred() {
    rande = new Rande(muz, zena);

    Presouvac chuzeNaRande = new Presouvac(5);
    Pozice pS = new Pozice(150, 80);
    rande.jdouNaRande(pS, chuzeNaRande);
    
    testPozice(new Pozice(220, 80), muz.getPozice(), "muž");
    testPozice(pS, zena.getPozice(), "žena");
    
    assertEquals("Nepotvrzená správnost ", true, IO.souhlas("Jsou obě osoby vykresleny správně?"));
  }

  @Test
  public void testSetkaniVlevo() {
    muz.setPozice(new Pozice(200, 150));
    zena.setPozice(new Pozice(100, 150));
    rande = new Rande(muz, zena);

    testVykresleni("Muz neni vykreslen: ", muz);
    testVykresleni("Zena neni vykreslena: ", zena);

    Presouvac chuzeNaRande = new Presouvac(10);
    Pozice pS = new Pozice(10, 10);
    rande.jdouNaRande(pS, chuzeNaRande);
    
    testPozice(new Pozice(80, 10), muz.getPozice(), "muž");
    testPozice(pS, zena.getPozice(), "žena");
    
    assertEquals("Nepotvrzená správnost ", true, IO.souhlas("Jsou obě osoby vykresleny správně?"));
  }

  @Test
  public void testSetkaniVpravo() {
    muz.setPozice(new Pozice(200, 10));
    zena.setPozice(new Pozice(100, 110));
    rande = new Rande(muz, zena);
    
    testVykresleni("Muž není vykreslen: ", muz);
    testVykresleni("Žena není vykreslena: ", zena);

    Presouvac chuzeNaRande = new Presouvac(10);
    Pozice pS = new Pozice(300, 150);
    rande.jdouNaRande(pS, chuzeNaRande);
    
    testPozice(new Pozice(370, 150), muz.getPozice(), "muž");
    testPozice(pS, zena.getPozice(), "žena");
    
    assertEquals("Nepotvrzená správnost ", true, IO.souhlas("Jsou obě osoby vykresleny správně?"));
  }
  
  @Test
  public void testJdouSpolu() {
    rande = new Rande(muz, zena);

    IO.zprava("Jdou na rande");
    Presouvac chuzeNaRande = new Presouvac(5);
    Pozice pS = new Pozice(150, 80);
    Par par = rande.jdouNaRande(pS, chuzeNaRande);
    SP.pridej(par);
    
    IO.zprava("Jdou společně");
    Pozice pV = new Pozice(10, 10);
    Presouvac chuzeSpolu = new Presouvac(3);
    rande.parJdeSpolecne(par, pV, chuzeSpolu);
    
    testPozice(pV, zena.getPozice(), "žena");
    
    Pozice pD = new Pozice(350, 10);
    rande.parJdeSpolecne(par, pD, chuzeSpolu);
    Pozice pK = new Pozice(10, 150);
    rande.parJdeSpolecne(par, pK, chuzeSpolu);
    
    zena = rande.getZena();
    testPozice(pK, zena.getPozice(), "žena");
    
    assertEquals("Nepotvrzená správnost ", true, IO.souhlas("Šel pár společně?"));
  }


  @Test
  public void testCeleRande() {
    rande = new Rande(muz, zena);

    Presouvac chuzeNaRande = new Presouvac(15);
    Pozice pS = new Pozice(150, 80);
    Par par = rande.jdouNaRande(pS, chuzeNaRande);
    SP.pridej(par);
    
    Pozice pV = new Pozice(10, 10);
    Presouvac chuzeSpolu = new Presouvac(13);
    rande.parJdeSpolecne(par, pV, chuzeSpolu);    
    
    // prvni spolecna zastavka
    IO.zprava("První společná zastávka");
    testPozice(new Pozice(10 + zena.getSirka(), 10), muz.getPozice(), "První společná zastávka muž");
    testPozice(pV, zena.getPozice(), "První společná zastávka žena");
    
    Pozice pD = new Pozice(350, 10);
    rande.parJdeSpolecne(par, pD, chuzeSpolu);

    // druha spolecna zastavka
    IO.zprava("Druhá společná zastávka");
    testPozice(new Pozice(350 + zena.getSirka(), 10), muz.getPozice(), "Druhá společná zastávka muž");
    testPozice(pD, zena.getPozice(), "Druhá společná zastávka žena");
    
    Pozice pK = new Pozice(10, 150);
    rande.parJdeSpolecne(par, pK, chuzeSpolu);
    testPozice(new Pozice(10 + zena.getSirka(), 150), muz.getPozice(), "Rande končí muž");
    testPozice(pK, zena.getPozice(), "Rande končí žena");
    
    IO.zprava("Rande končí");
    
    rande.jdouDomu(par, chuzeSpolu);
    testPozice(poziceM, muz.getPozice(), "domaMuž");
    testPozice(poziceZ, zena.getPozice(), "domaŽena");
    
    assertEquals("Nepotvrzená správnost ", true, IO.souhlas("Vrátily se obě osoby domů?"));
  }

  @Test
  public void testHlavni() {
    Hlavni.main(new String[] {"9", "11", "3"});
  }
}
