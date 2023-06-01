package Entity;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
    protected double amount;
    protected Calendar date;
    protected Calendar time;
    protected boolean cleared;

    public Transaction(double amount,Calendar date,boolean cleared){
        this.amount = amount;
        this.date = date;
        this.cleared = cleared;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(){
        this.amount = amount;
    }

    public Calendar getDate(){
        return date;
    }

    public Calendar getTime(){
        return time;
    }

    public boolean getCleared(){
        return cleared;
    }
}
