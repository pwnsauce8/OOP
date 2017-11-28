package kolekce;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Hlavni {

	private static void zapisDoSouboru(String celeJmenoSouboru,  List<RozvrhovaAkce> seznam) {

			try {
				PrintWriter pbw = new PrintWriter(
								 new BufferedWriter(
								 new FileWriter( 
								 new File(celeJmenoSouboru))));
				int poradi = 1;
				for (RozvrhovaAkce ra : seznam) {
					pbw.println("" + poradi + ". " + ra.toString());
					poradi++;
				}
				pbw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
	
	public static void main(String[] args) {
		VstupDat vd = VstupDat.getInstance();
		List<RozvrhovaAkce> seznam = vd.nactiRozvrhoveAkce(args[0]);
		zapisDoSouboru(args[1], seznam); 
//		zapisDoSouboru(args[1], VstupDat.getInstance().nactiRozvrhoveAkce(args[0]); 
	}

}
