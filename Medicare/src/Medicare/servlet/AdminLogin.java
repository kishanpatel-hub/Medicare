package Medicare.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Medicare.dal.AccountsDao;
import Medicare.model.Accounts;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	protected AccountsDao accountsDao;

	  @Override
	  public void init() throws ServletException {
		  accountsDao = AccountsDao.getInstance();
	  }

	  @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);

	    req.getRequestDispatcher("/Adminmenu.jsp").forward(req, resp);
	  }

	  @Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
		   Map<String, String> messages = new HashMap<String, String>();
	        req.setAttribute("messages", messages);
	        HttpSession session = req.getSession();
	        
	       
	       
	        String username = req.getParameter("username");
	        String password = req.getParameter("password");
	        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
	            messages.put("success", "Please enter a valid username and password.");
	        } else {
	      
		    try {
		    	Accounts account = accountsDao.getAccountforPatient(username, password);
		    	if (!(account == null)) {
		    		session.setAttribute("adminid", account.getId());	
		    		req.getRequestDispatcher("/Adminmenu.jsp").forward(req, resp);
		    	} else {
		    		 messages.put("success", "No account found.");
		    		 req.getRequestDispatcher("/AdminLogin.jsp").forward(req, resp);
		    	}
		    	
		   
	        } catch (SQLException e) {
	        	e.printStackTrace();
				throw new IOException(e);
		    }
	        
	        }
	        
	  }

}
