package by.intervale.loader.implementation;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import by.intervale.beans.Leadership;
import by.intervale.beans.Worker;
import by.intervale.exception.FileLineException;
import by.intervale.utils.Constants;

public class LeadershipReader extends AbstractReader {
private Scanner scan;
private Leadership leadership = new Leadership();
private static int NAME_IND = 0, LASTNAME_IND = 1, BIRTHDAT_IND = 2, DATE_OF_EMPLOYMENT_IND = 3, DISCRIPTION_IND =4;

  public LeadershipReader(String filename) throws IOException {
    super(filename);
    this.scan = new Scanner(new FileReader(filename));
  }

  @Override
  public boolean hasResult() {
    return scan.hasNext();
  }
  
  @Override
  public Worker nextResult() {
    String csvLine = scan.nextLine();
    String[] values = csvLine.split(Constants.CSV_DELIMETER);
    try {
      leadership.setName(values[NAME_IND]);
      leadership.setLastname(values[LASTNAME_IND]);
      leadership.setBirthdayDate(values[BIRTHDAT_IND]);
      leadership.setDateOfEmployment(values[DATE_OF_EMPLOYMENT_IND]);
      leadership.setDescription(values[DISCRIPTION_IND]);
      return new Leadership(values[NAME_IND], values[LASTNAME_IND], values[BIRTHDAT_IND],values[DATE_OF_EMPLOYMENT_IND], values[DISCRIPTION_IND]);
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
