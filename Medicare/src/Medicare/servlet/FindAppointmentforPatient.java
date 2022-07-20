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
import Medicare.dal.DoctorDao;
import Medicare.model.Appointments;
import Medicare.model.Doctor;
import Medicare.model.Patient;

@WebServlet("/appointmentPatient")
public class FindAppointmentforPatient extends HttpServlet{
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
	    int patient_ID = (int) session.getAttribute("patientid");
	    Patient patient = new Patient(patient_ID);
	    // Retrieve and validate name.
	    // firstname is retrieved from the URL query string.

	    
	      // Retrieve BlogUsers, and store as a message.
	      try {
	        List = appointmentdao.getAppointmentsforPatient(patient);
	        //doctorList = doctordao.getdoctorBySpecialization(specialization);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        throw new IOException(e);
	      }
	     
	    
	    req.setAttribute("AppointmentList", List);

	    
	   
	    req.getRequestDispatcher("PatientAppointments.jsp").forward(req, resp);

	   
	  }

	  @Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {

		  Map<String, String> messages = new HashMap<String, String>();
		    req.setAttribute("messages", messages);

		    List<Appointments> List = new ArrayList<Appointments>();
		    HttpSession session = req.getSession();
		    int patient_ID = (int) session.getAttribute("patientid");
		    Patient patient = new Patient(patient_ID);
		    // Retrieve and validate name.
		    // firstname is retrieved from the URL query string.

		    
		      // Retrieve BlogUsers, and store as a message.
		      try {
		        List = appointmentdao.getAppointmentsforPatient(patient);
		        //doctorList = doctordao.getdoctorBySpecialization(specialization);
		      } catch (SQLException e) {
		        e.printStackTrace();
		        throw new IOException(e);
		      }
		     
		    
		    req.setAttribute("AppointmentList", List);

		    
		   
		    req.getRequestDispatcher("PatientAppointments.jsp").forward(req, resp);

	   
	  }
}
