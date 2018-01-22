package kolekce;

public class VyukaNaKatedre implements Comparable<VyukaNaKatedre>{
	public final String katedra; // pripravka
	public final int pocet;
	
	public VyukaNaKatedre(String katedra, int pocet) {
		this.katedra = katedra;
		this.pocet = pocet;
	}
	
	public String getKatedra() {
		return katedra;
	}

	public int getPocet() {
		return pocet;
	}

	@Override
	public String toString() {
		return katedra + ": " + pocet;
	}
	
//	@Override
	public int compareTo(VyukaNaKatedre o) {
		if (this.pocet < o.pocet) {
			//razeni sestupne
			return -1;
		}
		// pocty se rovnaji
		else {
			// razeni vzestupne
			return o.katedra.compareTo(o.katedra);
		}
	}
	
}
