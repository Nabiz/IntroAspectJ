package zti;

import java.sql.DriverManager;
import java.sql.Connection;

public aspect DBConnAspect {

	pointcut doGetPersonServletPointcut(HttpServletWithConnHandler servlet) : execution(* doGet(..)) && target(servlet); 

	before(HttpServletWithConnHandler servlet) : doGetPersonServletPointcut(servlet) {
	
		System.out.println("Advice BEFORE");
		
		try{
		Class.forName("org.postgresql.Driver");
        String url = "DATABASE_URL";
        String username = "DATABASE_USERNAME" ;
        String password = "DATABASE_PASSWORD" ;
        System.out.println();
        servlet.conn = DriverManager.getConnection(url, username, password);
        } catch(Exception e){}
	}

	after(HttpServletWithConnHandler servlet) : doGetPersonServletPointcut(servlet) {
			System.out.println("Advice AFTER");
			
			try{
			servlet.conn.close();
			} catch(Exception e){}
	}
}
