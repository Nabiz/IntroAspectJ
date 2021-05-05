package zti;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private void fillContent(Connection conn, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out= response.getWriter();
        out.println("<h1>The data from the PostgreSQL database</h1>") ;
      
        try
        {
             // Class.forName("org.apache.derby.jdbc.ClientDriver");
       // url = "jdbc:postgresql://host:port/database" 
             Statement stmt = conn.createStatement();
             String sql = "SELECT * FROM public.person";
             ResultSet rs = stmt.executeQuery( sql );
             out.println("<table>") ;
             out.println("<tr><th>ID</th><th>Firstname</th><th>Lastname</th><th>City</th></tr>") ;
             while(rs.next())  {
                out.print("<tr><td>" + rs.getInt("ID") + "</td><td>" + rs.getString("FNAME") + "</td>" ) ;
                out.println ( "<td>" + rs.getString("LNAME") + "</td><td>" + rs.getString("CITY") + "</td></tr>" ) ;
             }   
             out.println("</table>") ;
             rs.close();
             stmt.close();
        }
        catch(Exception e)
        {  out.println (e) ; } 
		
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

    	
    	fillContent(null, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
