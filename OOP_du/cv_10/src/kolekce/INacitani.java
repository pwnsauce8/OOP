/**
 * Rozhrani pro vstup dat
 * @author P.Herout
 */

package kolekce;

import java.util.List;

public interface INacitani {
  
  /**
   * Nacte z textoveho souboru udaje o vsech rozvrhovych akcich 
   * a vrati je jako seznam objektu tridy {@code RozvrhovaAkce}
   * vyuziva sluzeb metody {@code vytvorRozvrhovouAkci()}
   * 
   * @param celeJmenoSouboru uplne jmeno souboru vcetne cesty 
   * @return seznam rozvrhovych akci
   */
//  @Override
  public List<RozvrhovaAkce> nactiRozvrhoveAkce(String celeJmenoSouboru);
  
  /**
   * Z retezce, ve kterem je ulozena informace o rozvrhove akci, vyrobi
   * objekt {@code RozvrhovaAkce}
   * Format retezce je:
   * jmeno katedry;jmeno predmetu;typ predmetu;semestr
   * napr.:
   * KAE;CESA;Pr;LS
   * 
   * @param csvRadek radek rozvrhove akce - udaje jsou oddeleny stredniky
   * @return objekt aktualni RozvrhoveAkce
   */
//  @Override
  public RozvrhovaAkce vytvorRozvrhovouAkci(String csvRadek);
}
