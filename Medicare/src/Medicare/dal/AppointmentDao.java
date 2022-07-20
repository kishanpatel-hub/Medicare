package Medicare.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import Medicare.model.Appointments;
import Medicare.model.Doctor;
import Medicare.model.Insurance;
import Medicare.model.Patient;
import Medicare.model.gender;
import Medicare.model.specialization;


public class AppointmentDao {

  protected ConnectionManager connectionManager;

  private static AppointmentDao instance = null;

  protected AppointmentDao() {
    connectionManager = new ConnectionManager();
  }

  public static AppointmentDao getInstance() {
    if (instance == null) {
      instance = new AppointmentDao();
    }
    return instance;
  }

  public Appointments create(Appointments appointment) throws SQLException {
    // Insert into the superclass table first.
    String insertappointment = "INSERT INTO Appointments(Patient_ID,Doctor_ID,Created,AppointmentOn) VALUES(?,?,current_timestamp(),?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertappointment, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, appointment.getPatient_ID().getPatient_ID());
      insertStmt.setInt(2, appointment.getDoctor_ID().getDoctor_ID());
     
      insertStmt.setTimestamp(3, new Timestamp(appointment.getAppointmentOn().getTime()));
      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int appointment_ID = -1;
      if (resultKey.next()) {
        appointment_ID = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      appointment.setAppointment_ID(appointment_ID);
      return appointment;
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
   * Update the LastName of the BlogUsers instance.
   * This runs a UPDATE statement.
   */
  public Appointments updateAppointmentOn(Appointments appointment, Date newAppointmentOn) throws SQLException {

    String updateappointment = "UPDATE Appointments SET AppointmentOn=? WHERE Appointment_ID=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateappointment);
      updateStmt.setTimestamp(1, new Timestamp(newAppointmentOn.getTime()));
      updateStmt.setInt(2, appointment.getAppointment_ID());
      updateStmt.executeUpdate();

      // Update the person param before returning to the caller.
      appointment.setAppointmentOn(newAppointmentOn);
      return appointment;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (updateStmt != null) {
        updateStmt.close();
      }
    }
  }

  /**
   * Delete the Appointments instance.
   * This runs a DELETE statement.
   */
  public Appointments delete(Appointments appointment) throws SQLException {
    String deleteAppointment = "DELETE FROM Appointments WHERE Appointment_ID=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteAppointment);
      deleteStmt.setInt(1, appointment.getAppointment_ID());
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
  
  public List<Appointments> getAppointmentsforPatient(Patient patient) throws SQLException {
	    List<Appointments> list = new ArrayList<Appointments>();
	    String selectappointment =
	    		"select Appointment_ID, d.Doctor_ID, First_Name, Last_Name, Age, Phone, Email, Gender"
	    		+ ", Clinic , Street, City, ZIP, AppointmentOn, Created, Specialization, Description, Experiance "
	    		+ "from appointments a inner join doctor d on d.Doctor_ID = a.Doctor_ID "
	    		+ "where a.Patient_ID = ? and AppointmentOn > current_timestamp();";
	    Connection connection = null;
	    PreparedStatement selectStmt = null;
	    ResultSet results = null;
	    try {
	      connection = connectionManager.getConnection();
	      selectStmt = connection.prepareStatement(selectappointment);
	      selectStmt.setString(1, Integer.toString(patient.getPatient_ID()));
	      results = selectStmt.executeQuery();
	      while (results.next()) {

	    	int appointment_ID = results.getInt("Appointment_ID");
	        int doctor_ID = results.getInt("Doctor_ID");
	        String first_Name = results.getString("First_Name");
	        String last_Name = results.getString("Last_Name");
	        int age = results.getInt("Age");
	        String phone = results.getString("Phone");
	        String email = results.getString("Email");
	        gender genders = gender.valueOf(results.getString("Gender"));
	        String clinic = results.getString("Clinic");
	        String street = results.getString("Street");
	        String city1 = results.getString("City");
	        String zip = results.getString("ZIP");
	        Date appointmenton = new Date(results.getTimestamp("AppointmentOn").getTime());
	        Date created = new Date(results.getTimestamp("Created").getTime());
	        //Doctor.gender gender = Doctor.gender.valueOf(results.getString("Gender"));
	        
	        specialization specializations = specialization.valueOf(results.getString("Specialization"));
	        //specialization specializations = specialization.valueOf(results.getString("Specialization"));
	        String description = results.getString("Description");
	        int experiance = results.getInt("Experiance");
	        Doctor doctor = new Doctor(doctor_ID, first_Name, last_Name, age, phone, email,
	            street, city1, zip, genders, clinic, specializations, description, experiance);
	    
	        Appointments appointment = new Appointments(appointment_ID,patient,doctor,appointmenton, created);
	        list.add(appointment);
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
	    return list;
	  }  
  
  public List<Appointments> getAppointmentsforDoctor(Doctor doctor) throws SQLException {
	    List<Appointments> list = new ArrayList<Appointments>();
	    String selectappointment =
	    		"select Appointment_ID, a.Patient_ID, First_Name, Last_Name, Age, Gender, Phone, Street, City,"  
	    		+ "ZIP, DOB, BloodGroup, Height, Weight, Policy_No, InsCom_ID,"
	    		+" AppointmentOn, Created "
	    		+ "from appointments a inner join patient p on p.Patient_ID = a.Patient_ID "
	    		+ "where a.Doctor_ID = ? and AppointmentOn > current_timestamp();";
	    Connection connection = null;
	    PreparedStatement selectStmt = null;
	    ResultSet results = null;
	    try {
	      connection = connectionManager.getConnection();
	      selectStmt = connection.prepareStatement(selectappointment);
	      selectStmt.setString(1, Integer.toString(doctor.getDoctor_ID()));
	      results = selectStmt.executeQuery();
	      while (results.next()) {

	    	int appointment_ID = results.getInt("Appointment_ID");
	        int patient_ID = results.getInt("Patient_ID");
	        String first_Name = results.getString("First_Name");
	        String last_Name = results.getString("Last_Name");
	        int age = results.getInt("Age");
	        gender genders = gender.valueOf(results.getString("Gender"));
	        String phone = results.getString("Phone");
	        String street = results.getString("Street");
	        String city1 = results.getString("City");
	        String zip = results.getString("ZIP");
	        Date dob = new Date(results.getTimestamp("DOB").getTime());
	        String bloodgroup = results.getString("BloodGroup");
	        int height = results.getInt("Height");
	        int weight = results.getInt("Weight");
	        long policyno = results.getLong("Policy_No");
	        Insurance ins = new Insurance(results.getInt("InsCom_ID"));
	        Date appointmenton = new Date(results.getTimestamp("AppointmentOn").getTime());
	        Date created = new Date(results.getTimestamp("Created").getTime());
	        //Doctor.gender gender = Doctor.gender.valueOf(results.getString("Gender"));
	       
	        Patient patient = new Patient(patient_ID, first_Name, last_Name, age, genders ,phone, 
	            street, city1, zip, dob, bloodgroup, height, weight, policyno, ins);
	    
	        Appointments appointment = new Appointments(appointment_ID,patient,doctor,appointmenton, created);
	        list.add(appointment);
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
	    return list;
	  } 
}
