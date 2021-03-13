package ATM;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Service {
    public static Scanner _scan = new Scanner(System.in);
    Users user;
    Service(Users user){
        this.user = user;
    }
    public void run(){
        Registry();
        InfoUser();
        ShowDB();
    }

    private void ShowDB(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DBConnection db = context.getBean("DB", DBConnection.class);
        List<Users> PersonDB = new ArrayList<>();
        PersonDB = db.getBD();
        for (int i = 0; i < 3; i++) {
            Users user = PersonDB.get(i);
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getPassword());
            System.out.println(user.getSum());
        }
        context.close();
    }

    public void Registry(){
        Random random = new Random();
        user.setId(random.nextInt(899)+100);
        if (user.getName().equals(null)) {
            System.out.println("Your name?");
            user.setName(_scan.next());
        }if (user.getPassword().equals(null)) {
            System.out.println("Create password");
            user.setPassword(_scan.next());
        }
        System.out.println("Enter sum");
        user.setSum(_scan.nextInt());
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

}
