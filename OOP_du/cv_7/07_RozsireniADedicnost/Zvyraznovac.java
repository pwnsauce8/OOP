/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

/***************************************************************
 * Instance třídy {@code Zvyraznovac} představují Služebníka,
 * který dokáže vykresit obdélník ohraničující kreslený objekt
 * na pozadí tohoto objektu.
 * Objekt musí být instancí třídy implementujícírozhraní
 * {@link IZvyrazneny}.
 * 
 * @author  Mukanova Zhanel
 * @version 1.00.0000 — 2017-10-24
 */
public class Zvyraznovac {
  //== KONSTANTNÍ ATRIBUTY TŘÍDY ===========================
  
  /** Vytvori promennou pro pristup ke spravci platna*/
  private static final SpravcePlatna SP = SpravcePlatna.getInstance();
  /** Počet pixelů standardně přidaných na každou stranu zvýrazňovaného obrazce*/
  private static final int IMPLICITNE_PRIDANO = 10;
  /** počet pixelů, které se budou skutečně přidávat na každou stranu zvýrazňovaného obrazce” */
  private int pridano;

  //########################################################
  //== KONSTRUKTORY A TOVÁRNÍ METODY =======================

  /**
   * Základní konstruktor
   */
  public Zvyraznovac() {
    this(IMPLICITNE_PRIDANO);
  }
  
  /**
   * Konstruktor
   * 
   * @param pridano    přidá počet pixelu, který jsme si zadali
   */
  public Zvyraznovac(int pridano) {
    this.pridano = pridano;
  }

  //########################################################
  //== PUBLIC METODY TŘÍDY =================================
  /**
  * Kreslený objekt zvýrazní tím, že danou barvou vykreslí na pozadí objektu
  * ohraničující obdélník, jehož rozměry jsou na všechny strany zvětšeny oproti
  * rozměrům zvýrazňovaného objektu o hodnotu {@code pridano}.
  *
  * @param objekt zvýrazňovaný objekt
  * @param barva barva zvýrazňujícího obdélníka na pozadí
  * @return zvýrazňující obdélník
  */
  public Obdelnik zvyrazniPozadi(IZvyrazneny objekt, Barva barva) {
    Oblast oblast = zjistiOblastZvyrazneni(objekt);
    
    Obdelnik obd = new Obdelnik(oblast, barva);
    SP.pridejDospod(obd);
    return obd;
  }
  
  /**
  * Kreslený objekt zvýrazní tím, že danou barvou vykreslí na pozadí objektu
  * ohraničující elipsu, jejíž rozměry jsou na všechny strany zvětšeny oproti
  * rozměrům zvýrazňovaného objektu o hodnotu {@code pridano}.
  *
  * @param objekt zvýrazňovaný objekt
  * @param barva barva zvýrazňující elipsy na pozadí
  * @return zvýrazňující elipsa
  */
  public Elipsa zvyrazniPozadiElipsou (IZvyrazneny objekt, Barva barva) {
    Oblast oblast = zjistiOblastZvyrazneni(objekt);
    
    Elipsa elipsa = new Elipsa(oblast, barva);
    SP.pridejDospod(elipsa);
    return elipsa;
  }
  
  /*** Vrátí Oblast zvýrazňovaného objektu zvětšenou na všechny strany
   *
   * @param objekt zvýrazňovaný objekt
   * @return oblast, ve které bude později vykreslen zvýrazňující tvar
   */
  public Oblast zjistiOblastZvyrazneni(IZvyrazneny objekt){
    int x = objekt.getPozice().getX() - pridano;
    int y = objekt.getPozice().getY() - pridano;
    Pozice pocatek = new Pozice(x, y);
    
    int sirka = objekt.getSirka() + 2 * pridano;
    int vyska = objekt.getVyska() + 2 * pridano;
    Rozmer rozmer = new Rozmer(sirka, vyska);
    
    return new Oblast(pocatek, rozmer);
  }
  
  //== PRIVATE METODY TŘÍDY ================================

  //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ ===============
  
  //== PUBLIC METODY INSTANCÍ ==============================
  
  //== PRIVATE METODY INSTANCÍ =============================
}
