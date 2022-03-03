package BANKAPP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

enum accountType{
    SAVINGS("Savings Account"),
    CURRENT("Current Account");
    
	public final String amount;
    
	private accountType(String amount){
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }
};

abstract class Bank{
    protected int balance = 0;
    protected String name = "Bank";
    
    abstract void getDetails();
    abstract void printDetails();
    
    public boolean withdraw(int amount) throws Exception {
        return (balance-amount)>0 ? true : false;    
    }
    
    public String getDateandTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    
    public void performTransaction(Scanner read) throws Exception {
    	System.out.println("Enter Account no:");
        long acc_no = read.nextInt();
        
        System.out.println("Account type: \n1.Current \n2.Savings");
        int acc_type = read.nextInt();
        
        String Acc_ty = "";
        if (acc_type == 1) {
            accountType acct = accountType.CURRENT;
            Acc_ty = accountType.CURRENT.getAmount();
        } else if (acc_type == 2) {
            accountType acct = accountType.SAVINGS;
            Acc_ty = accountType.SAVINGS.getAmount();
        }
        
        System.out.println("1.Deposit \t2.Withdraw");
        int choice = read.nextInt();
        
        System.out.println("Enter Amount");
        int amount = read.nextInt();
        
        int currentAmount = 0;
        String status = "";
        String op = "";
        
        if (choice == 1) {
            currentAmount = this.balance + amount;
            status = "Success";
            op = "Deposit";
        } else if (choice == 2) {
        	op="Withdraw";
            if (this.withdraw(amount)) {
                currentAmount = this.balance - amount;
                status = "Success";
            } else {
                status = "InsufficientBalance";
            }
        }
        
        System.out.println("Status : "+status+"\tCurrent amount : "+currentAmount);
          
        BufferedWriter br = new BufferedWriter(new FileWriter("logs.txt",true));
        br.append("Date and Time:" + this.getDateandTime() + "\n");
        br.append("Account Number:" + Long.toString(acc_no) + "\n");
        br.append("Account Type:" + Acc_ty + "\n");
        br.append("Operation performed:"+op+"\n");
        br.append("Amount to be processed:" + Integer.toString(amount) + "\n");
        br.append("Amount before Transaction:" +Integer.toString(balance) + "\n");
        br.append("Amount after Transaction:" + Integer.toString(currentAmount) + "\n");
        br.append("Transaction Status:" + status + "\n");
        if(status.equals("InsufficientBalance")){
            br.append("Amount is not sufficient for this transaction\n");
            br.close();
            throw new Exception("InsufficientBalanceException");
        }
        br.close();
    }
}

class SBI extends Bank{
    public void printDetails(){
        System.out.println("State Bank Of India \nROI : 3.5%");
    }
    public void getDetails(){
        System.out.println("Current balance in you SBI account is :"+this.balance);
    }
    public SBI(){
    	this.name="SBI";
        this.balance = 15000;
    }
}

class BOI extends Bank{
    public void printDetails(){
        System.out.println("Bank of India \nROI : 3.75%");
    }
    public void getDetails(){
        System.out.println("Current balance in you BOI account is :"+this.balance);
    }
    public BOI(){
    	this.name="BOI";
        this.balance = 12000;
    }
}

class ICICI extends Bank{
    public void printDetails(){
        System.out.println("ICICI Bank Limited \nROI : 3.90%");
    }
    public void getDetails(){
        System.out.println("Current balance in you ICICI account is :"+this.balance);
    }
    public ICICI(){
    	this.name="ICICI";
        this.balance = 18000;
    }
}

public class BankApplication {
    
	public static void main(String[] args) throws Exception {
        
		SBI sbi = new SBI();
        BOI boi = new BOI();
        ICICI icici = new ICICI();
        Scanner read = new Scanner(System.in);
        
        System.out.println("Select your Bank: \n1.SBI \n2.BOI \n3.ICICI");
        int choiceBank = read.nextInt();
        
        System.out.println("Enter the operation to be performed: \n1.Get Bank Details \n2. Get Balance \n3.Transaction");
        int choiceOperation = read.nextInt();
        
        switch (choiceOperation){
            case 1: 
            	switch (choiceBank){
                	case 1: sbi.printDetails();
                	break;
                	case 2: boi.printDetails();
                	break;
                	case 3: icici.printDetails();
                	break;
                	default: 
                		System.out.println("Invalid Bank Choice !");
                		System.exit(0);
            }
            break;
            
            case 2: 
            	switch (choiceBank){
                	case 1: sbi.getDetails();
                	break;
                	case 2: boi.getDetails();
                	break;
                	case 3: icici.getDetails();
                	break;
                	default:
                		System.out.println("Invalid Bank Choice !");
                		System.exit(0);
            }
            break;
            
            case 3:
                if(choiceBank == 1){
                	sbi.performTransaction(read);
                    break;
                }
                else if(choiceBank == 2){
                	boi.performTransaction(read);
                	break;
                }
                else if(choiceBank == 3){
                    icici.performTransaction(read);
                    break;
                }
            break;
            
            default:
            	System.out.println("Invalid Operation Choice !");
        }

    }
}
