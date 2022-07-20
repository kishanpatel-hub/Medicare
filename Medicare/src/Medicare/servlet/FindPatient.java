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

import Medicare.dal.PatientDao;
import Medicare.model.Patient;

/**
 * Servlet implementation class FindPatient
 */
@WebServlet("/FindPatient")
public class FindPatient extends HttpServlet {
	 protected PatientDao patientdao;

	 

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
	 

	    List<Patient> patientList = new ArrayList<Patient>();

	 


	    // Retrieve and validate name.
	    // firstname is retrieved from the URL query string.
	    String first_Name = (String) session.getAttribute("first_Name");
	    String last_Name = (String) session.getAttribute("last_name");
	    if (first_Name == null || first_Name.trim().isEmpty() || last_Name == null || last_Name.trim().isEmpty()) {
	      messages.put("success", "Please enter a valid firstname and lastname.");
	    } else {
	      // Retrieve BlogUsers, and store as a message.
	      try {
	          patientList = patientdao.getPatientByFirstnameAndLastname(first_Name, last_Name);
	        //doctorList = doctordao.getdoctorBySpecialization(specialization);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        throw new IOException(e);
	      }
	      messages.put("success", "Displaying results for " + first_Name);
	      // Save the previous search term, so it can be used as the default
	      // in the input box when rendering FindUsers.jsp.
	      messages.put("previousfirst_Name", first_Name);
	    }
	    req.setAttribute("patientList", patientList);

	 

	    req.getRequestDispatcher("/ListPatient.jsp").forward(req, resp);
	  }

	 

	  @Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);
	    HttpSession session = req.getSession();
	 

	    List<Patient> patientList = new ArrayList<Patient>();

	 

	    // Retrieve and validate name.
	    // firstname is retrieved from the form POST submission. By default, it
	    // is populated by the URL query string (in FindUsers.jsp).
	    
	    String first_Name = req.getParameter("first_name");
	    String last_Name = req.getParameter("last_name");

	    if (first_Name == null || first_Name.trim().isEmpty() || last_Name == null || last_Name.trim().isEmpty()) {
	      messages.put("success", "Please enter a valid firstname and lastname.");
	    } else {
	      // Retrieve BlogUsers, and store as a message.
	      try {
	    	  session.setAttribute("first_name", first_Name);
	    	  session.setAttribute("last_name", last_Name);
	          patientList = patientdao.getPatientByFirstnameAndLastname(first_Name, last_Name);
	        //doctorList = doctordao.getdoctorBySpecialization(specialization);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        throw new IOException(e);
	      }

	 

	      messages.put("success", "Displaying results for " + first_Name + " and " + last_Name);
	    }
	    req.setAttribute("patientList", patientList);

	 

	    req.getRequestDispatcher("/ListPatient.jsp").forward(req, resp);
	  }

}
