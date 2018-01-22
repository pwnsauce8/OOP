/******************************************************************
 * Instance rozhraní {@code IPosuvny} představují geometrické tvary,
 * které umějí prozradit a nastavit svoji pozici.
 *
 * @author  Rudolf PECINOVSKÝ
 */
public interface IPosuvny extends IKresleny {
  //== SIGNATURY INSTANČNÍCH METOD ============================
  /************************************************************
  * Vrátí instanci třídy {@code Pozice} s aktuální pozicí instance.
  *
  * @return  Aktuální pozici v instanci třídy {@code Pozice} 
  */
//  @Override
  public Pozice getPozice();

 /**************************************************************
  * Nastaví novou pozici instance.
  *
  * @param x  Nově nastavovaná vodorovná (x-ová) souřadnice instance,
  *           x=0 má levý okraj plátna, souřadnice roste doprava
  * @param y  Nově nastavovaná svislá (y-ová) souřadnice instance,
  *           y=0 má horní okraj plátna, souřadnice roste dolů
  */
//  @Override
  public void setPozice(int x, int y);

  //== DEFAULT METODY =========================================
 /*************************************************************
  * Nastaví novou pozici instance.
  *
  * @param pozice   Nastavovaná pozice instance
  */
  public default void setPozice(Pozice pozice) {
    setPozice(pozice.x, pozice.y);
  }
}
