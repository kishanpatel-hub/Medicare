package Medicare.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Medicare.dal.AppointmentDao;
import Medicare.model.Appointments;

/**
 * Servlet implementation class UpdateAppointment
 */
@WebServlet("/UpdateAppointment")
public class UpdateAppointment extends HttpServlet {
	protected AppointmentDao appointmentdao;
	private static final long serialVersionUID = 1L;
    
    @Override
	  public void init() throws ServletException {
		  appointmentdao = AppointmentDao.getInstance();
	  }

    @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);
	    
	    req.setAttribute("AppointmentID", req.getParameter("AppointmentID"));
	    
	    req.getRequestDispatcher("/appointmentPatient").forward(req, resp);
	  }

	  @Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
		   Map<String, String> messages = new HashMap<String, String>();
	        req.setAttribute("messages", messages);
	        HttpSession session = req.getSession();
	        
	       
	   
	        int appointment_id =  Integer.parseInt(req.getParameter("AppointmentID"));
	        
	        // dob must be in the format yyyy-mm-dd.
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String stringDate = req.getParameter("appointmenton");
	      
	        Date appointmenton = Date.valueOf(stringDate);
	      
		    try {

		       	// Exercise: parse the input for StatusLevel.
		    	Appointments app = new Appointments(appointment_id);
		    	app = appointmentdao.updateAppointmentOn(app, appointmenton);
		       	messages.put("success", "Successfully Updated ");
	        } catch (SQLException e) {
	        	e.printStackTrace();
				throw new IOException(e);
		    }
	        
	        
	        req.getRequestDispatcher("/appointmentPatient").forward(req, resp);
	  }

}
