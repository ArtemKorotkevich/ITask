import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import by.intervale.beans.Worker;
import by.intervale.database.DBHandler;
import by.intervale.database.HelperDB;
import by.intervale.loader.implementation.LeadershipReader;
import by.intervale.loader.implementation.ManagerReader;
import by.intervale.loader.implementation.WorkerReader;

public class RunnerDB {

  private static Scanner scanner;

  public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
    HelperDB db =  new HelperDB();    
    boolean flag = true;
    scanner = new Scanner(System.in);
    while (flag){
      db.getConnection();
      System.out.println("��������� �������: \n1.������������� ����������� � ����. \n2. �������� ����������� \n3.�������� ."
          + "\n4.�������. \n0.�����.");
      int counter = scanner.nextInt();
      switch (counter) {
        case 1: 
          System.out.println("��������� �������: \n1.�������   \n2. �������� .\n3.����������� .\n0.�����.");
          int numb = scanner.nextInt();
          if(numb == 1){
            WorkerReader workerReader = new WorkerReader("src/in.txt");
            DBHandler.importDB(workerReader);
            db.close();
          }else if(numb == 2){
            ManagerReader managerReader = new ManagerReader("src/manager.txt");
            DBHandler.importDB(managerReader);
            db.close();
          }else if(numb == 3){
            LeadershipReader leadershipReader = new LeadershipReader("src/lead.txt");
            DBHandler.importDB(leadershipReader);
            db.close();    
          }break;
        case 2:
          DBHandler dbHandler = new DBHandler();
          dbHandler.show();
          break;
        case 3: 
          Worker worker = DBHandler.returnWorker();
          DBHandler.addUsers(worker);
          break; 
        case 4:
          System.out.println("������� ����� ��������� ������� ���� �������");
          int numbers = scanner.nextInt();
          DBHandler.deletWorker(numbers);
          break;
        case 0: flag = false; break;

      }   
    }
  }
}

