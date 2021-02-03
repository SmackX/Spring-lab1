package Lab1;

import java.util.Scanner;

public class Account {
    int pin = 32154;
    Scanner _scan = new Scanner(System.in);

    public Account(int pin) {
        this.pin = pin;
    }
    public Account(){};

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void Pin(){
        System.out.println("Enter pin-code");
        do {
            if (pin == _scan.nextInt()) {
                System.out.println("Ok");
                break;
            }else {
                System.out.println("Your pin-code error");
            }
        }while (true);
    }
}
