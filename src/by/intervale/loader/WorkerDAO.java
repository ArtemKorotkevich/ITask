package by.intervale.loader;

import by.intervale.beans.Worker;

public interface WorkerDAO {
  boolean hasResult();
  
  Worker nextResult();
  
  void closeReader();

}
