package Medicare.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Medicare.model.Doctor;
import Medicare.model.Patient;
import Medicare.model.Reviews;
import Medicare.model.specialization;
import Medicare.model.gender;

import java.lang.*;


public class DoctorDao {

  protected ConnectionManager connectionManager;


  private static DoctorDao instance = null;

  protected DoctorDao() {
    connectionManager = new ConnectionManager();
  }

  public static DoctorDao getInstance() {
    if (instance == null) {
      instance = new DoctorDao();
    }
    return instance;
  }


  public Doctor create(Doctor doctor) throws SQLException {
    String insertdoctor =
        "INSERT INTO Doctor(First_Name,Last_Name,Age,Phone,Email,Street,City,"
            + "ZIP,Gender,Clinic,Specialization,Description,Experiance) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertdoctor,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, doctor.getFirst_name());
      insertStmt.setString(2, doctor.getLast_name());
      insertStmt.setInt(3, doctor.getAge());
      insertStmt.setString(4, doctor.getPhone());
      insertStmt.setString(5, doctor.getEmail());
      insertStmt.setString(6, doctor.getStreet());
      insertStmt.setString(7, doctor.getCity());
      insertStmt.setString(8, doctor.getZip());
      insertStmt.setString(9, doctor.getGender().name());
      insertStmt.setString(10, doctor.getClinic());
      insertStmt.setString(11, doctor.getSpecialization().name());
      insertStmt.setString(12, doctor.getDescription());
      insertStmt.setInt(13, doctor.getExperiance());
      insertStmt.executeUpdate();

      // Retrieve the auto-generated key and set it, so it can be used by the caller.
      resultKey = insertStmt.getGeneratedKeys();
      int doctor_ID = -1;
      if (resultKey.next()) {
        doctor_ID = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      doctor.setDoctor_ID(doctor_ID);
      return doctor;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (insertStmt != null) {
        insertStmt.close();
      }
      if (resultKey != null) {
        resultKey.close();
      }
    }
  }


  /**
   * Get the doctors record by fetching it from your MySQL instance.
   * This runs a SELECT statement and returns a single doctors instance.
   * Note that we use BlogPostsDao and BlogUsersDao to retrieve the referenced
   * BlogPosts and BlogUsers instances.
   * One alternative (possibly more efficient) is using a single SELECT statement
   * to join the doctors, BlogPosts, BlogUsers tables and then build each object.
   */
  public List<Doctor> getdoctorBySpecialization(String spec,String city) throws SQLException {
    List<Doctor> doctorlist = new ArrayList<Doctor>();
    String selectdoctor =
        "SELECT Doctor_ID,First_Name,Last_Name,Age,Phone,Email,Street,City," +
            "ZIP,Gender,Clinic,Specialization,Description,Experiance FROM doctor WHERE specialization = ? and city = ? limit 10;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectdoctor);
      selectStmt.setString(1, spec);
      selectStmt.setString(2, city);
      results = selectStmt.executeQuery();
      while (results.next()) {

        int doctor_ID = results.getInt("Doctor_ID");
        String first_Name = results.getString("First_Name");
        String last_Name = results.getString("Last_Name");
        int age = results.getInt("Age");
        String phone = results.getString("Phone");
        String email = results.getString("Email");
        String street = results.getString("Street");
        String city1 = results.getString("City");
        String zip = results.getString("ZIP");
        gender genders = gender.valueOf(results.getString("Gender"));
        //Doctor.gender gender = Doctor.gender.valueOf(results.getString("Gender"));
        String clinic = results.getString("Clinic");
        specialization specializations = specialization.valueOf(results.getString("Specialization"));
        //specialization specializations = specialization.valueOf(results.getString("Specialization"));
        String description = results.getString("Description");
        int experiance = results.getInt("Experiance");
        Doctor doctor = new Doctor(doctor_ID, first_Name, last_Name, age, phone, email,
            street, city1, zip, genders, clinic, specializations, description, experiance);
        doctorlist.add(doctor);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (selectStmt != null) {
        selectStmt.close();
      }
      if (results != null) {
        results.close();
      }
    }
    return doctorlist;
  }
  
  public Doctor delete(Doctor doc) throws SQLException {
      String deletedoc = "DELETE FROM Doctor WHERE Doctor_ID=?;";
      Connection connection = null;
      PreparedStatement deleteStmt = null;
      try {
          connection = connectionManager.getConnection();
          deleteStmt = connection.prepareStatement(deletedoc);
          deleteStmt.setInt(1, doc.getDoctor_ID());
          deleteStmt.executeUpdate();
          return null;
      } catch (SQLException e) {
          e.printStackTrace();
          throw e;
      } finally {
          if(connection != null) {
              connection.close();
          }
          if(deleteStmt != null) {
              deleteStmt.close();
          }
      }
  }
  
  public List<Reviews> getdoctorByRating(int rating, String spec,String city) throws SQLException {
	    List<Reviews> reviewlist = new ArrayList<Reviews>();
	    String selectdoc =
	        "select d.Doctor_ID,d.First_Name,d.Last_Name,d.Age,d.Phone,d.Email,"
	        + "d.Street,d.City,d.ZIP,d.Gender,d.Clinic,d.Specialization,d.Description,"
	        + "d.Experiance,r.Patient_ID, r.Content, r.Rating, r.Created from reviews r " 
	        + "inner join doctor d on "  
	        + "d.Doctor_ID = r.Doctor_ID " 
	        + "where specialization = ? and city = ? "
	        + "group by r.Doctor_ID " 
	        + "having Rating = ?;";
	    Connection connection = null;
	    PreparedStatement selectStmt = null;
	    ResultSet results = null;
	    try {
	      connection = connectionManager.getConnection();
	      selectStmt = connection.prepareStatement(selectdoc);
	      
	      selectStmt.setString(1, spec);
	      selectStmt.setString(2, city);
	      selectStmt.setInt(3, rating);
	      
	      results = selectStmt.executeQuery();
	      while (results.next()) {

	 

	        int doctor_ID = results.getInt("Doctor_ID");
	        String first_Name = results.getString("First_Name");
	        String last_Name = results.getString("Last_Name");
	        int age = results.getInt("Age");
	        String phone = results.getString("Phone");
	        String email = results.getString("Email");
	        String street = results.getString("Street");
	        String city1 = results.getString("City");
	        String zip = results.getString("ZIP");
	        gender genders = gender.valueOf(results.getString("Gender"));
	        //Doctor.gender gender = Doctor.gender.valueOf(results.getString("Gender"));
	        String clinic = results.getString("Clinic");
	        specialization specializations = specialization.valueOf(results.getString("Specialization"));
	        String description = results.getString("Description");
	        int experiance = results.getInt("Experiance");
	        int patient_ID = results.getInt("Patient_ID");
	        Patient pat = new Patient(patient_ID);
	        String content = results.getString("Content");
	        int rate = results.getInt("Rating");
	        Date created =  new Date(results.getTimestamp("Created").getTime());
	        Doctor doctor = new Doctor(doctor_ID, first_Name, last_Name, age, phone, email,
	            street, city1, zip, genders, clinic, specializations, description, experiance);
	        Reviews review = new Reviews(pat, doctor, content, rate, created);
	        reviewlist.add(review);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	      throw e;
	    } finally {
	      if (connection != null) {
	        connection.close();
	      }
	      if (selectStmt != null) {
	        selectStmt.close();
	      }
	      if (results != null) {
	        results.close();
	      }
	    }
	    return reviewlist;
	  }
}