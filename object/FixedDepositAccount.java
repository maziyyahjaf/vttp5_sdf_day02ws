package object;

public class FixedDepositAccount extends BankAccount {

    private float interest;
    private Integer duration;

    public FixedDepositAccount (String name, float balance) {
        super(name, balance);
    }

    public FixedDepositAccount (String name, float balance, float interest) {
        super(name, balance);
        this.interest = interest;
    }

    public FixedDepositAccount (String name, float balance, float interest, Integer duration) {
    
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

    
    
}
