package Entity;

import java.util.ArrayList;
import java.util.Calendar;

public class Customer {
    private String name;
    private String address;
    private Calendar dateOfBirth;
    private boolean creditStatus;
    private int age;

    private ArrayList<JuniorAccount>juniorAccounts = new ArrayList<>();
    private ArrayList<SaverAccount>saverAccounts = new ArrayList<>();
    private ArrayList<CurrentAccount>currentAccounts = new ArrayList<>();

    public Customer(String name,String address, Calendar dateOfBirth,int age){
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.juniorAccounts = new ArrayList<>();
        this.saverAccounts = new ArrayList<>();
        this.currentAccounts = new ArrayList<>();
        creditStatus = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(boolean creditStatus) {
        this.creditStatus = creditStatus;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public ArrayList getJuniors(){
        return juniorAccounts;
    }

    public void addJunior(JuniorAccount newJunior){
        juniorAccounts.add(newJunior);
    }

    public void deleteJunior(int index,JuniorAccount newJunior){
        JuniorAccount empty = new JuniorAccount(0,null);
        juniorAccounts.set(index,empty);
    }

    public ArrayList getSavers(){
        return saverAccounts;
    }

    public void addSaver(SaverAccount newSaver){
        saverAccounts.add(newSaver);
    }

    public void deleteSaver(int index,SaverAccount newSaver){
        SaverAccount empty = new SaverAccount(0,null);
        saverAccounts.set(index,empty);
    }

    public ArrayList getCurrents(){
        return currentAccounts;
    }

    public void addCurrent(CurrentAccount newCurrent){
        currentAccounts.add(newCurrent);
    }

    public void deleteCurrent(int index,CurrentAccount newCurrent){
        CurrentAccount empty = new CurrentAccount(0,null);
        currentAccounts.set(index,empty);
    }
}
