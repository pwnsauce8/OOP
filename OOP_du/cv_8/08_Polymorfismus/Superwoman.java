/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

/************************************************************
 * Instance třídy {@code Superwoman} představují Superwoman
 *
 * @author  Mukanova Zhanel
 * @version 2.00.0000 — 2017-11-21
 */
public class Superwoman extends Osoba{
  //== KONSTANTNÍ ATRIBUTY TŘÍDY =========================== 
  /** Pomer sirky znaku a tela**/
  private static final double POMER_ZNAK_TELO = 2.5/5.0;
  //== KONSTANTNÍ ATRIBUTY INSTANCÍ ========================
  /** konstanta pro tělo Superwoman*/
  private final Trojuhelnik superTelo;
  /** Vytvoreni znaku **/
  private final Trojuhelnik znak;
  /** Posun znaku vuci tělu - bude stejny v X i Y souradnici**/
  private final int posunZnaku;
  /** vytvoření pismena S na těle Superwoman*/ 
  private final Text pismenoS;
  /** posun x-ové souřadnice znaku S*/ 
  private final int xPosunSkTelu;
  /** posun y-ové souřadnice znaku S*/ 
  private final int yPosunSkTelu;
  //########################################################
  //== KONSTRUKTORY A TOVÁRNÍ METODY =======================
  /************************************************************
  * vytvoří Superwoman standardního rozměru na zadané pozici
  *
  * @param pozice pozice zobrazení
  */
  public Superwoman(Pozice pozice){
    this(pozice, IMPL_VELIKOST_HLAVY);
  }

  /************************************************************
  * vytvoří Superwoman standardního rozměru v levém horním rohu
  */
  public Superwoman(){
    this(new Pozice (0, 0));
  }

  /************************************************************
  * vytvoří instanci libovolného rozměru na zadané pozici 
  * trojúhelníkové tělo {@code superTelo} je vždy černé,
  * šířky a výšky původního těla Osoby
  * na těle je červený trojúhelníkový znak {@code znak}
  * a na něm tučné žluté písmeno S {@code pismenoS}
  *
  * @param pozice pozice zobrazení
  * @param velikostHlavy velikost hlavy, podle které se vytvoří poměrově osoba
  */
  public Superwoman(Pozice pozice, int velikostHlavy) {
    super(pozice, velikostHlavy, Barva.ZADNA);
    
     // superTelo
    superTelo = new Trojuhelnik(telo.getPozice(), telo.getRozmer(), 
                                Barva.CERNA, Smer8.JIH);
                                
    // vytvareni znaku
    int sirkaZnaku = (int) (this.telo.getSirka() * POMER_ZNAK_TELO);
    this.posunZnaku = (this.telo.getSirka() - sirkaZnaku) / 2;
    Pozice pozZnak = new Pozice(telo.getPozice().x + this.posunZnaku,
                                telo.getPozice().y + this.posunZnaku );
    Rozmer rozZnak = new Rozmer(sirkaZnaku, sirkaZnaku);
    this.znak = new Trojuhelnik(pozZnak, rozZnak, Barva.CERVENA, Smer8.JIH);
    
    // pismeno 'S'
    int velikost = znak.getVyska();
    xPosunSkTelu = (int) (velikost / 1.4);
    yPosunSkTelu = velikost / 5; 
    pismenoS = new Text(telo.getX() + xPosunSkTelu, telo.getY() + yPosunSkTelu, Barva.ZLUTA, "S");
    pismenoS.setFont("Serif", Text.TUCNY, velikost);
  }
  
 
  //########################################################
  //== PUBLIC METODY INSTANCÍ ==============================
   /** 
   * Překryje původní metodu: vykreslí Supermana + se přidá i vykreslení znaku na těle
   */
  @Override
  public void nakresli(Kreslitko kreslitko) {
    SP.nekresli(); {
      super.nakresli(kreslitko);
      superTelo.nakresli(kreslitko);
      znak.nakresli(kreslitko);
      pismenoS.nakresli(kreslitko);
    } SP.vratKresli();
  }
  
  /** 
   * Překryje původní metodu: přesouvá celého Superwoman
   * 
   * @param   x   nová pozice na souradnice X
   * @param   y   nová pozice na souradnice Y
   */
  @Override
  public void setPozice(int x, int y) {
    super.setPozice(x, y);
    Pozice poz = this.telo.getPozice();
    superTelo.setPozice(poz.x, poz.y);
    znak.setPozice(poz.x + this.posunZnaku, poz.y + this.posunZnaku); 
    pismenoS.setPozice(poz.x + this.xPosunSkTelu, poz.y + this.yPosunSkTelu); 
  }
  //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ ===============
  /**
   * Vrací nám hodnoty těla Superwoman
   * @return superTelo vrací nám všechny jeho hodnoty
   */
  public Trojuhelnik getSuperTelo(){
    return superTelo;
  }

  /**
   * Vrací nám hodnoty znaku
   * @return znak vrací nám všechny jeho hodnoty
   */
  public Trojuhelnik getZnak(){
    return znak;
  }

  /**
   * Vrátí nám hodnoty písmena S na znaku Superwoman
   * @return pismenoS vrací nám všechny jeho hodnoty
   */
  public Text getPismenoS() {
    return pismenoS;
  }
}
