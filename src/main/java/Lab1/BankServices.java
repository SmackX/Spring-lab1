package Lab1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class BankServices {
    int sumAccount = 120000;
    int choose;
    int sum;
    Scanner _scan = new Scanner(System.in);

    public void Scan(){
        choose = _scan.nextInt();
        if (choose != 1) {
            System.out.println("Enter sum");
            sum = _scan.nextInt();
        }
        switch (choose){
            case 1: CheckAccount();
            break;
            case 2: WithdrawSumAccount(sum);
            break;
            case 3: TopUpSumAccount(sum);
            break;
        }

    }
    private int WithdrawSumAccount(int tmp) {
        System.out.println("process done!");
        return sumAccount -= tmp;
    }

    private void TopUpSumAccount(int tmp) {
        System.out.println("process done!");
        this.sumAccount += tmp;
    }
    private void CheckAccount(){
        System.out.println(sumAccount);
    }

}
