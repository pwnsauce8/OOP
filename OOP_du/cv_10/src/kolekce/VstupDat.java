package kolekce;
/**
 * Instance třídy {@code RozvrhovaAkce} predstavuji tridu, ktera nacte data ze souboru
 * 
 * @author  Mukanova Zhanel
 * @version 1.00.0000 — 2017-11-28
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Rozhraní pro vstup
 * @author Pavel Herout
 */

public class VstupDat implements INacitani {
	/** Vytvori objekt */
	private static final VstupDat INSTANCE = new VstupDat();
	
	/**
	 * Privatni konstruktor
	 */
	private VstupDat() {
		// opravdu prazdny metod - je to jedenacek
	}
	
	/**
	 * Vrati nam instanci typu VstupDat
	 * @return INSTANCE instance pro praci s metodami
	 */
	static VstupDat getInstance() {
		return INSTANCE;

	}
	
	/**
	 * Načte z textového souboru údaje o všech rozvrhových akcích a vrátí je jako
	 * seznam objektů třídy {@code RozvrhovaAkce} využívá služeb metody
	 * {@code vytvorRozvrhovouAkci()}
	 * 
	 * @param celeJmenoSouboru
	 *            úplné jméno souboru včetně cesty
	 * @return seznam rozvrhových akcí
	 */
	@Override
	public List<RozvrhovaAkce> nactiRozvrhoveAkce(String celeJmenoSouboru) {
		List<RozvrhovaAkce> seznam = new ArrayList<>();
		try {
			List<String> radky = Files.readAllLines(Paths.get(celeJmenoSouboru));
			for (String radka : radky) {
				seznam.add(vytvorRozvrhovouAkci(radka));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return seznam;
	}

	/**
	 * Z řetězce, ve kterém je uložena informace o rozvrhové akci, vyrobí objekt
	 * {@code RozvrhovaAkce} Formát řetězce je: jméno katedry;jméno předmětu;typ
	 * předmětu;semestr např.: KAE;CESA;Pr;LS
	 * 
	 * @param csvRadek
	 *            řádek rozvrhové akce - údaje jsou odděleny středníky
	 * @return objekt aktuální RozvrhovaAkce
	 */
	@Override
	public RozvrhovaAkce vytvorRozvrhovouAkci(String csvRadek) {
		String[] pole =  csvRadek.split(";");
		return new RozvrhovaAkce(pole[0], pole[1], pole[2], pole[3]);
		
	}
}
