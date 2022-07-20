package Medicare.dal;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Medicare.model.Reviews;


 

public class ReviewsDao {
  protected ConnectionManager connectionManager;

 


  private static ReviewsDao instance = null;

 

  protected ReviewsDao() {
    connectionManager = new ConnectionManager();
  }

 

  public static ReviewsDao getInstance() {
    if (instance == null) {
      instance = new ReviewsDao();
    }
    return instance;
  }

 

    public Reviews delete(Reviews review) throws SQLException {
        String deletereview = "DELETE FROM Reviews WHERE Review_ID=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deletereview);
            deleteStmt.setInt(1, review.getReview_ID());
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
}