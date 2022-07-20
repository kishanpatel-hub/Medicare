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

import Medicare.dal.DoctorDao;
import Medicare.model.Doctor;

/**
 * Servlet implementation class FindDoctorforreferal
 */
@WebServlet("/FindDoctorforreferal")
public class FindDoctorforreferal extends HttpServlet {
	protected DoctorDao doctordao;

	  @Override
	  public void init() throws ServletException {
	    doctordao = DoctorDao.getInstance();
	  }

//	  @Override
//	  public void doGet(HttpServletRequest req, HttpServletResponse resp)
//	      throws ServletException, IOException {
//	    // Map for storing messages.
//		  HttpSession session = req.getSession();
//		  int patientid = (int) req.getAttribute("patientID");
//		    session.setAttribute("PatientID", patientid);
//		    req.getRequestDispatcher("/ListdocForrefer.jsp").forward(req, resp);
//		    
//
//	   // req.setAttribute("patientid", req.getAttribute("patientid"));
//	    
//	   // resp.sendRedirect("/bookappointment?patientid="+req.getParameter("patientid"));
//	    
//	  //  req.getRequestDispatcher("bookappointment").forward(req, resp);
//
//	   // 
//	  }

	  @Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);
	    HttpSession session = req.getSession();
	    List<Doctor> doctorList = new ArrayList<Doctor>();
	    int patientid = Integer.parseInt(req.getParameter("patientreferd"));
	    session.setAttribute("PatientID", patientid);
	    

	    // Retrieve and validate name.
	    // firstname is retrieved from the form POST submission. By default, it
	    // is populated by the URL query string (in FindUsers.jsp).
	    
	    String specialization = req.getParameter("specialization");
	    messages.put("patientid", (String) req.getAttribute("patientid"));
	    String city = req.getParameter("city");
	    //String id = req.getParameter("patientid");
	   
	    if (specialization == null || specialization.trim().isEmpty() || city == null || city.trim().isEmpty()) {
	      messages.put("success", "Please enter a valid specialization.");
	    } else {
	      // Retrieve BlogUsers, and store as a message.
	      try {
	        doctorList = doctordao.getdoctorBySpecialization(specialization,city);
	      
	        //doctorList = doctordao.getdoctorBySpecialization(specialization);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        throw new IOException(e);
	      }
	      messages.put("success", "Displaying results for " + specialization + " in  " + city);
	    }
	   
	   
	    req.setAttribute("doctorList", doctorList);
	 
	    
//	    req.setAttribute("patientid", req.getAttribute("patientid"));
	//    
//	    req.getRequestDispatcher("bookappointment").forward(req, resp);

	    req.getRequestDispatcher("/ListdocForrefer.jsp").forward(req, resp);
	    
	   
	  }

}
