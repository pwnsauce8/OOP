package kolekce;
/**
 * Instance třídy {@code RozvrhovaAkce} predstavuji Rozvrhovou akci
 * 
 * @author  Mukanova Zhanel
 * @version 1.00.0000 — 2017-11-28
 */
public class RozvrhovaAkce {
  
  /** nazev katedry */	
  private String katedra;
 
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((katedra == null) ? 0 : katedra.hashCode());
	result = prime * result + ((predmet == null) ? 0 : predmet.hashCode());
	result = prime * result + ((semestr == null) ? 0 : semestr.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	RozvrhovaAkce other = (RozvrhovaAkce) obj;
	if (katedra == null) {
		if (other.katedra != null)
			return false;
	} else if (!katedra.equals(other.katedra))
		return false;
	if (predmet == null) {
		if (other.predmet != null)
			return false;
	} else if (!predmet.equals(other.predmet))
		return false;
	if (semestr == null) {
		if (other.semestr != null)
			return false;
	} else if (!semestr.equals(other.semestr))
		return false;
	return true;
}

/** nazev predmetu */
  private String predmet;
  /** typ studia */
  private String typ;
  /** semestr ve kterem probiha vyuka */
  private String semestr;
	
  /**
   * Objekt, ktery naplni zakladni hodnoty
   * @param katedra katedra predmetu
   * @param predmet urcity predmet
   * @param typ     typ predmetu
   * @param semestr v jakem semestru probiha
   */
    public RozvrhovaAkce(String katedra, String predmet, String typ, String semestr) {
		this.katedra = katedra;
		this.predmet = predmet;
		this.typ = typ;
		this.semestr = semestr;
	}
  
    /**
     * Vraci katedru
     * @return katedra
     */
	public String getKatedra() {
		return katedra;
	}
	
	/**
	 * Vraci predmet
	 * @return predmet
	 */
	public String getPredmet() {
		return predmet;
	}
	
	/**
	 * Vraci typ predmetu
	 * @return typ
	 */
	public String getTyp() {
		return typ;
	}
	
	/**
	 * Vraci semestr
	 * @return semestr
	 */
	public String getSemestr() {
		return semestr;
	}

	/**	
	 * Vypisuje retezec do souboru
	 * @return retezec, ktery se bude zpisovat do souboru
	 */
	@Override
	public String toString() {
		return "[katedra=" + katedra + ", predmet=" + predmet + ", semestr=" + semestr + ", typ=" + typ
				+ "]";
	}
	
}
