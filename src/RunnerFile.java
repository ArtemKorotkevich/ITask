
import java.io.IOException;
import java.util.Scanner;
import by.intervale.loader.implementation.LeadershipReader;
import by.intervale.loader.implementation.ManagerReader;
import by.intervale.loader.implementation.Utilit;
import by.intervale.loader.implementation.WorkerReader;
import static by.intervale.loader.implementation.Utilit.Select;


public class RunnerFile {

  private static Scanner in;

  public static void main(String[] args) throws ClassNotFoundException, IOException{
    Utilit utilit = new Utilit();
    in = new Scanner(System.in); 
    boolean flag = true;
    while (flag){
      System.out.println("Доступные команды: \n1.Импортировать сотрудников. \n2. показать сотрудников \n3.Добавить .\n4.Удалить."
          + "\n5.Сохранить изминения в файл. \n0.Выход.");
      int counter = in.nextInt();
      switch (counter) {
        case 1: 
          System.out.println("Доступные команды: \n1.рабочий   \n2. менеджер .\n3.руководство .\n0.Выход.");
          int numb = in.nextInt();
          if(numb == 1){
            WorkerReader workerReader = new WorkerReader("src/in.txt");
            utilit.reading(workerReader);
          }else if (numb == 2) {
            ManagerReader managerReader = new ManagerReader("src/manager.txt");
            utilit.reading(managerReader);
          }else if (numb == 3){
            LeadershipReader leadershipReader = new LeadershipReader("src/lead.txt");
            utilit.reading(leadershipReader);
          }
          break;    
        case 2:
          System.out.println("Доступные команды: \n1.рабочий   \n2. менеджер .\n3.руководство .\n0.Выход.");
          int num = in.nextInt();
          utilit.show(num);
          break;
        case 3:
          Select();
          utilit.createNewWorker();
          utilit.createNewManager();
          utilit.createNewLeadership();
          break;

        case 4:
          System.out.println("Доступные команды: \n1.рабочий   \n2. менеджер .\n3.руководство .\n0.Выход.");
          int number = in.nextInt();
          if(number == 1){
            utilit.deleateWorker();
          }
          break;

        case 5:
          System.out.println("Доступные команды: \n1.рабочий   \n2. менеджер .\n3.руководство .\n0.Выход.");
          int numbers = in.nextInt();
          if(numbers == 1){
            utilit.save();
          }else if (numbers == 2) {
            utilit.saveManager();
          }else if(numbers == 3){
            utilit.saveLead();
          }
          break;

        case 0: flag=false; break;
      }
    }
  }}


