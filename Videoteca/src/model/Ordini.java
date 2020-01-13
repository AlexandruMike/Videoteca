package model;


import java.util.ArrayList;
import java.util.List;

public class Ordini {
	private static List<Noleggio> noleggi = new ArrayList<Noleggio>();

	
	public Ordini(List<Noleggio> noleggi) {
		super();
		this.noleggi = noleggi;
	}

	public List<Noleggio> getNoleggi() {
		return noleggi;
	}

	public void setNoleggi(List<Noleggio> noleggi) {
		this.noleggi = noleggi;
	}
	
	public static void addNoleggio(Noleggio noleggio) {
		noleggi.add(noleggio);
		System.out.println("noleggio aggiunto: "+noleggi);
		
	}
	
	
}
