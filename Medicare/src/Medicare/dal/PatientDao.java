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


import Medicare.model.Insurance;
import Medicare.model.Patient;
import Medicare.model.gender;




public class PatientDao {
	protected ConnectionManager connectionManager;

	private static PatientDao instance = null;
	protected PatientDao() {
		connectionManager = new ConnectionManager();
	}
	public static PatientDao getInstance() {
		if(instance == null) {
			instance = new PatientDao();
		}
		return instance;
	}

	public Patient create(Patient patient) throws SQLException {
		String insertPatient =
			"INSERT INTO patient(First_Name, Last_Name, Age, Gender, Phone, Street, City," +  
			"ZIP, DOB, BloodGroup, Height, Weight, Policy_No, InsCom_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertPatient,
				Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, patient.getFirst_name());
			insertStmt.setString(2, patient.getLast_name());
			insertStmt.setInt(3, patient.getAge());
			insertStmt.setString(4, patient.getGender().name());
			insertStmt.setString(5, patient.getPhone());
			insertStmt.setString(6, patient.getStreet());
			insertStmt.setString(7, patient.getCity());
			insertStmt.setString(8, patient.getZip());
			insertStmt.setTimestamp(9, new Timestamp(patient.getDob().getTime()));
			insertStmt.setString(10, patient.getBloodgroup());
			insertStmt.setInt(11, patient.getHeight());
			insertStmt.setInt(12, patient.getWeight());
			insertStmt.setLong(13, patient.getPolicy_no());
			insertStmt.setInt(14, patient.getInsCom().getInsCom_ID());
			insertStmt.executeUpdate();
			
			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			resultKey = insertStmt.getGeneratedKeys();
			int patientId = -1;
			if(resultKey.next()) {
				patientId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			patient.setPatient_ID(patientId);
			return patient;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
			if(resultKey != null) {
				resultKey.close();
			}
		}
	}

	public Patient delete(Patient patient) throws SQLException {
	    String deletepatient = "DELETE FROM patient WHERE Patient_ID=?;";
	    Connection connection = null;
	    PreparedStatement deleteStmt = null;
	    try {
	      connection = connectionManager.getConnection();
	      deleteStmt = connection.prepareStatement(deletepatient);
	      deleteStmt.setInt(1, patient.getPatient_ID());
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
	
	  public List<Patient> getPatientByFirstnameAndLastname(String first_name,String last_name) throws SQLException {
	      List<Patient> patientlist = new ArrayList<Patient>();
	      String selectpatient =
	          "SELECT First_Name, Last_Name, Age, Gender, Phone, Street, City, ZIP, DOB, BloodGroup, Height, Weight, Policy_No, InsCom_ID FROM patient WHERE First_Name = ? and Last_Name = ? ;";
	      Connection connection = null;
	      PreparedStatement selectStmt = null;
	      ResultSet results = null;
	      try {
	        connection = connectionManager.getConnection();
	        selectStmt = connection.prepareStatement(selectpatient);
	        selectStmt.setString(1, first_name);
	        selectStmt.setString(2, last_name);
	        results = selectStmt.executeQuery();
	        while (results.next()) {

	 

	          String first_Name = results.getString("First_Name");
	          String last_Name = results.getString("Last_Name");
	          int age = results.getInt("Age");
	          gender gender1 = gender.valueOf(results.getString("Gender"));
	          String phone = results.getString("Phone");
	          String street = results.getString("Street");
	          String city1 = results.getString("City");
	          String zip = results.getString("ZIP");
	          Date dob = results.getDate("DOB");
	          String bloodgroup = results.getString("BloodGroup");
	          int height = results.getInt("Height");
	          int weight = results.getInt("Weight");
	          long policyNo = results.getLong("Policy_No");
	          Insurance ins = new Insurance(results.getInt("InsCom_ID"));
	          
	          Patient pat = new Patient(first_Name, last_Name, age, gender1, phone, street, city1, zip, dob, bloodgroup, height, weight, policyNo, ins);
	          patientlist.add(pat);
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
	      return patientlist;
	    }
	 
}
