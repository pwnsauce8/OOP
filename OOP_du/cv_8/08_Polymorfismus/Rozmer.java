/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

/************************************************************
 * Instance třídy {@code Rozmer} představují přepravku uchovávající šířku a výšku instance
 *
 * @author  Mukanova Zhanel
 * @version 2.00.0000 — 2017-10-17
 */
public class Rozmer {
  //== KONSTANTNÍ ATRIBUTY INSTANCÍ ========================
  /** šírka osoby*/
  public final int sirka;
  /** výška osoby*/
  public final int vyska;
  //########################################################
  //== KONSTRUKTORY A TOVÁRNÍ METODY =======================

  /**
    * 
    * Připraví třidu Rozmer s zadanou širkou a vyšku.
    * 
    * @param   sirka   širka
    * @param   vyska   vyška
    * 
    **/
  public Rozmer(int sirka, int vyska){
    this.sirka = sirka;
    this.vyska = vyska;
  }

  //########################################################

  //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ ===============
  /**
    * 
    * Vrati hodnotu širky
    * 
    * @return  sirka   hodnota širky
    * 
    **/
  public int getSirka(){
   return this.sirka;
 }
 
 /**
    * 
    * Vrati hodnotu vyšky
    * 
    * @return  vyska   hodnota širky
    * 
    **/
 public int getVyska(){
   return this.vyska;
 }
  
  //== PUBLIC METODY INSTANCÍ ==============================
 /**
   * 
   * Vrati nazev třidy, rozmer širky a vyšky
   * 
   * @return pom     nazev třidy, rozmer širky a vyšky
   * 
   **/
 @Override
 public String toString(){
   String pom = this.getClass().getSimpleName() + 
                                  "[sirka=" + this.sirka + 
                                  ", vyska=" + this.vyska + "]";
   return pom;
 }
}
