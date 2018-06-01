package by.intervale.factory;

import java.io.IOException;
import by.intervale.loader.implementation.AbstractReader;
import by.intervale.loader.implementation.LeadershipReader;
import by.intervale.loader.implementation.ManagerReader;
import by.intervale.loader.implementation.WorkerReader;

public enum EnumEmployees {
  WORKER{

    @Override
    public AbstractReader getInstance(String filename) throws IOException {
      return new WorkerReader(filename);
    }
    
  },
  MANAGER{

    @Override
    public AbstractReader getInstance(String filename) throws IOException {
      return new ManagerReader(filename);
    }
    
  },
  LEADERSHIP{

    @Override
    public AbstractReader getInstance(String filename) throws IOException {
      return new LeadershipReader(filename);
    }
    
  };
  
  public abstract AbstractReader  getInstance(String filename) throws IOException;
}


