import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Bank {

    protected String accountNumber;

    protected String name;

    protected String bankName;

    protected AccountType accountType;

    protected LocalDateTime accountOpeningDate;

    protected double balance;

    public Bank(){

    }

    public Bank(String accountNumber, String name,String bankName, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.bankName=bankName;
        this.accountType = accountType;
        this.balance=0;
        this.accountOpeningDate = LocalDateTime.now();
    }

    public String getDetails() {
        return "Bank{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountType=" + accountType +
                ", accountOpeningDate=" + accountOpeningDate +
                ", balance=" + balance +
                '}';
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount>0){
            balance = balance+amount;
            logTransaction(Status.DEPOSIT,amount);
            System.out.println("Successfull....!!! your total balance amount is : "+balance);
        }else
            System.out.println("Please enter valid amount");
    }

    public void withdraw(double amount){
        if(amount > balance)
            System.out.println("");
        else {
            balance = balance-amount;
            logTransaction(Status.WITHDRAW,amount);
            System.out.println("Amount "+amount+" deducted. Your total balance is : "+balance);
        }
    }

    public void logTransaction(Status status,
                               double variableAmount){

        String data = getTransactionDetails(status, variableAmount);

        try {
            FileWriter myWriter = new FileWriter("src/logFiles/"+bankName+"_logs",true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getTransactionDetails(Status status,double variableAmount){
        return "Transaction as on date : "+LocalDateTime.now()+
                " { AccountNumber : "+accountNumber+
                ", Name : "+name+
                ", accountType : "+accountType+
                ", statusType : "+status+
                ", variableAmount : "+variableAmount+
                ", currentBalance : "+balance + "}";

    }
}
