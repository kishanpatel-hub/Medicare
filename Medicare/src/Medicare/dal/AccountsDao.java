package Medicare.dal;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Medicare.model.Accounts;



public class AccountsDao {
	 protected ConnectionManager connectionManager;

	  private static AccountsDao instance = null;

	  protected AccountsDao() {
	    connectionManager = new ConnectionManager();
	  }

	  public static AccountsDao getInstance() {
	    if (instance == null) {
	      instance = new AccountsDao();
	    }
	    return instance;
	  }

	  public Accounts create(Accounts account) throws SQLException {
	    // Insert into the superclass table first.
	    String insertaccount = "INSERT INTO accounts(ID,Username,Password) VALUES(?,?,?);";
	    Connection connection = null;
	    PreparedStatement insertStmt = null;
	    ResultSet resultKey = null;
	    try {
	      connection = connectionManager.getConnection();
	      insertStmt = connection.prepareStatement(insertaccount);
	      insertStmt.setInt(1, account.getId());
	      insertStmt.setString(2, account.getUsername());
	      insertStmt.setString(3, account.getPassword());	     
	      insertStmt.executeUpdate();

	      return account;
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
	  
	  public Accounts getAccountforPatient(String username, String password) throws SQLException {
		    String selectaccount =
		    		"select ID "
		    		+ "from accounts where Username = ? and Password = ?;";
		    		
		    Connection connection = null;
		    PreparedStatement selectStmt = null;
		    ResultSet results = null;
		    try {
		      connection = connectionManager.getConnection();
		      selectStmt = connection.prepareStatement(selectaccount);
		      selectStmt.setString(1, username);
		      selectStmt.setString(2, password);
		      results = selectStmt.executeQuery();
		      if (results.next()) {

		    	int ID = results.getInt("ID");
		    	Accounts account = new Accounts(ID, username, password);
		    	return account;
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
		    return null;
		  }  
}
