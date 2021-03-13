package ATM;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component("service")
public class Service {
    public static Scanner _scan = new Scanner(System.in);
    Users user;
    Service(Users user){
        this.user = user;
    }
    public void run() {

        ShowDB();
        System.out.println("Do you want add new Person");
        if (_scan.next().equals("Yes")) {
            Registry();
            ShowDB();
        }
        System.out.println("Do you want delete any Person");
        if (_scan.next().equals("Yes")) {
            Delete();
            ShowDB();
        }
    }
    private static int lastid;
    private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private static DBConnection db = context.getBean("DB", DBConnection.class);

    private void ShowDB(){
        List<Users> PersonDB = new ArrayList<>();
        PersonDB = db.getBD();
        for (int i = 0; i < PersonDB.size(); i++) {
            Users user = PersonDB.get(i);
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getPassword());
            System.out.println(user.getSum());
            lastid = user.getId();
        }
        context.close();
    }

    public void Registry(){
        System.out.println("Name for registration: ");
        String newName = _scan.next();
        System.out.println("Password: ");
        String newPassword = _scan.next();
        System.out.println("How many budget?");
        int newSum = _scan.nextInt();

        db.AddToDB(lastid+1, newName, newPassword, newSum);

    }
    public void InfoUser(){
        System.out.println("Your ID: "+user.getId());
        System.out.println("Your name: "+user.getName());
        System.out.println("Your password: "+user.getPassword());
        System.out.println("Your sum on card: "+user.getSum());
    }
    public void DoMyInit(){
        System.out.println("Service open!");
        System.out.println("Initialization");
    }
    public void DoMyDestroy(){
        System.out.println("Service close!");
    }
    public void Delete(){
        System.out.println("Enter id, who want to delete from database: ");
        int id = _scan.nextInt();
        db.DeleteFromDB(id);
    }
}
