package zwierzeta;

public class Kot {
	private String imie;
	private String glos;
	
	public Kot() {
		this.imie = "DefaultKotName";
		this.glos = "Miau!";
	}
	
	public Kot(String imie) {
		this.imie = imie;
		this.glos = "Miau!";
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
}
