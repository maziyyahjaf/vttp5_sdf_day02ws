import object.BankAccount;

public class Main {

    public static void main(String[] args) {

        BankAccount newAccount = new BankAccount("Adam");
        newAccount.deposit(100);
        newAccount.deposit(1000);
        newAccount.withdraw(50);


    }
}