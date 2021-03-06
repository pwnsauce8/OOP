
/**
 * Write a description of class Osoba here.
 * 
 * @author Mukanova Zhanel
 * @version 2.10.17
 */
public class Osoba
{
   
    /** zakladni barva hlavy */
    private static final Barva BARVA_HLAVY = Barva.RUZOVA;   
    /** zakladni barva tela */
    private static final Barva IMPL_BARVA_TELA = Barva.SEDA; 
    /** zakladni velikost hlavy */
    private static final int IMPL_VELIKOST_HLAVY = 60;        
    /** zakladni pomer hlavy ku telu */
    private static final double POMER_HLAVA_TELO = 6.0/8.0;
    /** zakladni pomer vysky ku sirce tela */
    private static final double POMER_TELO_VYS_SIR = 8.0/7.0;
    
    /** promenna pro pocet osob */
    private static int pocet = 1;  //
    /** co nova osoba, to v nazvu poradi je cislo o 1 vetsi */
    private final int PORADI = ++pocet;  
    /** nazev osoby */
    private String nazev = null;
    
    //== PROMĚNNÉ ATRIBUTY TŘÍDY ===============================================
    /** Volani objekta tridy Elipsa */
    private final Elipsa hlava;  
    /** Volani objekta tridy Obdelnik */
    private final Obdelnik telo; 
    

    /**
     * Vrátí třidu objekta hlava Osoby.
     * 
     * @return Vrátí třidu objekta Hlava Osoby.
     **/

    public Elipsa getHlava(){
        return hlava;
    }
    /**
     * Vrátí třidu objekta těla Osoby.
     * 
     * @return Vrátí třidu objekta Těla Osoby.
     */
    public Obdelnik getTelo(){
        return telo;
    }
    
    /**
     * Připraví objekt Osoba se zádanou pozici, 
     * rozměrem hlahy, 
     * poměrem Hlavy ke výšce těla, 
     * poměrem výšky těla k šířce těla Osoby 
     * a barvou.
     * 
     * @param x                  x-ova souřadnice instance
     * @param y                  y x-ova souřadnice instance                  
     * @param velikostHlavy      Vělikost hlavy vytvařené Osoby 
     * @param pomerHlavaTelo     Poměr hlavy ke výšce těla Osoby 
     * @param pomerTelo          Poměr výšky těla k šířce Osoby
     * @param barvaTela          Barva těla vytvařené Osoby
     * 
     **/
    public Osoba (int x, int y, int velikostHlavy, double pomerHlavaTelo, double pomerTelo, Barva barvaTela) {
        double vyskaTelo = (double)(velikostHlavy * Math.pow(pomerHlavaTelo,-1)); 
        double sirkaTelo = (double)(vyskaTelo * Math.pow(pomerTelo,-1)); 
        
        double xPosun = (double)(Math.abs(velikostHlavy - sirkaTelo) / 2); 
        double xPosunTelo = (velikostHlavy > sirkaTelo) ? xPosun : 0; 
        double xPosunHlava = (velikostHlavy < sirkaTelo) ? xPosun : 0; 
            
        this.hlava = new Elipsa(x+(int)xPosunHlava,y,velikostHlavy,velikostHlavy,BARVA_HLAVY); 
        this.telo = new Obdelnik(x+(int)xPosunTelo,y+velikostHlavy,(int)sirkaTelo,(int)vyskaTelo,barvaTela); 
    
    }
    
    /**
     * Připraví objekt Osoba se zadanou pozici, velikosti hlavy a barvou.
     * 
     * @param x                 x-ova souřadnice instance,               
     * @param y                 y-ova souřadnice instance,
     * @param velikostHlavy     Vělikost hlavy vytvařené Osoby
     * @param barvaTela         Barva těla vytvařené Osoby
     *               
     **/
    public Osoba(int x, int y, int velikostHlavy, Barva barvaTela)
    {
        this(x,y,velikostHlavy,POMER_HLAVA_TELO,POMER_TELO_VYS_SIR,barvaTela);
    }
    
    /**
     * Připraví objekt Osoba se zadanou pozici a barvou.
     * 
     * @param x                 x-ova souřadnice instance,               
     * @param y                 y-ova souřadnice instance,
     * @param barvaTela         Barva těla vytvařené Osoby
     *               
     **/
    public Osoba(int x, int y, Barva barvaTela)
    {
        this(x,y,IMPL_VELIKOST_HLAVY,POMER_HLAVA_TELO,POMER_TELO_VYS_SIR,barvaTela); 
    }
    
    /**
     * 
     * Vytvorí Osobu
     * 
     */
    public Osoba()
    {
        this(0,0,IMPL_VELIKOST_HLAVY,POMER_HLAVA_TELO,POMER_TELO_VYS_SIR,IMPL_BARVA_TELA); 
    } 
    
    /**
     * 
     * Vrátí x-ovou souřadnici pozice instance
     * 
     * @return x-ova souradnice
     * 
     **/
     public int getX()
    {
        return (hlava.getX() <= telo.getX()) ? hlava.getX() : telo.getX();
    }

    /**
     * 
     * Vrátí y-ovou souřadnici pozice instance
     * 
     * @return y-ova souradnice
     * 
     **/
    public int getY()
    {
        return (hlava.getY() <= telo.getY()) ? hlava.getY() : telo.getY();
    }
    
    /**
     * 
     * Vrátí šířku instance v bodech. Šířka instance jsou přitom definována jako šířka Osoby.
     * 
     * @return Aktuální šířka Osoby v bodech
     * 
     **/
    public int getSirka()
    {
        return (hlava.getSirka() >= telo.getSirka()) ? hlava.getSirka() : telo.getSirka(); 
    }
    
    /**
     * 
     * Vrátí výšku Osoby v bodech. Výška Osoby jsou přitom definována jako výška obdélníka + elipsy.
     * 
     * @return Aktuální výška Osoby v bodech
     * 
     **/
    public int getVyska()
    {
        return (hlava.getVyska() + telo.getVyska()); 
    }

    /**
     * 
     * Vrátí název třídy a jeji pořadi
     * 
     * @return nazev   Název třídy a jeji pořadi
     * 
     */
    public String getNazev()
    {
        return nazev + "" + PORADI;
    }

    /**
     * 
     * Vrátí aktuální barvu Osoby.
     * 
     * @return Instance třídy Barva definující aktuálně nastavenou barvu těla Osoby. 
     * 
     **/
    public Barva getBarvaTela()
    {
        return telo.getBarva();
    }
    
     /**
     * 
     * Nastaví novou barvu těla osoby 
     *
     * @param novaBarvaTela  nová požadovaná barva těla
     * 
     **/
    public void setBarvaTela(Barva novaBarvaTela)
    {
        telo.setBarva(novaBarvaTela); 
    }
    
    /**
     * Přepíše původní toString a vrátí nám výstup, který jsme si napsali
     * 
     * @return vrátí nám řetězec textu
     */
    public String toString()
    {
        return getNazev() + ": x=" + getX() + ", y=" + getY() + ", výška=" + getVyska() + ", šířka=" + getSirka() + ", barva těla=" + getBarvaTela();
    }
}
