package by.intervale.menu;

import by.intervale.beans.Leadership;
import by.intervale.beans.Manager;
import by.intervale.beans.Worker;

public class Inc {
  public Worker makeWorker(int kind){
    Worker worker = FactoryApp.getWorker(kind);
    return worker;
  }
  public Manager makeManager(int kind){
    Manager manager = (Manager) FactoryApp.getWorker(kind);
    return manager;
  }
  
  public Leadership makeLeadership(int kind){
    Leadership leadership = (Leadership) FactoryApp.getWorker(kind);
    return leadership ;
  }
}
