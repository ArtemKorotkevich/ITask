package by.intervale.loader.implementation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import by.intervale.beans.Worker;

public abstract class AbstractReader {
  private Scanner scanner;
  
  public AbstractReader(String filename) throws IOException {
    this.scanner = new Scanner(new FileReader(filename));
  }

  public Scanner getScanner() {
    return scanner;
  }

  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }
  
  public abstract boolean hasResult();
  public abstract Worker nextResult();
  public abstract void closeReader();
}
