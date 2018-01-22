
/**
 * Write a description of class Osoba here.
 * 
 * @author Mukanova Zhanel
 * @version 2.10.17
 */
public class Osoba
{
    // instance variables - replace the example below with your own
    private static final Barva BARVA_HLAVY = Barva.RUZOVA;
    private static final Barva IMPL_BARVA_TELA = Barva.SEDA;
    private static final int IMPL_VELIKOST_HLAVY = 60;
    private static final double POMER_HLAVA_TELO = 6.0/8.0;
    private static final double POMER_TELO_VYS_SIR = 8.0/7.0;
    
    private static int pocet = 0;
    private final int PORADI = ++pocet;
    private final String NAZEV = "Osoba_";
    
    private final Elipsa hlava;
    private final Obdelnik telo;
    

    /**
     * Constructor for objects of class Osoba
     */

    public Elipsa getHlava(){
        return hlava;
    }
    
    public Obdelnik getTelo(){
        return telo;
    }
    
    public Osoba (int x, int y, int velikostHlavy, double pomerHlavaTelo, double pomerTelo, Barva barvaTela) {
        double vyskaTelo = (double)(velikostHlavy * Math.pow(pomerHlavaTelo,-1)); 
        double sirkaTelo = (double)(vyskaTelo * Math.pow(pomerTelo,-1)); 
        
        double xPosun = (double)(Math.abs(velikostHlavy - sirkaTelo) / 2); 
        double xPosunTelo = (velikostHlavy > sirkaTelo) ? xPosun : 0; 
        double xPosunHlava = (velikostHlavy < sirkaTelo) ? xPosun : 0; 
            
        this.hlava = new Elipsa(x+(int)xPosunHlava,y,velikostHlavy,velikostHlavy,BARVA_HLAVY); 
        this.telo = new Obdelnik(x+(int)xPosunTelo,y+velikostHlavy,(int)sirkaTelo,(int)vyskaTelo,barvaTela); 
    
    }
    public Osoba(int x, int y, int velikostHlavy, Barva barvaTela)
    {
        this(x,y,velikostHlavy,POMER_HLAVA_TELO,POMER_TELO_VYS_SIR,barvaTela);
    }
    
    public Osoba(int x, int y, Barva barvaTela)
    {
        this(x,y,IMPL_VELIKOST_HLAVY,POMER_HLAVA_TELO,POMER_TELO_VYS_SIR,barvaTela); 
    }
    
    public Osoba()
    {
        this(0,0,IMPL_VELIKOST_HLAVY,POMER_HLAVA_TELO,POMER_TELO_VYS_SIR,IMPL_BARVA_TELA); 
    } 
    
     public int getX()
    {
        return (hlava.getX() <= telo.getX()) ? hlava.getX() : telo.getX();
    }

    public int getY()
    {
        return (hlava.getY() <= telo.getY()) ? hlava.getY() : telo.getY();
    }
    
    public int getSirka()
    {
        return (hlava.getSirka() >= telo.getSirka()) ? hlava.getSirka() : telo.getSirka(); 
    }
    
    public int getVyska()
    {
        return (hlava.getVyska() + telo.getVyska()); 
    }

    public String getNazev()
    {
        return NAZEV + "" + PORADI;
    }

    public Barva getBarvaTela()
    {
        return telo.getBarva();
    }
    
    public void setBarvaTela(Barva novaBarvaTela)
    {
        telo.setBarva(novaBarvaTela); 
    }
}
