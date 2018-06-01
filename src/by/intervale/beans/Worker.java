package by.intervale.beans;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Worker {
  private final static SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
  
  private String name;
  private String Lastname;
  private Date Birthday;
  private Date DateOfEmployment;
  
  public String getName() {
    return name;
  }

  public String getLastname() {
    return Lastname;
  }

  public Date getBirthday() {
    return Birthday;
  }

  public Date getDateOfEmployment() {
    return DateOfEmployment;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLastname(String lastname) {
    Lastname = lastname;
  }

  public void setBirthday(Date birthday) {
    this.Birthday = birthday;
  }
  
  public void setBirthdayDate(String birthday) {
    try {
        this.Birthday = Date.valueOf(birthday);
    } catch(IllegalArgumentException e) {
        throw new IllegalArgumentException("Wrong data format");
    }
}

public String getStringBirthday() {
    return OUTPUT_DATE_FORMAT.format(Birthday); 
}

  public void setDateOfEmployment(Date dateOfEmployment) {
    this.DateOfEmployment = dateOfEmployment;
  }
  
  public void setDateOfEmployment(String dateOfEmployment) {
    try {
        this.DateOfEmployment = Date.valueOf(dateOfEmployment);
    } catch(IllegalArgumentException e) {
        throw new IllegalArgumentException("Wrong data format");
    }
}

public String getStringDateOfEmployment() {
    return OUTPUT_DATE_FORMAT.format(Birthday); 
}

  public Worker() {
    super();
  }

  public Worker(String name, String lastname, Date birthday, Date dateOfEmployment) {
    super();
    this.name = name;
    Lastname = lastname;
    this.Birthday = birthday;
    this.DateOfEmployment = dateOfEmployment;
  }
  public Worker(String name, String lastname, String birthday, String dateOfEmployment) {
    super();
    this.name = name;
    Lastname = lastname;
    setBirthdayDate(birthday);
    setDateOfEmployment(dateOfEmployment);
  }

  @Override
  public String toString() {
    return "Worker [name=" + name + ", Lastname=" + Lastname + ", Birthday=" + Birthday
        + ", DateOfEmployment=" + DateOfEmployment + "]";
  } 
}
