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


import Medicare.dal.DoctorDao;

import Medicare.model.Reviews;

@WebServlet("/finddoctorBasedonReview")
public class FindDoctorBasedonReview extends HttpServlet{
	 protected DoctorDao doctordao;

	  public void init() throws ServletException {
	    doctordao = DoctorDao.getInstance();
	  }

	  public void doGet(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);

	    List<Reviews> reviewList = new ArrayList<Reviews>();


	    // Retrieve and validate name.
	    // firstname is retrieved from the URL query string.
	    String specialization = req.getParameter("specialization");
	    String city = req.getParameter("city");
	    int review;
		if ((req.getParameter("review")) == null)
			review = 0;
		else
			review = Integer.parseInt(req.getParameter("review"));
	    if (specialization == null || specialization.trim().isEmpty() || city == null || city.trim().isEmpty() ) {
	      messages.put("success", "Please enter a valid specialization.");
	    } else {
	      // Retrieve BlogUsers, and store as a message.
	      try {
	        reviewList = doctordao.getdoctorByRating(review,specialization,city);
	        //doctorList = doctordao.getdoctorBySpecialization(specialization);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        throw new IOException(e);
	      }
	      messages.put("success", "Displaying results for " + specialization);
	      // Save the previous search term, so it can be used as the default
	      // in the input box when rendering FindUsers.jsp.
	      messages.put("previousSpecialization", specialization);
	    }
	    req.setAttribute("reviewList", reviewList);
	    req.getRequestDispatcher("/ViewDoctors.jsp").forward(req, resp);


	   // req.getRequestDispatcher("/FindDoctor.jsp").forward(req, resp);
	  }

	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);
	  
	    List<Reviews> reviewList = new ArrayList<Reviews>();


	    // Retrieve and validate name.
	    // firstname is retrieved from the URL query string.
	    String specialization = req.getParameter("specialization");
	    String city = req.getParameter("city");
	    int review = Integer.parseInt(req.getParameter("review"));
	    if (specialization == null || specialization.trim().isEmpty() || city == null || city.trim().isEmpty()) {
	      messages.put("success", "Please enter a valid specialization.");
	    } else {
	      // Retrieve BlogUsers, and store as a message.
	      try {
	        reviewList = doctordao.getdoctorByRating(review,specialization,city);
	        //doctorList = doctordao.getdoctorBySpecialization(specialization);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        throw new IOException(e);
	      }
	      messages.put("success", "Displaying results for " + specialization);
	      // Save the previous search term, so it can be used as the default
	      // in the input box when rendering FindUsers.jsp.
	      messages.put("previousSpecialization", specialization);
	    }
	    req.setAttribute("reviewList", reviewList);
	 
	    
//	    req.setAttribute("patientid", req.getAttribute("patientid"));
	//    
//	    req.getRequestDispatcher("bookappointment").forward(req, resp);

	    req.getRequestDispatcher("/ViewDoctors.jsp").forward(req, resp);
	    
	   
	  }
}
