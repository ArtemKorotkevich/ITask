
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
      System.out.println("��������� �������: \n1.������������� �����������. \n2. �������� ����������� \n3.�������� .\n4.�������."
          + "\n5.��������� ��������� � ����. \n0.�����.");
      int counter = in.nextInt();
      switch (counter) {
        case 1: 
          System.out.println("��������� �������: \n1.�������   \n2. �������� .\n3.����������� .\n0.�����.");
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
          System.out.println("��������� �������: \n1.�������   \n2. �������� .\n3.����������� .\n0.�����.");
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
          System.out.println("��������� �������: \n1.�������   \n2. �������� .\n3.����������� .\n0.�����.");
          int number = in.nextInt();
          if(number == 1){
            utilit.deleateWorker();
          }
          break;

        case 5:
          System.out.println("��������� �������: \n1.�������   \n2. �������� .\n3.����������� .\n0.�����.");
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


