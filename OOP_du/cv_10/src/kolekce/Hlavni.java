package kolekce;
/**
 * Instance třídy {@code Hlavni} predstavuji hlavni tridu programu
 * 
 * @author  Mukanova Zhanel
 * @version 1.00.0000 — 2017-11-28
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Hlavni trida programu
 */
public class Hlavni {

	// Nacte vstupni soubor
	static void zpracujDataAZapisVysledky(String vstupniSoubor, String vystupniSoubor) {
		VstupDat vd = VstupDat.getInstance();
		List<RozvrhovaAkce> seznam = vd.nactiRozvrhoveAkce(vystupniSoubor);
		ZpracovaniDat zd = ZpracovaniDat.getInstance();
		Map<String, Set<RozvrhovaAkce>> mapa = zd.slouciPredmety(seznam);
		TreeSet<VyukaNaKatedre> mnozina = zd.zjistiPoctyNaKatedre(mapa);
		int pocet = zd.zjistiPocetVsechPredmetu(mnozina);
		
		try {
			PrintWriter pw = new PrintWriter(
							 new BufferedWriter(
							 new FileWriter( 
							 new File(vystupniSoubor))));
			pw.println("Pocet vsech rozvrhovych akci: " + seznam.size());
			pw.println("Pocet kateder: " + mapa.size());
			pw.println("Pocet ruznych predmetu: " + pocet);
			int poradi = 0;
			for (VyukaNaKatedre vnk : mnozina) {
				pw.println("" + poradi + ". " + vnk.toString());
				poradi++;
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metoda, prostřednictvím níž se spouští celá aplikace.
	 * 
	 * @param args celé jméno vstupního souboru 
	 * 			   celé jméno výstupního souboru
	 */
	public static void main(String[] args) {
		zpracujDataAZapisVysledky(args[0], args[1]);
	}

}
