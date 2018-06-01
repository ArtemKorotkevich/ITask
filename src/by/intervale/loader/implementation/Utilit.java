package by.intervale.loader.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import by.intervale.beans.Leadership;
import by.intervale.beans.Manager;
import by.intervale.beans.Worker;
import by.intervale.menu.Inc;

public class Utilit {
  Inc inc = new Inc();
  List<Worker>workers = new ArrayList<>();
  List<Manager>managers = new ArrayList<>(); 
  List<Leadership>leaderships = new ArrayList<>();
  private static Scanner scanner;
  public  void reading(AbstractReader reader)throws ClassNotFoundException, FileNotFoundException{
    while(reader.hasResult()){
      if(reader instanceof WorkerReader){
        Worker worker = reader.nextResult();
        workers.add(worker);
        System.out.println(workers);
      } else if (reader instanceof ManagerReader) {
        Manager manager = (Manager) reader.nextResult();
        managers.add(manager);
        System.out.println(managers);
      }else if(reader instanceof LeadershipReader) {
        Leadership leadership = (Leadership) reader.nextResult();
        leaderships.add(leadership);
        System.out.println(leaderships);
      }
    }
  }
  public void show(int num){
    if(num == 1){
      System.out.println(workers);
    }else if (num == 2) {
      System.out.println(managers);
    }else if(num == 3){
      System.out.println(leaderships);
    }
  }
  public void deleateWorker(){
    scanner = new Scanner(System.in);
    System.out.println("enter Lastname");
    String name = scanner.next();
    for(Iterator<Worker> iterator = workers.iterator();iterator.hasNext();){
      Worker worker = iterator.next();
      int index = worker.getLastname().indexOf(name);
      if(index > -1){
        iterator.remove();
      }
    }   
  }

  public static int Select(){
    boolean flag = true;
    scanner = new Scanner(System.in);
    while (flag){
      System.out.println("\n1. добавить рабочего.\n2.добавить менеджер.\n3.добавить руководство \n0.Выход.");
      String str = scanner.nextLine();
      switch (str){
        case "1": return 1;
        case "2": return 2;
        case "3": return 3;
        case "0": flag =false; break;
      }
    }
    return 0;
  }

  public void createNewWorker(){
    scanner = new Scanner(System.in);
    System.out.println("enter name worker");
    scanner.next();
    System.out.println("enter Lastname");
    scanner.next();
    System.out.println("enter birthday");
    scanner.next();
    System.out.println("enter date of employment");
    scanner.next();
    workers.add(inc.makeWorker(Select()));
  }

  public void createNewManager(){
    scanner = new Scanner(System.in);
    System.out.println("enter name Manager");
    scanner.next();
    System.out.println("enter Lastname");
    scanner.next();
    System.out.println("enter birthday");
    scanner.next();
    System.out.println("enter date of employment");
    scanner.next();
    System.out.println("enter Worker Lastname");
    scanner.next();
    managers.add(inc.makeManager(Select()));
  }
  public void createNewLeadership(){
    scanner = new Scanner(System.in);
    System.out.println("enter name Leadership");
    scanner.next();
    System.out.println("enter Lastname");
    scanner.next();
    System.out.println("enter birthday");
    scanner.next();
    System.out.println("enter date of employment");
    scanner.next();
    System.out.println("enter position");
    scanner.next();
    leaderships.add(inc.makeLeadership(Select()));
  }


  public void save(){
    try {
      PrintWriter pw = new PrintWriter(new File("src/out.txt"));
      pw.println(workers);
      pw.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }      
  }
  public void saveManager(){
    try {
      PrintWriter pw = new PrintWriter(new File("src/outManager.txt"));
      pw.println(managers);
      pw.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }      
  }
  public void saveLead(){
    try {
      PrintWriter pw = new PrintWriter(new File("src/outLead.txt"));
      pw.println(leaderships);
      pw.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }      
  }
}


