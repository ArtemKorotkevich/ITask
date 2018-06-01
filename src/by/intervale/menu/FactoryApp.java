package by.intervale.menu;

import by.intervale.beans.Leadership;
import by.intervale.beans.Manager;
import by.intervale.beans.Worker;

public class FactoryApp {
    public static Worker getWorker(int kind){
      switch (kind) {
        case 1: return new Worker();
        case 2: return new Manager();
        case 3: return new Leadership();
        default:return null;
      }
    }

}
