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

import Medicare.dal.AppointmentDao;
import Medicare.dal.PatientDao;
import Medicare.model.Appointments;
import Medicare.model.Patient;

/**
 * Servlet implementation class DeletePatient
 */
@WebServlet("/DeletePatient")
public class DeletePatient extends HttpServlet {
	protected PatientDao patientdao;
	private static final long serialVersionUID = 1L;
    
    @Override
	  public void init() throws ServletException {
    	patientdao = PatientDao.getInstance();
	  }

    @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);
	    HttpSession session = req.getSession();
	    int patient_id =  Integer.parseInt(req.getParameter("patientID"));
	     
	      
	    try {

	       	// Exercise: parse the input for StatusLevel.
	    	Patient patient = new Patient(patient_id);
	    	patient = patientdao.delete(patient);
	       	messages.put("success", "Successfully Updated ");
        } catch (SQLException e) {
        	e.printStackTrace();
			throw new IOException(e);
	    }

        	 req.getRequestDispatcher("/FindPatient").forward(req, resp); 	

       
	  }

	  @Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {

		    Map<String, String> messages = new HashMap<String, String>();
		    req.setAttribute("messages", messages);
		    HttpSession session = req.getSession();
		    int patient_id =  Integer.parseInt(req.getParameter("patientID"));
		     
		      
		    try {

		       	// Exercise: parse the input for StatusLevel.
		    	Patient patient = new Patient(patient_id);
		    	patient = patientdao.delete(patient);
		       	messages.put("success", "Successfully Updated ");
	        } catch (SQLException e) {
	        	e.printStackTrace();
				throw new IOException(e);
		    }

		   
	        	 req.getRequestDispatcher("/FindPatient").forward(req, resp); 	
	
	  }

}
