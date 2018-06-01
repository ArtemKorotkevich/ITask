package by.intervale.loader.implementation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import by.intervale.beans.Manager;
import by.intervale.exception.FileLineException;
import by.intervale.utils.Constants;

public class ManagerReader extends AbstractReader {
  private Manager manager = new Manager();
  private Scanner scan;
  private static int NAME_IND = 0, LASTNAME_IND = 1, BIRTHDAT_IND = 2, DATE_OF_EMPLOYMENT_IND = 3, LIST_WORKERS_IND = 4;

  public ManagerReader(String filename) throws IOException {
    super(filename);
    this.scan = new Scanner(new FileReader(filename));
  }

  @Override
  public boolean hasResult() {
    return scan.hasNext();
  }
  @Override
  public Manager nextResult() {
    String csvLine = scan.next();
    String[] values = csvLine.split(Constants.CSV_DELIMETER);
    try {
      manager.setName(values[NAME_IND]);
      manager.setLastname(values[LASTNAME_IND]);
      manager.setBirthdayDate(values[BIRTHDAT_IND]);;
      manager.setDateOfEmployment(values[DATE_OF_EMPLOYMENT_IND]);
      manager.setWorkerList(values[LIST_WORKERS_IND]);
      return new Manager(values[NAME_IND], values[LASTNAME_IND], values[BIRTHDAT_IND], values[DATE_OF_EMPLOYMENT_IND], values[LIST_WORKERS_IND]);
    } catch(NumberFormatException e){
      throw new FileLineException(Constants.ERROR_FORMAT_MARK, csvLine);
    } catch(RuntimeException e) {
      throw new FileLineException(e, csvLine);
    }
  }

  @Override
  public void closeReader() {
    if(scan != null) {
      scan.close();
    } 
  }
}