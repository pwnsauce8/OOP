/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

/************************************************************
 * Instance třídy {@code Rande} představují třídu, která slouží k přesunutí dvou 
 * osob (muže a ženy) na rande.
 *
 * @author  Mukanova Zhanel
 * @version 1.00.0000 — 2017-10-31
 */
public class Rande {
  //== KONSTANTNÍ ATRIBUTY TŘÍDY ===========================
  /** Vytvoreni noveho spravce platna */
  private static final SpravcePlatna SP = SpravcePlatna.getInstance();
  //== KONSTANTNÍ ATRIBUTY INSTANCÍ ========================
  /** Konstatka muze dateveho typu Osoba pro práci s mužem**/
  private final Osoba muz;
  /** Konstatka zeny dateveho typu Osoba rro práci s zenou**/
  private final Osoba zena;
  /** Konstanta pro práci s "domovskou" pozicí muže */
  private final Pozice domaMuz;
  /** Konstanta pro práci s "domovskou" pozicí ženy */
  private final Pozice domaZena;
  
  //########################################################
  //== KONSTRUKTORY A TOVÁRNÍ METODY =======================

  /**
   *  Metoda vytvoří schůzku muže a ženy
   *  
   *  @param muz  hodnota muže tridy Osoba
   *  @param zena hodnota ženy tridy Osoba
   */
  public Rande(Osoba muz, Osoba zena) {
    this.muz = muz;
    this.zena = zena;
    this.domaMuz = muz.getPozice();
    this.domaZena = zena.getPozice();
    zajistiZobrazeniOsoby(muz);
    zajistiZobrazeniOsoby(zena);
  }

  //########################################################
  
  
  //== PRIVATE METODY TŘÍDY ================================

  //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ ===============
  /************************************************************
  * Zajistí zobrazení osoby, která může, ale nemusí být již
  * dříve zobrazena
  *
  * @param osoba existující osoba
  * @return true v případě, když byla osoba opravdu nově zobrazena,
  *         false v případě, když již mezi zobrazovanými byla */
  public boolean zajistiZobrazeniOsoby(Osoba osoba)
  {
    if (SP.poradi(osoba) < 0) {
      osoba.zobraz();
      return true;
    }
    else {
      return false;
    }
  }

  /**
     * Metoda pro přesunutí muže a ženy na místo rande
     * 
     * @param   mistoSchuzky jsou souřadnice ženy
     * @param   chuzeNaRande rychlost chuze
     * @return  Vratí instanci tridy Par muže a ženu na schůzce
     */
  public Par jdouNaRande(Pozice mistoSchuzky, Presouvac chuzeNaRande){
    Pozice muzMisto = new Pozice(mistoSchuzky.x + this.zena.getSirka(), mistoSchuzky.y);
    chuzeNaRande.presunNa(muzMisto, this.muz);
    chuzeNaRande.presunNa(mistoSchuzky, this.zena);  
  
    return new Par(this.muz, this.zena);
  }
  //pro testovaci ucely

   /**
    * Vrátí nám hodnoty muže
    * 
    * @return hodnoty muže
    */
  public Osoba getMuz(){
    return muz;
  }

  /**
    * Vrátí nám hodnoty ženy
    * 
    * @return hodnoty ženy
    */
  public Osoba getZena(){
    return zena;
  }

  /**
    * Vrátí nám "domovskou" pozici muže
    * 
    * @return vrací "domovskou" pozici muže
    */
  public Pozice getDomaMuz(){
    return domaMuz;
  }
    
  /**
    * Vrátí nám "domovskou" pozici ženy
    * 
    * @return vrací "domovskou" pozici ženy
    */
  public Pozice getDomaZena(){
    return domaZena;
  } 
  //== PUBLIC METODY INSTANCÍ ==============================
  
  /**
    * Muž i žena se přesouvají najednou
    * 
    * @param par          objekt, který obsahuje muže i ženu třídy Par
    * @param mistoVyletu  pozice, kam se má pár přesunout
    * @param chuzeSpolu   rychlost chůze
    */
  public void parJdeSpolecne(Par par, Pozice mistoVyletu, Presouvac chuzeSpolu){
    chuzeSpolu.presunNa(mistoVyletu, par);
  
  }

  /**
     * Muž doprovodí ženu na "domácí" pozici a vrátí se na svojí "domácí" pozici
     * 
     * @param par        objekt, který obsahuje muže i ženu
     * @param chuzeDomu  rychlost chůze
     */
  public void jdouDomu(Par par, Presouvac chuzeDomu){
    chuzeDomu.presunNa(domaZena, par);
    chuzeDomu.presunNa(domaMuz, muz);
  }
}
