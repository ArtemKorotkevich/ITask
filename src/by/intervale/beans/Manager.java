package by.intervale.beans;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Manager extends Worker {
  private final static SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
  private String workerList;
  
  public Manager() {
    super();
  }

  public Manager(String name, String lastname, Date birthday, Date dateOfEmployment,  String workerList ){
    super(name, lastname, birthday, dateOfEmployment);
    this.workerList = workerList;
  }
  

  public String getWorkerList() {
    return workerList;
  }

  public void setWorkerList(String workerList) {
    this.workerList = workerList;
  }

  public Manager(String name, String lastname, String birthday, String dateOfEmployment, String workerList ) {
    super(name, lastname, birthday, dateOfEmployment);
    this.workerList = workerList;
  }

  @Override
  public String toString() {
    return "Manager [workerList=" + workerList + "]";
  }
}
