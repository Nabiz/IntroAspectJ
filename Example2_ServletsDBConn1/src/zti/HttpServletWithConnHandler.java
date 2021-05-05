package zti;

import javax.servlet.http.HttpServlet;


import java.sql.Connection;

/**
 * Servlet implementation class HttpServletWithConnHandler
 */

public class HttpServletWithConnHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Connection conn;
	public Connection getConn() {
		return conn;
	}
    public HttpServletWithConnHandler() {
        super();
        // TODO Auto-generated constructor stub
    }


}
