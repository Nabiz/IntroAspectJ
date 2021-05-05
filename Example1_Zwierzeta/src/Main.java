import zwierzeta.Kot;
import zwierzeta.Pies;

public class Main {
    public static void main(String[] args) {
        Kot kot1 = new Kot();
        kot1.setImie("Kicia");
        Kot kot2 = new Kot("Meowth");
        Pies pies1 = new Pies("Reksio");
        Pies pies2 = new Pies("gdsajgjdskg");
        pies2.setImie("fgmakggdask");
        
        kot1.dajGlos();
        System.out.println("---------------");
        
        kot2.dajGlos();
        System.out.println("---------------");
        
        pies1.dajGlos();
        System.out.println("---------------");
        
        try{	
		    pies1.nakarm("szynka");
		    pies1.nakarm("kosc");
		    System.out.println("---------------");
	
		    pies2.nakarm("mieso");	
		    pies2.nakarm("arszenik");
		    System.out.println("---------------");
        }catch(Exception e) {System.out.println(e);}
    }
}
