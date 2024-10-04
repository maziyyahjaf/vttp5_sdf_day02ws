package object;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountHolderName; // final?
    private String accountNumber; // final?
    private float accountBalance;
    private List<String> transactions;
    private boolean accountStatus;
    private String dateAccountCreated;
    private String dateAccountClosed;

    



    public BankAccount() {
        System.out.println("Empty constructor called");
    }

    
    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        accountBalance = 0;
        this.transactions = new ArrayList<String>();
    }

    


    public BankAccount(String accountHolderName, String accountNumber, float accountBalance, List<String> transactions,
            boolean accountStatus, String dateAccountCreated, String dateAccountClosed) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.transactions = transactions;
        this.accountStatus = accountStatus;
        this.dateAccountCreated = dateAccountCreated;
        this.dateAccountClosed = dateAccountClosed;
    }


    public BankAccount(String accountHolderName, float accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }



    public String getAccountHolderName() {
        return accountHolderName;
    }





    public String getAccountNumber() {
        return accountNumber;
    }





    public float getAccountBalance() {
        return accountBalance;
    }





    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }





    public List<String> getTransactions() {
        return transactions;
    }





    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }





    public boolean isAccountStatus() {
        return accountStatus;
    }





    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }





    public String getDateAccountCreated() {
        return dateAccountCreated;
    }





    public void setDateAccountCreated(String dateAccountCreated) {
        this.dateAccountCreated = dateAccountCreated;
    }





    public String getDateAccountClosed() {
        return dateAccountClosed;
    }





    public void setDateAccountClosed(String dateAccountClosed) {
        this.dateAccountClosed = dateAccountClosed;
    }





    public void deposit(double depositFunds) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  

        if ((depositFunds > 0) && (accountStatus = true)) {
            accountBalance += (depositFunds);
            String successfulTransaction;

            successfulTransaction = "deposit $" + depositFunds + "at" + (dtf.format(now));
            transactions.add(successfulTransaction);
            System.out.println(successfulTransaction);

        } else {

            System.out.println("IllegalArgumentException");
            System.out.println("Account Closed or Invalid amount");  // exception handling?

        }

    }

    public void withdraw(double withdrawFunds) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 

        if ((withdrawFunds > 0) && (accountStatus = true)) {
            if (accountBalance > withdrawFunds) {
                accountBalance-=withdrawFunds;
                String successfulTransaction;

                successfulTransaction = "deposit $" + withdrawFunds + " at " + (dtf.format(now));
                transactions.add(successfulTransaction);
                System.out.println(successfulTransaction);
            }
        } else {
            System.out.println("IllegalArgumentException");
            System.out.println("Account Closed or Invalid amount or Insufficient balance"); 
        }
    }

    
}


