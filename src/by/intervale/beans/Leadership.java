package by.intervale.beans;

import java.sql.Date;

public class Leadership extends Worker {
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Leadership() {
    super();
  }

  public Leadership(String name, String lastname, Date birthday, Date dateOfEmployment,String description) {
    super(name, lastname, birthday, dateOfEmployment);
    this.description = description;
  }
  public Leadership(String name, String lastname, String birthday, String dateOfEmployment, String description) {
    super(name, lastname, birthday, dateOfEmployment);
    this.description = description;
  }


  @Override
  public String toString() {
    return "Leadership [description=" + description + "]";
  }

 

  
  
  
}
