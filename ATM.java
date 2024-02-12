import java.util.*;
import java.lang.*;

/**
 * ATM
 */
public class ATM{

    private int PIN = 1245;
    public String user = "ABC";
    protected double balance = 100000;
    Scanner scanner;
    public boolean Authencation = false;

    public ATM(Scanner scanner,int pinNumber){
        this.scanner = scanner;
        if(pinNumber == PIN){
            Authencation = true;
        }
        else{
            Authencation = false;
        }

    }

    public void takeAmount(){
        System.out.println("Enter the amount to be withdrawn:");
        int amount = scanner.nextInt();
        if(amount<balance){
        balance-=amount;
        System.out.println(amount + " is debited successfully\n");
        }
        else{
            System.out.println("Not enough balance\n");
        }
    }


    public void addAmount(){
        System.out.println("Enter the amount to be added:");
        int amount = scanner.nextInt();
        balance+=amount;
        System.out.println(amount + " is credited successfully.\n");
    }

    public void checkBalance(){
        System.out.println("Hello "+user+",\nYour balance is:"+balance+"\n");
    }
    
    

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert your card");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Enter your 4 digit pin number");
        int pinNumber = scanner.nextInt();

        ATM atm = new ATM(scanner,pinNumber);
        
        int optionChosen = 0;
        if(atm.Authencation) {
            System.out.println("Authencation Successful\n");
            while(optionChosen!=4){
        System.out.println("Press 1 for balance\nPress 2 to add amount\nPress 3 to take amount\nPress 4 to exit");
         optionChosen = scanner.nextInt();
             

        //  calling the right functions
        if(optionChosen==1){
            atm.checkBalance();
        }
        else if(optionChosen==2){
            atm.addAmount();
        }
        else if(optionChosen==3){
            atm.takeAmount();
        }
            }
        }
        else{
            System.out.println("Authencation failed");
        }

    }
}
