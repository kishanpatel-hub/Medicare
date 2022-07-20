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
import Medicare.dal.ReferralDao;
import Medicare.model.Appointments;
import Medicare.model.Doctor;
import Medicare.model.Patient;
import Medicare.model.Referral;

/**
 * Servlet implementation class DoctorReferral
 */
@WebServlet("/DoctorReferral")
public class DoctorReferral extends HttpServlet {
	protected ReferralDao referralDao;
	  
	  public void init() throws ServletException {
	      referralDao = ReferralDao.getInstance();
	  }
	  
	  public void doGet(HttpServletRequest req, HttpServletResponse resp)
	          throws ServletException, IOException {
	      // Map for storing messages.
//	      Map<String, String> messages = new HashMap<String, String>();
//	      
//	      List<Insurance> listInsurance;
//	      try {
//	          listInsurance = insurancedao.list();
//	          req.setAttribute("listInsurance", listInsurance);
//	      } catch (SQLException e) {
//	          // TODO Auto-generated catch block
//	          e.printStackTrace();
//	      }
//	      
//	      req.setAttribute("messages", messages);
//	      //Just render the JSP.   
//	      req.getRequestDispatcher("/PatientCreate.jsp").forward(req, resp);
	    
	  }
	  
	  
	  public void doPost(HttpServletRequest req, HttpServletResponse resp)
	          throws ServletException, IOException {
	      // Map for storing messages.
	      Map<String, String> messages = new HashMap<String, String>();
	      req.setAttribute("messages", messages);
	      
	      HttpSession session = req.getSession();
	      //req.setAttribute("selectedInsId", insuranceId);

	 

	     
	      int age = 0;
	      // Create the BlogUser.
	      Patient pat_ID = new Patient((int)session.getAttribute("PatientID"));
	      Doctor referredby = new Doctor((int)session.getAttribute("PatientID"));
	      Doctor referredto = new Doctor(Integer.parseInt(req.getParameter("referto")));
	      String notes = req.getParameter("Notes");

	 


	      try {
	             // Exercise: parse the input for StatusLevel.
	             Referral referral = new Referral(pat_ID, referredby, referredto, notes);
	             referral = referralDao.create(referral);
	         
	             messages.put("success", "Successfully added ");
	      } catch (SQLException e) {
	          e.printStackTrace();
	          throw new IOException(e);
	      }
	     
	      req.getRequestDispatcher("/DoctorRefferal.jsp").forward(req, resp);
	      
	    
	  }
}
