/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/************************************************************
 * Instance třídy {@code Seznamka} představují seznamovaci kancelar
 *
 * @author  Mukanova Zhanel
 * @version 2.00.0000 — 2017-11-21
 */
public class Seznamka {
  //== KONSTANTNÍ ATRIBUTY TŘÍDY ===========================
  /** vytvoreni noveho spravce platna **/
  private static final SpravcePlatna SP = SpravcePlatna.getInstance();
  /** Defaultní rychlost přesouvání*/
  private static final int DEF_RYCHLOST = 5;
  /** defaultní pozice srazu mužů*/
  private static final Pozice DEF_SRAZ_MUZI = new Pozice(10, 10);
  /** defaultní pozice srazu žen*/
  private static final Pozice DEF_SRAZ_ZENY;
  /** defaultní místo setkání*/
  private static final Pozice DEF_SETKANI; 
  
  //== STATICKÝ INICIALIZAČNÍ BLOK =========================
  static {
    /** šířka plátna*/
    int sirkaPlatna = SP.getBsirka();
    /** výška plátna*/
    int vyskaPlatna = SP.getBVyska();
    DEF_SRAZ_ZENY = new Pozice(sirkaPlatna - 100, vyskaPlatna - 100);
    DEF_SETKANI = new Pozice(sirkaPlatna / 3, vyskaPlatna / 3);
  }
  /** vytvoření jedináčka*/
  private static final Seznamka INSTANCE = new Seznamka();
  
  //== KONSTANTNÍ ATRIBUTY INSTANCÍ ========================
  /** vytvoření listu mužů*/
  private List<Osoba> seznamMuzu;
  /** vytvoření listů žen*/
  private List<Osoba> seznamZen;
 
  //== PROMĚNNÉ ATRIBUTY INSTANCÍ ==========================
  /** vytvoření pozice pro sraz mužů*/
  private Pozice srazMuzu;
  /** vytvoření pozice pro sraz žen*/
  private Pozice srazZen;
  /** vytvoření pozice pro setkání mužů a žen*/
  private Pozice mistoSchuzky;
  /** vytvoření přesouvače pro přesunutí žen a mužů*/
  private Presouvac presouvac;
  
  //########################################################
  //== KONSTRUKTORY A TOVÁRNÍ METODY =======================

  /**
   * Vytvoří listy a nastaví základní proměnné
   */
  private Seznamka() {
    this.seznamMuzu = new ArrayList<>();
    this.seznamZen = new ArrayList<>();
    setSrazMuzu(DEF_SRAZ_MUZI);
    setSrazZen(DEF_SRAZ_ZENY);
    setMistoSchuzky(DEF_SETKANI);
    setPresouvac(DEF_RYCHLOST);
    
  }
  
  /**
   * Vrací nám seznamku
   * @return INSTANCE vrátí nám celou seznamku
   */
  public static Seznamka getSeznamka() {
    return INSTANCE;
  }

  //########################################################
  //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ ===============
  /**
   * Změní pozici srazu mužů
   * pokud již v seznamumužů nějací jsou, změní všem souřadnice
   *
   * @param pozice nová pozice srazu
   */
  public void setSrazMuzu(Pozice pozice) {
    srazMuzu = pozice;
    for(Osoba muz :seznamMuzu){
      muz.setPozice(pozice);
    }
  }
  
  /**
   * Změní pozici srazu žen
   * pokud již v seznamu žen nějaké jsou, změní všem souřadnice
   *
   * @param pozice nová pozice srazu
   */
  public void setSrazZen(Pozice pozice) {
    srazZen = pozice;
    for(Osoba zena :seznamZen){
      zena.setPozice(pozice);
    }
  }
  
  /** 
   * Změní místo schůzky
   *
   * @param pozice nová pozice schůzky
   */
  public void setMistoSchuzky(Pozice pozice) {
    this.mistoSchuzky = pozice;
  }
  
  /**
   * Vytvoří nový přesouvač
   *
   * @param rychlost rychlost přesouvání
   */
  public void setPresouvac(int rychlost) {
    this.presouvac = new Presouvac(rychlost);
  }
  
  
  /**
   * Připraví seznamku na nové lidi,
   *   tj. vymaže původní seznamy mužů a žen
   * Všechna ostatní nastavení seznamky ponechá
   */
  public void vymazVsechnyLidi() {
    this.seznamMuzu.clear();
    this.seznamZen.clear();
  }  
  //== PUBLIC METODY INSTANCÍ ==============================
  
  /**
   * Přidá muže do seznamu
   * přidávanému muži nastaví pozici srazu mužů 
   *
   * @param muz přidávaný muž
   */ 
   public void pridejMuze(Osoba muz)
   {
     muz.setPozice(srazMuzu);
     seznamMuzu.add(muz);
   }
   
  /**
   * Přidá ženu do seznamu
   * přidávané ženě nastaví pozici srazu žen
   *
   * @param zena přidávaná žena
   */
   public void pridejZenu(Osoba zena) {
     zena.setPozice(srazZen);
     seznamZen.add(zena);
   }
   
  /**
   * postupně zařizuje schůzky všem kombinacím párů z obou seznamů
   * pokud se sejde instance Superman a Superwoman, jsou považovány za ► ideální pár,
   * který společně odejde na určené místo
   *
   * @param spolecnyOdchod cílová pozice společného odchodu vybraného páru
   * @param dobaCekani v milisec mezi jednotlivými schůzkami
   * @return počet uskutečněných setkání
   */
   public int realizujSchuzky(Pozice spolecnyOdchod, int dobaCekani)
   {
     int pocetSetkani = 0;
     
     vnejsiCyklus:
     for (Iterator<Osoba> itZen = seznamZen.iterator(); itZen.hasNext(); ){
       Osoba zena = itZen.next();
       for (Iterator<Osoba> itMuzu = seznamMuzu.iterator(); itMuzu.hasNext(); ){
         Osoba muz = itMuzu.next();
         Rande rande = new Rande(muz, zena);
         
         Par par = rande.jdouNaRande(mistoSchuzky, presouvac);
         pocetSetkani++;
         IO.cekej(dobaCekani);
         
         // Hledani idealniho paru
         if(zena instanceof Superwoman && muz instanceof Superman){
            Zvyraznovac zvyraznovac = new Zvyraznovac();
            Obdelnik obd = zvyraznovac.zvyrazniPozadi(par, Barva.STRIBRNA);
            //IO.zprava("Ideální pár");
            SP.odstran(obd);
            rande.parJdeSpolecne(par, spolecnyOdchod, presouvac);
            itZen.remove();
            itMuzu.remove();
            SP.odstran(zena);
            SP.odstran(muz);
            continue vnejsiCyklus;
         }
         // Neni to idealni par
         else {
           presouvac.presunNa(srazMuzu, muz);
           presouvac.presunNa(srazZen, zena);
           SP.odstranVse();
         }
         //IO.cekej(dobaCekani);
         //SP.odstranVse();
       }
     }
     
     return pocetSetkani;
   }
  
  //== PRIVATE METODY INSTANCÍ =============================
}
































