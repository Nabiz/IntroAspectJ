package zwierzeta;

public class Pies {
	private String imie;
	private String glos;
	
	public Pies(String imie) {
		this.imie = imie;
		this.glos = "Hau! Hau!";
	}	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getGlos() {
		return glos;
	}
	public void setGlos(String glos) {
		this.glos = glos;
	}
	
	public void dajGlos() {
		System.out.println(glos);
	}
	
	public void nakarm(String jedzenie) throws Exception {
		System.out.println("Piesek " + imie +" je " + jedzenie);
	}
}
