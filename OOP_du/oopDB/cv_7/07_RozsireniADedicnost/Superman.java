/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

/************************************************************
 * Instance třídy {@code Superman} představují Supermana
 *
 * @author  Mukanova Zhanel
 * @version 1.00.0000 — 2017-11-07
 */
public class Superman  extends Osoba{
  //== KONSTANTNÍ ATRIBUTY TŘÍDY ===========================
  /** Pomer sirky znaku a tela**/
  private static final double POMER_ZNAK_TELO = 3.0/5.0;
  //== KONSTANTNÍ ATRIBUTY INSTANCÍ ========================
  /** Vytvoreni znaku **/
  private final Trojuhelnik znak;
  /** posun znaku vuci tělu - bude stejny v X i Y souradnici**/
  private final int posunZnaku;

  //########################################################
  //== KONSTRUKTORY A TOVÁRNÍ METODY =======================
  /************************************************************
   * vytvoří instanci libovolného rozměru na zadané pozici
   * tělo je vždy modré, standardních rozměrů Osoby
   * znak je vždy červený orientovaný vrcholem dolů
   * znak je v poměru k tělu a je odsazen o {@code posunZnaku}
   * vůči X i Y souřadnici těla
   *
   * @param pozice          pozice zobrazení
   * @param velikostHlavy   velikost hlavy, podle které se vytvoří poměrově osoba
   */ 
  public Superman(Pozice pozice, int velikostHlavy) {
    super(pozice, velikostHlavy, Barva.MODRA);
    int sirkaZnaku = (int) (this.telo.getSirka() * POMER_ZNAK_TELO);
    this.posunZnaku = (this.telo.getSirka() - sirkaZnaku) / 2;
    Pozice pozZnak = new Pozice(telo.getPozice().x + this.posunZnaku,
                                telo.getPozice().y + this.posunZnaku );
    Rozmer rozZnak = new Rozmer(sirkaZnaku, sirkaZnaku);
    this.znak = new Trojuhelnik(pozZnak, rozZnak, Barva.CERVENA, Smer8.JIH);
  }
 
  /************************************************************
  * vytvoří instanci standardního rozměru na zadané pozici
  *
  * @param pozice pozice zobrazení
  */
  public Superman(Pozice pozice){
    this(pozice, IMPL_VELIKOST_HLAVY);
  }

  /************************************************************
  * vytvoří instanci standardního rozměru v levém horním rohu
  */
  public Superman(){
    this(new Pozice (0, 0));
  }

  //########################################################
  //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ ===============
  /**
   * Vrátí nám znak na tělo Supermana
   * @return znak vrací nám všechny hodnoty znaku
   */
  public Trojuhelnik getZnak() {
    return znak;
  }
  //== PUBLIC METODY INSTANCÍ ==============================
  
  /** 
   * Překryje původní metodu: vykreslí Supermana + se přidá i vykreslení znaku na těle
   */
  @Override
  public void nakresli(Kreslitko kreslitko) {
    SP.nekresli(); {
      super.nakresli(kreslitko);
      znak.nakresli(kreslitko);
    } SP.vratKresli();
  }
  
  /** 
   * Překryje původní metodu: přesouvá celého Supermana
   * 
   * @param   x   nová pozice na souradnice X
   * @param   y   nová pozice na souradnice Y
   */
  @Override
  public void setPozice(int x, int y) {
    super.setPozice(x, y);
    znak.setPozice(posunZnaku + telo.getX(), posunZnaku + telo.getY()); 
  }
}
