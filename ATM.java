import java.util.Scanner;
import java.util.HashMap;

public class ATM {
    public static void main(String [] args){
        ATMop obj = new ATMop();

    }
}

class Data{
    float balance;
}

class ATMop{
    Scanner sc=new Scanner(System.in);
    HashMap<Integer,Data> hm = new HashMap<>();
    float balance;
    ATMop(){
        System.out.println("Welcome to out ATM");
        op();
    }

    public void op(){
        System.out.println("********************************************************************");
        System.out.println("Enter your pin");
        int pin = sc.nextInt();
        
        if(hm.containsKey(pin)){
            Data obj = hm.get(pin);
            menu(obj);
        }
        else{
            System.out.println("********************************************************************");
            System.out.println("Please create Account first");
            System.out.println("Set your pin");
            int pin2 = sc.nextInt();
            Data obj = new Data();
            hm.put(pin2,obj);
            menu(obj);
        }

        
    }

    public void menu(Data obj){
        System.out.println("Please enter valid number");
        System.out.println("1 . Check balance");
        System.out.println("2 . Deposit Money");
        System.out.println("3 . Withdraw Money");
        System.out.println("4 . Check Another Account");
        System.out.println("5 . Exit");

        int x = sc.nextInt();

        if(x == 1){
            check_balance(obj);
            
        }
        else if(x == 2){
            deposit(obj);
        }
        else if(x == 3){
            withdraw(obj);
        }
        else if(x == 4){
            op();
        }
        else if(x == 5){
            System.out.println("Thank You");
        }
        else{
            System.out.println("********************************************************************");
            System.out.println("Please enter valid number");
            menu(obj);
        }

    }
    public void check_balance(Data obj){
        System.out.println("********************************************************************");
        System.out.println("Your balance " + obj.balance);
        System.out.println("********************************************************************");
        menu(obj);
    }
    public void deposit(Data obj){
        System.out.println("Enter your Account");
        float a = sc.nextFloat();

        obj.balance = obj.balance + a;

        System.out.println("Amount deposited successfully");
        menu(obj);

    }

    public void withdraw(Data obj){
        System.out.println("Enter your Amount");
        float a =sc.nextFloat();
        if(obj.balance>=a){
            obj.balance = obj.balance-a;
            System.out.println("Amount withdraw Successful");

        }
        else{
            System.out.println("Insufficient Balance");
        }
        menu(obj);
    }
}