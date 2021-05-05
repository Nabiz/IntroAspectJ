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
 * Servlet implementation class MailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    private void fillContent(Connection conn, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out= response.getWriter();
        out.println("<h1>The data from the PostgreSQL database</h1>") ;
      
        try
        {
             // Class.forName("org.apache.derby.jdbc.ClientDriver");
       // url = "jdbc:postgresql://host:port/database" 
            Statement stmt = conn.createStatement();
            String sql = "SELECT id, email FROM public.person";
            ResultSet rs = stmt.executeQuery( sql );
            out.println("<table>") ;
            out.println("<tr><th>ID<th><th>Email</th></tr>") ;
            while(rs.next())  {
               out.print("<tr><td>" + rs.getInt("ID") + "</td><td>" + rs.getString("EMAIL") + "</td></tr>" ) ;
            }   
            out.println("</table>") ;
            rs.close();
            stmt.close();
        }
        catch(Exception e)
        {  out.println (e) ; } 
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		fillContent(null, request, response);
        PrintWriter out= response.getWriter();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
