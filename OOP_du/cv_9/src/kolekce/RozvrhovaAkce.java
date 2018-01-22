package kolekce;

public class RozvrhovaAkce {
  
  /** */	
  private String katedra;
  /** */
  private String predmet;
  /** */
  private String typ;
  /** */
  private String semestr;
	
  /**
   * Konstruktor
   * @param katedra
   * @param predmet
   * @param typ
   * @param semestr
   */
    public RozvrhovaAkce(String katedra, String predmet, String typ, String semestr) {
		this.katedra = katedra;
		this.predmet = predmet;
		this.typ = typ;
		this.semestr = semestr;
	}
  
    /**
     * 
     * @return
     */
	public String getKatedra() {
		return katedra;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPredmet() {
		return predmet;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTyp() {
		return typ;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSemestr() {
		return semestr;
	}

	/**	
	 * Vypisuje na consol 
	 */
	@Override
	public String toString() {
		return "[katedra=" + katedra + ", predmet=" + predmet + ", semestr=" + semestr + ", typ=" + typ
				+ "]";
	}
	
	
	
	
}
