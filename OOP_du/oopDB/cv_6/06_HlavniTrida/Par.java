/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

/***************************************************************
 * Instance třídy {@code Par} představují pár muže a ženy na schůzce
 * instance je použita proto, aby se oba spolu přesouvali
 *
 * POZOR! Třída je jen polotovar, který je nutné značně doplnit.
 * 
 * @author  Mukanova Zhanel
 * @version 1.00.0000 — 2017-10-31
 */
public class Par implements IPosuvny {
  //== KONSTANTNÍ ATRIBUTY TŘÍDY ===========================
  /** vytvoreni noveho spravce platna */   
  private static final SpravcePlatna SP = SpravcePlatna.getInstance();
  //== KONSTANTNÍ ATRIBUTY INSTANCÍ ========================
  /**Konstatka muze dateveho typu Osoba**/
  private final Osoba muz;
  /**Konstatka zeny dateveho typu Osoba**/
  private final Osoba zena;
  
  //== PROMĚNNÉ ATRIBUTY INSTANCÍ ==========================

  //########################################################
  //== KONSTRUKTORY A TOVÁRNÍ METODY =======================

  /************************************************************
   * Převezme instance muže a ženy, kteří přišli na rande
   * 
   * @param muz  muž, který přišel na rande
   * @param zena žena, která přišla na rande
   */
  public Par(Osoba muz, Osoba zena) {
   this.muz = muz;
   this.zena = zena;
    
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
     return this.zena.getPozice();
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
    this.zena.setPozice(x, y);
    int xMuz = x + this.zena.getSirka();
    this.muz.setPozice(xMuz, y);
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
  //== PRIVATE METODY TŘÍDY ================================

  //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ ===============
  
  //== PUBLIC METODY INSTANCÍ ==============================
  
  //== PRIVATE METODY INSTANCÍ =============================
}
