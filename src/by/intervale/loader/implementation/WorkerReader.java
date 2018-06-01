package by.intervale.loader.implementation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import by.intervale.beans.*;
import by.intervale.exception.FileLineException;
import by.intervale.utils.Constants;

public class WorkerReader extends AbstractReader {
  private Scanner scan;
  private Worker worker = new Worker();
  private static int NAME_IND = 0, LASTNAME_IND = 1, BIRTHDAT_IND = 2, DATE_OF_EMPLOYMENT_IND = 3;

  public WorkerReader(String filename) throws IOException {
    super(filename);
    this.scan = new Scanner(new FileReader(filename));
  }

  @Override
  public boolean hasResult() {  
    return scan.hasNextLine();
  }
  
@Override
  public Worker nextResult() {
      String Line = scan.nextLine();
      String[] values = Line.split(Constants.CSV_DELIMETER);
    try {
      worker.setName(values[NAME_IND]);
      worker.setLastname(values[LASTNAME_IND]);
      worker.setBirthdayDate(values[BIRTHDAT_IND]);
      worker.setDateOfEmployment(values[DATE_OF_EMPLOYMENT_IND]);
      return new Worker(values[NAME_IND], values[LASTNAME_IND], values[BIRTHDAT_IND], values[DATE_OF_EMPLOYMENT_IND]);
    } catch(NumberFormatException e){
      throw new FileLineException(Constants.ERROR_FORMAT_MARK, Line);
    } catch(RuntimeException e) {
      throw new FileLineException(e, Line);
    }
  }
  @Override
  public void closeReader() {
    if(scan != null) {
      scan.close();
    } 
  }


}
