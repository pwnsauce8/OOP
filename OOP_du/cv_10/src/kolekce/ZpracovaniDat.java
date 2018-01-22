package kolekce;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ZpracovaniDat implements IZpracovani {
	
	/** Vytvori objekt pro jedinacka */
	private static final ZpracovaniDat INSTANCE = new ZpracovaniDat();
	
	/**
	 * Privatni konstruktor
	 */
	private ZpracovaniDat() {
		// opravdu prazdny metod - je to jedenacek
	}
	
	/**
	 * Vrati nam instanci typu VstupDat
	 * @return INSTANCE instance pro praci s metodami
	 */
	static ZpracovaniDat getInstance() {
		return INSTANCE;

	}
	
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
	  @Override
	  public Map<String, Set<RozvrhovaAkce>> slouciPredmety(
	      List<RozvrhovaAkce> seznamRozvrhovychAkci){
		  
		  Map<String, Set<RozvrhovaAkce>> mapa = new HashMap<>();
		  
		  for (RozvrhovaAkce ra: seznamRozvrhovychAkci) {
			String katedra = ra.getKatedra();
			Set<RozvrhovaAkce> mnozina = null;
			if(mapa.containsKey(katedra) == false) {
				//zadny predmet teto katedry jeste nebyl ulozen
				// vytvoreni nove mnoziny
				mnozina = new HashSet<>();
			}
			else {
				// jiz existuje alespon 1 predmet ve mnozine
				mnozina = mapa.get(katedra);
			}
			mnozina.add(ra);
			mapa.put(katedra, mnozina);
		  }
		  
		  
		  
		  return mapa;
	  }

	  /**
	   * Metoda zpracuje mapu katedro-predmetu
	   * Z kazdeho prvku mapy udela jednu instanci {@code VyukaNaKatedre}
	   * Je pouzita kolekce typu TreeSet, kdy instance {@code VyukaNaKatedre}
	   * jsou automaticky vkladany ve spravnem poradi
	   * 
	   * @param mapa katedro-predmetu
	   * @return serazena mnozina objektu {@code VyukaNaKatedre}
	   */
	  @Override
	  public TreeSet<VyukaNaKatedre> zjistiPoctyNaKatedre(
	      Map<String, Set<RozvrhovaAkce>> mapa){
		  
		  TreeSet<VyukaNaKatedre> mnozina = new TreeSet<>();
		  
		  Set<Map.Entry<String, Set<RozvrhovaAkce>>> pomocnaMnozina = mapa.entrySet();
		  for (Map.Entry<String, Set<RozvrhovaAkce>> me :pomocnaMnozina) {
			  String katedra = me.getKey();
			  int pocet = me.getValue().size();
			  mnozina.add(VyukaNaKatedre(katedra, pocet));
		  }
		  
		  return mnozina;
	  }

	/**
	   * Metoda zjisti pocet vsech vyucovanych predmetu
	   * 
	   * @param mnozina vyucovanych predmetu na katedrach
	   * @return pocet vsech vyucovanych predmetu
	   */
	  @Override
	  public int zjistiPocetVsechPredmetu(
	      TreeSet<VyukaNaKatedre> mnozina){
		  
		  int pocetVsechPredmetu =  0;
		  for (VyukaNaKatedre vnk : mnozina) {
			  // VyukaNaKatedre je prepravka, tj. ma final atribute public
			  pocetVsechPredmetu += vnk.getPocet(); // pocet;
		  }
		  return pocetVsechPredmetu;
	  }

}
