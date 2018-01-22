/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

/***************************************************************
 * Instance třídy {@code Par} představují pár muže a ženy na schůzce
 * instance je použita proto, aby se oba spolu přesouvali
 *
 * POZOR! Třída je jen polotovar, který je nutné značně doplnit.
 * 
 * @author  Mukanova Zhanel
 * @version 2.00.0000 — 2017-11-14
 */
public class Par implements IZvyrazneny {
  //== KONSTANTNÍ ATRIBUTY TŘÍDY ===========================
  /** vytvoreni noveho spravce platna */   
  private static final SpravcePlatna SP = SpravcePlatna.getInstance();
  //== KONSTANTNÍ ATRIBUTY INSTANCÍ ========================
  /**Konstatka muze dateveho typu Osoba**/
  private final Osoba muz;
  /**Konstatka zeny dateveho typu Osoba**/
  private final Osoba zena;
  /**Pro posouváný y-souřadnice muže při rozdílu výšek muže a ženy*/
  private final int yPosunMuze;
  /**Pro posouváný y-souřadnice ženy při rozdílu výšek muže a ženy*/
  private final int yPosunZeny;
  //########################################################
  //== KONSTRUKTORY A TOVÁRNÍ METODY =======================

  /************************************************************
   * Převezme instance muže a ženy, kteří přišli na rande
   * 
   * @param muz   muž, který přišel na rande
   * @param zena  žena, která přišla na rande
   */
   public Par(Osoba muz, Osoba zena) {
     this(muz, zena, 0, 0);
   }

  //########################################################
  //== PUBLIC METODY TŘÍDY =================================
  /************************************************************
   * Vrátí instanci třídy {@code Pozice} s aktuální pozicí instance.
   *
   * @return  Aktuální pozici v instanci třídy {@code Pozice} 
   */
   @Override
   public Pozice getPozice(){
     Pozice poz = this.zena.getPozice();
     return new Pozice(poz.x, poz.y - yPosunZeny);
   }

  /**************************************************************
  * Nastaví novou pozici instance.
  *
  * @param x  Nově nastavovaná vodorovná (x-ová) souřadnice instance,
  *           x=0 má levý okraj plátna, souřadnice roste doprava
  * @param y  Nově nastavovaná svislá (y-ová) souřadnice instance,
  *           y=0 má horní okraj plátna, souřadnice roste dolů
  */
  @Override
  public void setPozice(int x, int y){
    this.zena.setPozice(x, y + yPosunZeny);
    int xMuz = x + this.zena.getSirka();
    this.muz.setPozice(xMuz, y + yPosunMuze);
  }
  
  /***************************************************************************
  * Prostřednictvím dodaného kreslítka vykreslí obraz své instance.
  *
  * @param kreslitko Kreslítko, které nakreslí instanci
  */
  @Override
  public void nakresli(Kreslitko kreslitko){
    SP.nekresli(); {     
      muz.nakresli(kreslitko);
      zena.nakresli(kreslitko);
    } SP.vratKresli();
  }
  
  /************************************************************
  * Převezme instance muže a ženy, kteří přišli na rande
  * včetně jejich výškových posunů
  *
  * @param muz        muž, který přišel na rande
  * @param zena       žena, která přišla na rande
  * @param yPosunMuze vyskovy posun muze, aby byl par na stejne dolni urovni
  * @param yPosunZeny vyskovy posun zeny, aby byl par na stejne dolni urovni
  */
  public Par(Osoba muz, Osoba zena, int yPosunMuze, int yPosunZeny) {
    this.muz = muz;
    this.zena = zena;
    this.yPosunMuze = yPosunMuze;
    this.yPosunZeny = yPosunZeny;
    
  }

  //== PUBLIC METODY INSTANCÍ ==============================
  /**
   * Vrací výšku páru
   * @return vrací výšku celého páru (třeba ženy, tady to je jedno)
   */
  @Override
  public int getVyska() {
    return Math.max(this.muz.getVyska(), this.zena.getVyska());
  }

   /**
   * Vrací šířku páru
   * @return vrací šířku celého páru
   */
  @Override
  public int getSirka() {
    return this.muz.getSirka() + this.zena.getSirka();
  }
}
