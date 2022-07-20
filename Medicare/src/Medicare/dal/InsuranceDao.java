package Medicare.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import Medicare.model.Insurance;
import Medicare.model.Patient;

public class InsuranceDao {
	protected ConnectionManager connectionManager;

	private static InsuranceDao instance = null;
	protected InsuranceDao() {
		connectionManager = new ConnectionManager();
	}
	public static InsuranceDao getInstance() {
		if(instance == null) {
			instance = new InsuranceDao();
		}
		return instance;
	}

	public Insurance create(Insurance insurance) throws SQLException {
		String insertInsurance =
			"INSERT INTO insurance(InsCom_Name, Phone, Email, Address) VALUES(?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertInsurance,
				Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, insurance.getInsCom_Name());
			insertStmt.setString(2, insurance.getPhone());
			insertStmt.setString(3, insurance.getEmail());
			insertStmt.setString(4, insurance.getAddress());
			insertStmt.executeUpdate();
			
			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			resultKey = insertStmt.getGeneratedKeys();
			int insComId = -1;
			if(resultKey.next()) {
				insComId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			insurance.setInsCom_ID(insComId);
			return insurance;
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
	
	public List<Insurance> list() throws SQLException {
        List<Insurance> listInsurance = new ArrayList<>();
        
        String sql = "SELECT * FROM insurance order by InsCom_Name";
        
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try  {
        	connection = connectionManager.getConnection();
            
            
            selectStmt = connection.prepareStatement(sql);
            results = selectStmt.executeQuery();
             
            while (results.next()) {
                int id = results.getInt("InsCom_ID");
                String name = results.getString("InsCom_Name");
                String phone = results.getString("Phone");
                String email = results.getString("Email");
                String address = results.getString("Address");
                Insurance insurance = new Insurance(id, name, phone, email, address);
                     
                listInsurance.add(insurance);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(selectStmt != null) {
                selectStmt.close();
            }
            if(results != null) {
                results.close();
            }
        } 
         
        return listInsurance;
    }

}
