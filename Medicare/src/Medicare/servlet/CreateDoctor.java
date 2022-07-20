package Medicare.servlet;
import java.io.IOException;
import java.sql.SQLException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Medicare.dal.AccountsDao;
import Medicare.dal.DoctorDao;
import Medicare.model.Accounts;
import Medicare.model.Doctor;
import Medicare.model.specialization;
import Medicare.model.gender;


@WebServlet("/createDoctor")
public class CreateDoctor extends HttpServlet {
    
    protected DoctorDao doctorDao;
	protected AccountsDao accountdao;
	
    @Override
    public void init() throws ServletException {
        doctorDao = DoctorDao.getInstance();
        accountdao = AccountsDao.getInstance();
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
//        Map<String, String> messages = new HashMap<String, String>();
//        
//        List<Insurance> listInsurance;
//        try {
//            listInsurance = insurancedao.list();
//            req.setAttribute("listInsurance", listInsurance);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        
//        req.setAttribute("messages", messages);
//        //Just render the JSP.   
//        req.getRequestDispatcher("/PatientCreate.jsp").forward(req, resp);
      
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
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String street = req.getParameter("street");
        String city = req.getParameter("city");
        String zip = req.getParameter("zip");
        gender sex = gender.valueOf(req.getParameter("gender"));
        String clinic = req.getParameter("clinic");
        specialization spec = specialization.valueOf(req.getParameter("specialization"));
        String description = req.getParameter("description");
        int experience = Integer.parseInt(req.getParameter("experience"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        int id;

        try {
               // Exercise: parse the input for StatusLevel.
               Doctor doctor = new Doctor(firstName, lastName, age, phone, email, 
                       street, city, zip, sex, clinic, spec,description, experience);
               doctor = doctorDao.create(doctor);
               id = (doctor.getDoctor_ID());
               Accounts account = new Accounts(id, username, password);
   	       	   account = accountdao.create(account);
               messages.put("success", id + "Successfully added ");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        session.setAttribute("doctorid", id);
        req.setAttribute("doctorid", id);
        req.getRequestDispatcher("/DoctorMenu.jsp").forward(req, resp);
        
      
    }
}