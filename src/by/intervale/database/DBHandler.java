package by.intervale.database;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Date;
import by.intervale.beans.Leadership;
import by.intervale.beans.Manager;
import by.intervale.beans.Worker;
import by.intervale.loader.implementation.AbstractReader;
import by.intervale.loader.implementation.ManagerReader;
import by.intervale.loader.implementation.WorkerReader;
import by.intervale.utils.Constants;

public class DBHandler {
  private static final String ADD_WORKER_DB =  "INSERT INTO 'intervale'.'worker' ('name', 'lastName', 'birthday', 'dateOfEmployment') VALUES(?,?,?,?);";
  private static final String ADD_MANAGER_DB = "INSERT INTO 'intervale'.'manager'('name', 'lastName', 'birthday', 'dateOfEmployment') VALUES(?,?,?,?);";
  private static final String ADD_LEADERSHIP_DB = "INSERT INTO `intervale`.`leadership` (`name`,`lastname`, `birthday`, `dateOfEmployment`, `discription`) VALUES (?,?,?,?,?);";
  private static final String SELECT_WORKER_DB = "SELECT * FROM intervale.worker;";
  private static final String SELECT_MANAGER_DB = "SELECT * FROM intervale.manager;";
  private static final String SELECT_LEADERSHIP_DB = "SELECT * FROM intervale.leadership;";
  private static final String ADD_WORKERS_DB = "INSERT INTO `intervale`.`worker` (`name`, `lastName`, `birthday`, `dateOfEmployment`) VALUES (?, ?, ?, ?);";
  private static final String DELETE_WORKERS_DB = "DELETE FROM `intervale`.`worker` WHERE `idworker`='?';";
  private static Scanner scanner;


  public static void importDB(AbstractReader reader) throws SQLException, ClassNotFoundException, FileNotFoundException{
    Connection cn = null;
    HelperDB helper = null;
    
    try{
      helper = new HelperDB();
      cn = helper.getConnection();
      while(reader.hasResult()){
        Worker worker = reader.nextResult();
        if (reader instanceof WorkerReader) {
        helper.getPrepareStatement(ADD_WORKER_DB);
          PreparedStatement ps = helper.getPrepareStatement(ADD_WORKER_DB);
          ps.setString(1, worker.getName());
          ps.setString(2, worker.getLastname());
          ps.setString(3, worker.getStringBirthday());
          ps.setString(4, worker.getStringDateOfEmployment());
          ps.execute();
        }else if (reader instanceof ManagerReader) {
          Manager manager = (Manager) reader.nextResult();
          PreparedStatement ps = helper.getPrepareStatement(ADD_MANAGER_DB);
              ps.setString(1, manager.getName());
              ps.setString(2, manager.getLastname());
              ps.setString(3, manager.getStringBirthday());
              ps.setString(4, manager.getStringDateOfEmployment());
              ps.execute();
        }else{
          Leadership leadership = (Leadership) reader.nextResult();
          PreparedStatement ps = helper.getPrepareStatement(ADD_LEADERSHIP_DB);
          ps.setString(1, leadership.getName());
          ps.setString(2, leadership.getLastname());
          ps.setString(3, leadership.getStringBirthday());
          ps.setString(4, leadership.getStringDateOfEmployment());
          ps.setString(5, leadership.getDescription());
          ps.execute();
        } 
      }
    }catch(SQLException e){
      throw new SQLException(Constants.ERROR_INSERT_RESULT + e);
    }finally {
      reader.closeReader();
    }
  }
  
  
  
  public void show() throws SQLException, ClassNotFoundException{
    Connection cn;
    HelperDB helper = null;
    Statement statement = null;
    try{
      helper = new HelperDB();
      cn = helper.getConnection();
      statement = helper.getStatement();
      ResultSet resultSet = statement.executeQuery(SELECT_WORKER_DB);
      while(resultSet.next()){
        String name = resultSet.getString("name");
        String lastname = resultSet.getString("lastname");
        Date birthday = resultSet.getDate("birthday");
        Date DateOfEmployment = resultSet.getDate("DateOfEmployment");
        System.out.println("Worker:" + "\t"+ name + "\t"+ lastname + "\t"+ birthday + "\t" + DateOfEmployment+  ";");
      }
    }catch(SQLException e){
      throw new SQLException(Constants.ERROR_INSERT_RESULT + e);
    }finally {
      if(statement != null){statement.close();}
    }
  }
  public static void addUsers(Worker worker) throws ClassNotFoundException, SQLException{
    HelperDB helper = new HelperDB();
    Connection cn = helper.getConnection();
    try{
      PreparedStatement ps = cn.prepareStatement(ADD_WORKERS_DB);
      ps.setString(1, worker.getName());
      ps.setString(2, worker.getLastname());
      ps.setDate(3, worker.getBirthday());
      ps.setDate(4, worker.getDateOfEmployment());
      ps.execute();
      ps.close();
    }catch(Exception e){
      System.err.println(e.getMessage());
    }
    
    
  }
  
  public static Worker returnWorker(){
    scanner = new Scanner(System.in);
    while(scanner.hasNext()){
      System.out.println("name");
      String name =  scanner.next();
      System.out.println("Lastname");
      String lastname = scanner.next();
      System.out.println("Birthday");
      String birthday = scanner.next();
      System.out.println("DateOfEmployment");
      String dateOfEmployment = scanner.next();
      return new Worker(name, lastname, birthday, dateOfEmployment);
  }
    return returnWorker();

}
  public static void deletWorker(int numbers) throws ClassNotFoundException, SQLException{
    HelperDB helper = new HelperDB();
    Connection cn = helper.getConnection();
    try{
        PreparedStatement ps = cn.prepareStatement(DELETE_WORKERS_DB);
        ps.executeUpdate();
    }catch(SQLException e){
      e.printStackTrace();
    }
  }
}
