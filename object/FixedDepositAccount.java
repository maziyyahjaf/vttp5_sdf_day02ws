package object;

public class FixedDepositAccount extends BankAccount {

    private float interest;
    private Integer duration;

    public FixedDepositAccount (String name, float balance) {
        super(name);
        
        this.interest =3.0f;
        this.duration = 6;
    }

    public FixedDepositAccount (String name, float balance, float interest) {
        this(name, balance);
        this.interest = interest;
    }

    public FixedDepositAccount (String name, float balance, float interest, Integer duration) {
        this(name, balance, interest);
        this.duration = duration;
    
    }








    public float getInterest() {
        return interest;
    }
    public void setInterest(float interest) {
        this.interest = interest;
    }
    public Integer getDurationInMonths() {
        return duration;
    }
    public void setDurationInMonths(Integer duration) {
        this.duration = duration;
    }

    

    
    @Override
    public void deposit(double depositFunds) {
        System.out.println("Operation not allowed");
        //super.deposit(depositFunds);
    }

    @Override
    public void withdraw(double withdrawFunds) {
        System.out.println("Operation not allowed");
        //super.deposit(depositFunds);
    }

    @Override
    public float getAccountBalance() {

        // balance plus the interest viz if interest is 3 and balance is 100, the getBalance()
        // should return 103
        float total = this.getAccountBalance() * ((this.interest / 100.0f) * this.duration);
        return total;
    }

    public void showAccountInfo() {
        System.out.println("Account Type: Fixed Deposit");
    }

    

   
    
    
}
