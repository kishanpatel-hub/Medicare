package Medicare.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Medicare.dal.AccountsDao;
import Medicare.dal.InsuranceDao;
import Medicare.dal.PatientDao;
import Medicare.model.Accounts;
import Medicare.model.Insurance;
import Medicare.model.Patient;
import Medicare.model.gender;


@WebServlet("/patientcreate")
public class PatientCreate extends HttpServlet {
	
	protected PatientDao patientDao;
	protected InsuranceDao insurancedao;
	protected AccountsDao accountdao;
	
	@Override
	public void init() throws ServletException {
		patientDao = PatientDao.getInstance();
		insurancedao = InsuranceDao.getInstance();
		accountdao = AccountsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        
        List<Insurance> listInsurance;
		try {
			listInsurance = insurancedao.list();
			req.setAttribute("listInsurance", listInsurance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/PatientCreate.jsp").forward(req, resp);
      
	}
	
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        HttpSession session = req.getSession();
        
        
        //req.setAttribute("selectedInsId", insuranceId);
 
       
        int age = 0;
        // Create the BlogUser.
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");

        age = Integer.parseInt(req.getParameter("age"));   	
   
        
        gender sex = gender.valueOf(req.getParameter("gender"));
        String phone = req.getParameter("phone");
        String street = req.getParameter("street");
        String city = req.getParameter("city");
        String zip = req.getParameter("zip");
        String bloodgroup = req.getParameter("bloodgroup");
        int height = Integer.parseInt(req.getParameter("height"));   
        int weight = Integer.parseInt(req.getParameter("weight"));   
        long policyno = Long.parseLong((req.getParameter("policynos") == null ? "0": req.getParameter("policynos") )); 
        int insuranceId = Integer.parseInt(req.getParameter("insurance"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        
        // dob must be in the format yyyy-mm-dd.
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String stringDob = req.getParameter("dob");
        int id;
        Date dob = new Date();
        try {
        	dob = dateFormat.parse(stringDob);
        } catch (ParseException e) {
        	e.printStackTrace();
			throw new IOException(e);
       	}
	    try {
	       	// Exercise: parse the input for StatusLevel.
	    	Insurance insurance = new Insurance(insuranceId);
	       	Patient patient = new Patient(firstName, lastName, age, sex, phone, 
	       			street, city, zip, dob, bloodgroup, height, weight, policyno, insurance);
	       	patient = patientDao.create(patient);
	       	id = patient.getPatient_ID();
	       	Accounts account = new Accounts(id, username, password);
	       	account = accountdao.create(account);
	       	session.setAttribute("patientid", id);
	       	req.setAttribute("patient", patient);
	       	messages.put("success", id + "Successfully added ");
        } catch (SQLException e) {
        	e.printStackTrace();
			throw new IOException(e);
	    }
       
		
		
        req.getRequestDispatcher("/PatientMenu.jsp").forward(req, resp);
       
      
    }
}
