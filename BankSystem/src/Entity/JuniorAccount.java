package Entity;

public class JuniorAccount extends Account{
    double withdrawLimit = 100;
    public JuniorAccount(int accNo, Customer customer) {
        super(accNo, customer);
        this.overDraftLimit = 0.0;
    }

    public double getWithdrawLimit(){
        return withdrawLimit;
    }
}
