package by.intervale.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import by.intervale.utils.Constants;
import java.sql.Connection;


public class HelperDB {
  private Connection cn;

  public HelperDB() throws ClassNotFoundException, SQLException {
    cn = DBConnection.getDBConnection();
  }
  
  public Connection getConnection() {
    return cn;
  }
  
  public void close() {
    HelperDB.closeConnection(this.cn);
  }

  public PreparedStatement getPrepareStatement(String sql) throws SQLException {
    return cn.prepareStatement(sql);
  }

  public Statement getStatement() throws SQLException {
    return cn.createStatement();
  }

  public static void closeConnection(Connection connection) {
    if(connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        System.err.println(Constants.ERROR_RESOURCE_CLOSE + e);

      }
    }
  }

  public static void closeStatement(Statement ... statement) {
    for(Statement st : statement) {
      if(st != null) {
        try {
          st.close();
        } catch (SQLException e) {
          System.err.println(Constants.ERROR_RESOURCE_CLOSE + e);
        }
      }
    }
  }

  public static void closeResultSet(ResultSet rs) {
    try {
      if (rs != null && !rs.isClosed()) {
        rs.close();
      }
    } catch (SQLException e) {
      System.err.println(Constants.ERROR_RESOURCE_CLOSE + e);
    }
  }
}

