package Entity;

public class CurrentAccount extends Account{
    public CurrentAccount(int accNo,Customer customer){
        super(accNo, customer);
        this.overDraftLimit = 1000;
    }
}
