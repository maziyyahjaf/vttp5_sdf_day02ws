package object;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Random;

public class BankAccount {

    private final String accountHolderName; // final?
    private final String accountNumber; // final?
    private float accountBalance;
    private boolean isClosed;
    private Date dateAccountCreated;
    private Date dateAccountClosed;

    private List<String> transactions;

    
    public BankAccount(String accountHolderName) {
        this.accountNumber = generateAccountNo();
        this.accountHolderName = accountHolderName;
        this.accountBalance = 0.0f;

        ZoneId defaultZone = ZoneId.systemDefault();
        this.dateAccountCreated = Date.from(LocalDate.now().atStartOfDay(defaultZone).toInstant());

        if (transactions == null) {
            this.transactions = new ArrayList<String>();
        }
        
    }




    public BankAccount(String accountHolderName, float accountBalance) {
        this.accountNumber = generateAccountNo();
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }



    private String generateAccountNo() {
        int startAsciiNo = 65;
        int endAsciiNo = 90;
        int accountNumberLength = 10;

        Random random = new Random();
        String accountNumber = "";

        for (int i = 0; i < accountNumberLength; i++) {
            int randomValue = startAsciiNo + (int) (random.nextFloat() * (endAsciiNo - startAsciiNo + 1));

            accountNumber = accountNumber + (char) randomValue;
        }

        return accountNumber;
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





    public boolean isClosed() {
        return isClosed;
    }





    public void setIsClosed(boolean isClosed) {

        if (isClosed) {
        
            ZoneId defaultZone = ZoneId.systemDefault();
            this.dateAccountClosed = Date.from(LocalDate.now().atStartOfDay(defaultZone).toInstant());
            this.isClosed = isClosed;

        }
        
    }





    public Date getDateAccountCreated() {
        return dateAccountCreated;
    }





    public void setDateAccountCreated(Date dateAccountCreated) {
        this.dateAccountCreated = dateAccountCreated;
    }





    public Date getDateAccountClosed() {
        return dateAccountClosed;
    }





    public void setDateAccountClosed(Date dateAccountClosed) {
        this.dateAccountClosed = dateAccountClosed;
    }





    public void deposit(double depositFunds) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  

        if ((depositFunds > 0) && (!isClosed)) {
            
            accountBalance += (depositFunds);
            String successfulTransaction;

            successfulTransaction = "deposit $" + depositFunds + " at " + (dtf.format(now) + "\r\n Account Balance: $" +accountBalance);
            transactions.add(successfulTransaction);
            System.out.println(successfulTransaction);

        } else {

            System.out.println("IllegalArgumentException");
            System.out.println("Account Closed or Invalid amount");  // exception handling?
            throw new IllegalArgumentException("Account is closed. Transaction aborted.");

        }

    }

    public void withdraw(double withdrawFunds) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 

        if ((withdrawFunds > 0) && (!isClosed)) {
            if (accountBalance > withdrawFunds) {
                accountBalance-=withdrawFunds;
                String successfulTransaction;

                successfulTransaction = "withdraw $" + withdrawFunds + " at " + (dtf.format(now) + "\r\n Account Balance: $" +accountBalance);
                transactions.add(successfulTransaction);
                System.out.println(successfulTransaction);
            }
        } else {
            System.out.println("IllegalArgumentException");
            System.out.println("Account Closed or Invalid amount or Insufficient balance"); 
        }
    }


    @Override
    public String toString() {
        return "BankAccount [accountHolderName=" + accountHolderName + ", accountNumber=" + accountNumber
                + ", accountBalance=" + accountBalance + ", transactions=" + transactions + "]";
    }

    

    
}


