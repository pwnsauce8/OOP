package kolekce;

import java.util.List;

/**
 * Rozhraní pro vstup
 * @author Pavel Herout
 */
public interface INacitani {
  
  /**
   * Načte z textového souboru údaje o všech rozvrhových akcích 
   * a vrátí je jako seznam objektů třídy {@code RozvrhovaAkce}
   * využívá služeb metody {@code vytvorRozvrhovouAkci()}
   * 
   * @param celeJmenoSouboru úplné jméno souboru včetně cesty 
   * @return seznam rozvrhových akcí
   */
//  @Override
  public List<RozvrhovaAkce> nactiRozvrhoveAkce(String celeJmenoSouboru);
  
  /**
   * Z řetězce, ve kterém je uložena informace o rozvrhové akci, vyrobí 
   * objekt {@code RozvrhovaAkce}
   * Formát řetězce je: 
   * jméno katedry;jméno předmětu;typ předmětu;semestr
   * např.:
   * KAE;CESA;Pr;LS
   * 
   * @param csvRadek řádek rozvrhové akce - údaje jsou odděleny středníky
   * @return objekt aktuální RozvrhovaAkce
   */
//  @Override
  public RozvrhovaAkce vytvorRozvrhovouAkci(String csvRadek);
}
