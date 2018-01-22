/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

/************************************************************
 * Instance rozhraní {@code IMeritelny} představují měřitelné objekty
 * které mají šířku a vyšku
 *
 * @author  Mukanova Zhanel
 * @version 1.00.0000 — 2017-10-24
 */
public interface IMeritelny {

//== SIGNATURY INSTANČNÍCH METOD ============================
  
  public int getVyska();

  public int getSirka();
  
//== DEFAULT METODY =========================================
  public default Rozmer getRozmer() {
    return new Rozmer(getSirka(), getVyska());
  }

}
