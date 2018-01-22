/**
 * Rozhrani pro zpracovani dat
 * @author P.Herout
 */

package kolekce;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public interface IZpracovani {

  /**
   * Metoda zpracovava vsechny {@code RozvrhovaAkce} ze vstupniho seznamu
   * Zpracovani probiha tak, ze vytvori mapu, jejimz klicem je nazev katedry
   * hodnotou je mnozina jednotlivych predmetu
   * protoze {@code RozvrhovaAkce} ma upravenou metodu equals() tak, aby
   * nerozlisovala typ predmetu (Pr, Cv, Se), staci do mnoziny vkladat
   * instance {@code RozvrhovaAkce} a duplicitni typy predmetu tam nebudou
   * vlozeny
   * 
   * @param seznamRozvrhovychAkci nacteny seznam {@code RozvrhovaAkce}
   * @return mapa, kde klicem je katedra a hodnotou mnozina objektu {@code RozvrhovaAkce}, 
   * kde kazda {@code RozvrhovaAkce} predstavuje jeden predmet - nerozlisuje se typ
   */
//@Override
  public Map<String, Set<RozvrhovaAkce>> slouciPredmety(
      List<RozvrhovaAkce> seznamRozvrhovychAkci);

  /**
   * Metoda zpracuje mapu katedro-predmetu
   * Z kazdeho prvku mapy udela jednu instanci {@code VyukaNaKatedre}
   * Je pouzita kolekce typu TreeSet, kdy instance {@code VyukaNaKatedre}
   * jsou automaticky vkladany ve spravnem poradi
   * 
   * @param mapa katedro-predmetu
   * @return serazena mnozina objektu {@code VyukaNaKatedre}
   */
//@Override
  public TreeSet<VyukaNaKatedre> zjistiPoctyNaKatedre(
      Map<String, Set<RozvrhovaAkce>> mapa);

  /**
   * Metoda zjisti pocet vsech vyucovanych predmetu
   * 
   * @param mnozina vyucovanych predmetu na katedrach
   * @return pocet vsech vyucovanych predmetu
   */
//@Override
  public int zjistiPocetVsechPredmetu(
      TreeSet<VyukaNaKatedre> mnozina);

}
