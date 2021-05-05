package zti;

import java.sql.DriverManager;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public aspect DBConnAspect {

	pointcut doGetPersonServletPointcut(Connection conn, HttpServletRequest request, HttpServletResponse response) :
	 execution(* fillContent(Connection, HttpServletRequest, HttpServletResponse)) && args(conn, request, response); 


	void around(Connection conn, HttpServletRequest request, HttpServletResponse response) : doGetPersonServletPointcut(conn, request, response) {
		
		System.out.println(thisJoinPoint);
		
		System.out.println("Otwieram polaczenie z baza");
		
		try{
		Class.forName("org.postgresql.Driver");
        String url = "DATABASE_URL";
        String username = "DATABASE_USERNAME" ;
        String password = "DATABASE_PASSWORD" ;
        System.out.println();
        conn = DriverManager.getConnection(url, username, password);
        } catch(Exception e){}
        
        proceed(conn, request, response);
        
			System.out.println("Zamykam polaczenie z baza");
			
			try{
			conn.close();
			} catch(Exception e){}
	}
}
