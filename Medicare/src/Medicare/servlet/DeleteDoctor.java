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


import Medicare.dal.DoctorDao;
import Medicare.model.Doctor;


/**
 * Servlet implementation class DeleteDoctor
 */
@WebServlet("/DeleteDoctor")
public class DeleteDoctor extends HttpServlet {
	protected DoctorDao doctordao;
	private static final long serialVersionUID = 1L;
    
    @Override
	  public void init() throws ServletException {
    	doctordao = DoctorDao.getInstance();
	  }

    @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);
	    HttpSession session = req.getSession();
	    int doctor_id =  Integer.parseInt(req.getParameter("doctorID"));
	     
	      
	    try {

	       	// Exercise: parse the input for StatusLevel.
	    	Doctor doc = new Doctor(doctor_id);
	    	doc = doctordao.delete(doc);
	       	messages.put("success", "Successfully deleted");
        } catch (SQLException e) {
        	e.printStackTrace();
			throw new IOException(e);
	    }

        	 req.getRequestDispatcher("/finddoctorBasedonReview").forward(req, resp); 	

       
	  }

	  @Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
		    Map<String, String> messages = new HashMap<String, String>();
		    req.setAttribute("messages", messages);
		    HttpSession session = req.getSession();
		    int doctor_id =  Integer.parseInt(req.getParameter("doctorID"));
		     
		      
		    try {

		       	// Exercise: parse the input for StatusLevel.
		    	Doctor doc = new Doctor(doctor_id);
		    	doc = doctordao.delete(doc);
		       	messages.put("success", "Successfully deleted");
	        } catch (SQLException e) {
	        	e.printStackTrace();
				throw new IOException(e);
		    }

	        	 req.getRequestDispatcher("/finddoctorBasedonReview").forward(req, resp); 	

	       
	
	  }
}
