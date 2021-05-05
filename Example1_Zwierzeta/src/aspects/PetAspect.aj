package aspekty;

import java.util.ArrayList;
import java.util.List;

public aspect PetAspect {

	//Cw 1.
	pointcut dajGlosPointcut() : call(void dajGlos());
	
	before() : dajGlosPointcut() {
		System.out.println("Zaraz zwierze da glos");
	}
	
	after() : dajGlosPointcut() {
		System.out.println("Zwierze dalo glos");
	}
	
	pointcut setImiePointcut(String imie) : call(void setImie(String)) && args(imie);
	
	void around(String imie) : setImiePointcut(imie) {
		imie = "Szarik";
		proceed(imie);
	}

	//Cw 2.
	pointcut zwierzeInit() : initialization(new(..)) && within(zwierzeta.*);
	
	after() : zwierzeInit() {
		System.out.println("Stworzylem zwierzatko");
		
        String line = "" + thisJoinPointStaticPart.getSourceLocation().getLine();
        String sourceName = thisJoinPointStaticPart.getSourceLocation().getWithinType().getCanonicalName();
        System.out.println("Init from " + sourceName + " line " + line);
	}
	
	pointcut kotMeowth(zwierzeta.Kot kot, String imie) : initialization(zwierzeta.Kot.new(String)) && args(imie) && target(kot);
	
	after(zwierzeta.Kot kot, String imie) : kotMeowth(kot, imie) {
		if(imie=="Meowth") {
			kot.setGlos("Zespol R znowu w akcji! Meowth to fakt!!!");
		}
	}
	
	//Cw 3.
	private List<String> zwierzeta.Pies.zjedzone = new ArrayList<String>();
	
	pointcut karmieniePsa(zwierzeta.Pies pies, String jedzenie) : call(* zwierzeta.Pies.nakarm(String)) && args(jedzenie) && target(pies);
	
	before(zwierzeta.Pies pies, String jedzenie) throws Exception : karmieniePsa(pies, jedzenie) {
		if(jedzenie=="arszenik") {
			throw new Exception("Proba otrucia: "+ pies.getImie());
		}
	}
	
	after(zwierzeta.Pies pies, String jedzenie) throwing: karmieniePsa(pies, jedzenie) {
		System.out.println("Nie wolno truc zwierzat!!!");
	}	

	after(zwierzeta.Pies pies, String jedzenie) returning: karmieniePsa(pies, jedzenie) {
		pies.zjedzone.add(jedzenie);						
	}	
	
	after(zwierzeta.Pies pies, String jedzenie): karmieniePsa(pies, jedzenie) {					
		System.out.println("Pies "+pies.getImie()+" zjadl juz: "+ pies.zjedzone);
	}	
}
