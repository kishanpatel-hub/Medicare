package Medicare.dal;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Medicare.model.Referral;

import java.lang.*;

 

 


public class ReferralDao {
    protected ConnectionManager connectionManager;

 


  private static ReferralDao instance = null;

 

  protected ReferralDao() {
    connectionManager = new ConnectionManager();
  }

 

  public static ReferralDao getInstance() {
    if (instance == null) {
      instance = new ReferralDao();
    }
    return instance;
  }
  
  public Referral create(Referral referral) throws SQLException {
    String insertreferral =
        "INSERT INTO Referral(R_Patient_ID,ReferredBy,ReferredTo,Notes) VALUES(?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertreferral,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, referral.getPatient_ID().getPatient_ID());
      insertStmt.setInt(2, referral.getReferredBy().getDoctor_ID());
      insertStmt.setInt(3, referral.getReferredTo().getDoctor_ID());
      insertStmt.setString(4, referral.getNotes());
      insertStmt.executeUpdate();

 

      return referral;
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
}
 