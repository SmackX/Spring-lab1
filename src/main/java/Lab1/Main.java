package Lab1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account account = context.getBean("account", Account.class);
        BankServices services = context.getBean("services", BankServices.class);
        TerminalMenu menu = context.getBean("menu", TerminalMenu.class);
        int loop = 0;
        Scanner _scan = new Scanner(System.in);
        //Start
        account.Pin();

        do {
            menu.menu();
            services.Scan();
            System.out.println("do you want to repeat it?");
            System.out.println("0 - Yes");
            System.out.println("1 - No");
            loop = _scan.nextInt();
        }while (loop == 0);
        System.out.println("Enter new pin-code");
        Account account1 = context.getBean("accountPin", Account.class);
        int newPin = _scan.nextInt();
        account1.setPin(newPin);
        account1.Pin();
    }
}
