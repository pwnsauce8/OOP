/* UTF-8 encoding: Příliš žluťoučký kůň úpěl ďábelské ódy. */

/************************************************************
 * Třída {@code Hlavni} je hlavní třídou projektu,
 * který ukáže muže a ženu na schůzce
 *
 * @author  Mukanova Zhanel
 * @version 1.00.0000 — 2017-10-31
 */
public class Hlavni {
  /**
   * Pouze na okrasu
   */
  private Hlavni(){}
  
  /**********************************************************
   * Metoda, prostřednictvím níž se spouští celá aplikace.
   *
   * @param args Parametry příkazového řádku
   */
  public static void main(String[] args) {
    int rychlostNaRande = Integer.parseInt(args[0]);
    int rychlostSpolu = Integer.parseInt(args[1]);
    int rychlostDomu = Integer.parseInt(args[2]);
    
    Pozice poziceM = new Pozice(10, 10);
    Pozice poziceZ = new Pozice(400, 150);
    Osoba muz = Osoba.getBeznyMuz(poziceM);
    Osoba zena = Osoba.getBeznaZena(poziceZ);
    
    Rande rande = new Rande(muz, zena);

    Presouvac chuzeNaRande = new Presouvac(rychlostNaRande);
    Pozice pS = new Pozice(150, 80);
    Par par = rande.jdouNaRande(pS, chuzeNaRande);
    SpravcePlatna SP = SpravcePlatna.getInstance(); //<--
    SP.pridej(par);
    
    Pozice pV = new Pozice(10, 10);
    Presouvac chuzeSpolu = new Presouvac(rychlostSpolu);
    rande.parJdeSpolecne(par, pV, chuzeSpolu);    
    
    Pozice pD = new Pozice(350, 10);
    rande.parJdeSpolecne(par, pD, chuzeSpolu);
    
    
    Pozice pK = new Pozice(10, 150);
    rande.parJdeSpolecne(par, pK, chuzeSpolu);
    
    Presouvac chuzeDomu = new Presouvac(rychlostDomu);
    rande.jdouDomu(par, chuzeDomu);

  }
}
