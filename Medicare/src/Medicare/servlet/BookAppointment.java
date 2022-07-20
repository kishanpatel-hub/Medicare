package Medicare.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Medicare.dal.AppointmentDao;
import Medicare.dal.DoctorDao;
import Medicare.model.Appointments;
import Medicare.model.Doctor;
import Medicare.model.Insurance;
import Medicare.model.Patient;
import Medicare.model.gender;

@WebServlet("/bookappointment")
public class BookAppointment  extends HttpServlet{
	protected AppointmentDao appointmentDao;

	  @Override
	  public void init() throws ServletException {
		  appointmentDao = AppointmentDao.getInstance();
	  }

	  @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);
	    
	    req.setAttribute("doctorID", req.getParameter("doctorID"));

	    req.getRequestDispatcher("/BookAppointment.jsp").forward(req, resp);
	  }

	  @Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
		   Map<String, String> messages = new HashMap<String, String>();
	        req.setAttribute("messages", messages);
	        HttpSession session = req.getSession();
	        
	       
	        // Create the BlogUser.
	        int patient_ID = (int) session.getAttribute("patientid");
	        		//Integer.parseInt(req.getParameter("patientid"));
	        int doctor_id =  Integer.parseInt(req.getParameter("doctorid"));
	        // dob must be in the format yyyy-mm-dd.
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String stringDate = req.getParameter("appointmenton");
	      
	        Date appointmenton = Date.valueOf(stringDate);
	      
		    try {
		    	Doctor doc = new Doctor(doctor_id);
		    	Patient pat = new Patient(patient_ID);
		       	// Exercise: parse the input for StatusLevel.
		    	Appointments app = new Appointments(pat,doc,appointmenton);
		    	app = appointmentDao.create(app);
		       	messages.put("success", "Successfully added ");
	        } catch (SQLException e) {
	        	e.printStackTrace();
				throw new IOException(e);
		    }
	        
	        
	        req.getRequestDispatcher("/BookAppointment.jsp").forward(req, resp);
	  }
}
