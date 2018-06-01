package by.intervale.database;
import java.sql.DriverManager;
import java.sql.Connection;
public class DBConnection {

  static Connection connection = null;
  
  private DBConnection(){
  
  }
  public static Connection getDBConnection(){
      String URL = "jdbc:mysql://localhost:3306/intervale?&amp;allowMultiQueries=true";
      String user = "root";
      String pass = "root";
      try{
          
          if(connection ==null){
              Class.forName("com.mysql.jdbc.Driver");
              connection = DriverManager.getConnection(URL, user, pass);
              
              
          }
          
      }catch(Exception e ){
          e.printStackTrace();
      }
      return connection;
  }
}
