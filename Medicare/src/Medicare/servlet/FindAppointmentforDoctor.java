package Medicare.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import Medicare.model.Appointments;
import Medicare.model.Doctor;
import Medicare.model.Patient;

/**
 * Servlet implementation class FindAppointmentforDoctor
 */
@WebServlet("/FindAppointmentforDoctor")
public class FindAppointmentforDoctor extends HttpServlet {
	protected AppointmentDao appointmentdao;

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

	    List<Appointments> List = new ArrayList<Appointments>();
	    HttpSession session = req.getSession();
	    int doctor_ID = (int) session.getAttribute("doctorid");
	    Doctor doctor = new Doctor(doctor_ID);
	    
	    // Retrieve and validate name.
	    // firstname is retrieved from the URL query string.

	    
	      // Retrieve BlogUsers, and store as a message.
	      try {
	        List = appointmentdao.getAppointmentsforDoctor(doctor);
	        //doctorList = doctordao.getdoctorBySpecialization(specialization);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        throw new IOException(e);
	      }
	     
	    
	    req.setAttribute("AppointmentList", List);

	    
	   
	    req.getRequestDispatcher("DoctorAppointment.jsp").forward(req, resp);

	   
	  }

	  @Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {

		    // Map for storing messages.
		    Map<String, String> messages = new HashMap<String, String>();
		    req.setAttribute("messages", messages);

		    List<Appointments> List = new ArrayList<Appointments>();
		    HttpSession session = req.getSession();
		    int doctor_ID = (int) session.getAttribute("doctorid");
		    Doctor doctor = new Doctor(doctor_ID);
		    
		    // Retrieve and validate name.
		    // firstname is retrieved from the URL query string.

		    
		      // Retrieve BlogUsers, and store as a message.
		      try {
		        List = appointmentdao.getAppointmentsforDoctor(doctor);
		        //doctorList = doctordao.getdoctorBySpecialization(specialization);
		      } catch (SQLException e) {
		        e.printStackTrace();
		        throw new IOException(e);
		      }
		     
		    
		    req.setAttribute("AppointmentList", List);

		    
		   
		    req.getRequestDispatcher("DoctorAppointment.jsp").forward(req, resp);
	   
	  }
}
