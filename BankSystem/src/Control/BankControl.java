package Control;

import Entity.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BankControl {
    public ArrayList<Customer>customers = new ArrayList<>();
    public Customer addCustomer (ArrayList customers){
        //name
        System.out.println("please enter your name:");
        Scanner sc1 = new Scanner(System.in);
        String newName = sc1.nextLine();

        //address
        System.out.println("please enter your address:");
        Scanner sc2 = new Scanner(System.in);
        String newAddress = sc2.nextLine();

        //date of birth
        System.out.println("please enter your date of birth:");
        System.out.println("Year:");
        Scanner sc3 = new Scanner(System.in);
        int year = sc3.nextInt();
        System.out.println("Month");
        Scanner sc4 = new Scanner(System.in);
        int month = sc4.nextInt() - 1;
        System.out.println("Date");
        Scanner sc5 = new Scanner(System.in);
        int date = sc5.nextInt();
        Calendar newDob = Calendar.getInstance();
        newDob.set(year,month,date);
        //valid date < today

        int age = ageCount(newDob);
        Customer newCustomer = new Customer(newName,newAddress,newDob,age);
        customers.add(newCustomer);
        return newCustomer;
    }

    public int ageCount(Calendar newDob){
        //System time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        //count age
        int yearMinus = calendar.get(Calendar.YEAR) - newDob.get(Calendar.YEAR);
        int monthMinus = calendar.get(Calendar.MONTH) - newDob.get(Calendar.MONTH);
        int dateMinus = calendar.get(Calendar.DATE) - newDob.get(Calendar.DATE);

        int age = yearMinus;

        if(dateMinus < 0){
            monthMinus--;
        }
        if(monthMinus < 0){
            age--;
        }
        System.out.println("your age is: " + age);
        return age;
    }

    public void confirmCreditStatus(Customer newCustomer){
        //how to confirm
        if(newCustomer.isCreditStatus()){
            System.out.println("you can create account");
        }

        if(!newCustomer.isCreditStatus()){
            System.out.println("you can't create account!");
            System.exit(0);
        }

    }

    public Account createAccount(Customer newCustomer){
        while(true){
            System.out.println("please choose the type of account you wanna create");
            System.out.println("1.Junior Account");
            System.out.println("2.Saver Account");
            System.out.println("3.Current Account");
            System.out.println("0.Exist");
            Scanner sc6 = new Scanner(System.in);
            int type = sc6.nextInt();

            if(type == 1){
                //Junior Account
                if(newCustomer.getAge() <= 16){
                    System.out.println("you can create Junior Account");
                    int newAccNo = accNoCreate();
                    //judge accNo exist or Not
                    while(true){
                        if(existJunior(newAccNo)){
                            break;
                        }
                        if(!existJunior(newAccNo)){
                            JuniorAccount newJunior = new JuniorAccount(newAccNo,newCustomer);
                            //add into arraylist
                            newCustomer.addJunior(newJunior);
                            System.out.println("Junior Account creation succeeded!");
                            //pin
                            int  newPin = newJunior.getPin();
                            System.out.println("your pin is: " + newPin);
                            System.out.println("please remember your pin!");
                            return newJunior;
                        }
                    }
//                    JuniorAccount newJunior = new JuniorAccount(newAccNo,newCustomer);
//                    //add into arraylist
//                    newCustomer.addJunior(newJunior);
//                    System.out.println("Junior Account creation succeeded!");
//                    //pin
//                    int  newPin = newJunior.getPin();
//                    System.out.println("your pin is: " + newPin);
//                    System.out.println("please remember your pin!");
//                    return newJunior;
                }
                if(newCustomer.getAge() > 16){
                    System.out.println("you can't create Junior Account because your age is over 16!");
                }
            }

            if(type == 2){
                //Saver Account
                int newAccNo = accNoCreate();
                //judge accNo exist or Not
                while(true){
                    if(existSaver(newAccNo)){
                        break;
                    }
                    if(!existSaver(newAccNo)){
                        SaverAccount newSaver = new SaverAccount(newAccNo,newCustomer);
                        //add into arraylist
                        newCustomer.addSaver(newSaver);
                        System.out.println("Saver Account creation succeeded!");
                        //pin
                        int  newPin = newSaver.getPin();
                        System.out.println("your pin is: " + newPin);
                        System.out.println("please remember your pin!");
                        return newSaver;
                    }
                }
//                SaverAccount newSaver = new SaverAccount(newAccNo,newCustomer);
//                //add into arraylist
//                newCustomer.addSaver(newSaver);
//                System.out.println("Saver Account creation succeeded!");
//                //pin
//                int  newPin = newSaver.getPin();
//                System.out.println("your pin is: " + newPin);
//                System.out.println("please remember your pin!");
//                return newSaver;
            }

            if(type == 3){
                //Current Account
                int newAccNo = accNoCreate();
                //judge accNo exist or Not
                while(true){
                    if(existCurrent(newAccNo)){
                        break;
                    }
                    if(!existCurrent(newAccNo)){
                        CurrentAccount newCurrent = new CurrentAccount(newAccNo,newCustomer);
                        //add into arraylist
                        newCustomer.addCurrent(newCurrent);
                        System.out.println("Current Account creation succeeded!");
                        //pin
                        int  newPin = newCurrent.getPin();
                        System.out.println("your pin is: " + newPin);
                        System.out.println("please remember your pin!");
                        return newCurrent;
                    }
                }
//                CurrentAccount newCurrent = new CurrentAccount(newAccNo,newCustomer);
//                //add into arraylist
//                newCustomer.addCurrent(newCurrent);
//                System.out.println("Current Account creation succeeded!");
//                //pin
//                int  newPin = newCurrent.getPin();
//                System.out.println("your pin is: " + newPin);
//                System.out.println("please remember your pin!");
//                return newCurrent;
            }

            if(type == 0){
                break;
            }
            else{
                System.out.println("error!");
            }
        }
        return null;
    }

    //accNo
    public int accNoCreate(){
        //accNo
        System.out.println("please create a new Account Number");
        Scanner sc7 = new Scanner(System.in);
        return sc7.nextInt();
    }

    //根据accNo 返回特定的账户
    public JuniorAccount getJunior(){
        System.out.println("enter your accNo");
        Scanner scanner = new Scanner(System.in);
        int accNo = scanner.nextInt();
        for(int i = 0; i <= customers.size();i++){
            Customer tempcustomer = new Customer(null,null,null,-1);
            tempcustomer = customers.get(i);
            ArrayList<JuniorAccount>tempJuniors;
            tempJuniors = tempcustomer.getJuniors();
            for(int k = 0;k <= tempJuniors.size();k++){
                JuniorAccount tempJunior = new JuniorAccount(0,null);
                tempJunior = tempJuniors.get(i);
                if(tempJunior.getAccNo() == accNo){
                    System.out.println("account exist!");
                    return tempJunior;
                }
            }
        }
        return null;
    }

    public SaverAccount getSaver(){
        System.out.println("enter your accNo");
        Scanner scanner = new Scanner(System.in);
        int accNo = scanner.nextInt();
        for(int i = 0; i <= customers.size();i++){
            Customer tempcustomer = new Customer(null,null,null,-1);
            tempcustomer = customers.get(i);
            ArrayList<SaverAccount>tempSavers;
            tempSavers = tempcustomer.getSavers();
            for(int k = 0;k <= tempSavers.size();k++){
                SaverAccount tempSaver = new SaverAccount(0,null);
                tempSaver = tempSavers.get(i);
                if(tempSaver.getAccNo() == accNo){
                    System.out.println("account exist!");
                    return tempSaver;
                }
            }
        }
        return null;
    }

    public CurrentAccount getCurrent(){
        System.out.println("enter your accNo");
        Scanner scanner = new Scanner(System.in);
        int accNo = scanner.nextInt();
        for(int i = 0; i <= customers.size();i++){
            Customer tempcustomer = new Customer(null,null,null,-1);
            tempcustomer = customers.get(i);
            ArrayList<CurrentAccount>tempCurrents;
            tempCurrents = tempcustomer.getCurrents();
            for(int k = 0;k <= tempCurrents.size();k++){
                CurrentAccount tempCurrent = new CurrentAccount(0,null);
                tempCurrent = tempCurrents.get(i);
                if(tempCurrent.getAccNo() == accNo){
                    System.out.println("account exist!");
                    return tempCurrent;
                }
            }
        }
        return null;
    }
    //deposit funds
    public void depositFunds_Junior(JuniorAccount newJunior){
        if(newJunior.isSuspended()){
            System.out.println("your account is suspended");
        }
        if(!newJunior.isSuspended()){
            boolean cleared;
            System.out.println("please enter how much you want to deposit: ");
            Scanner sc8 = new Scanner(System.in);
            double amount = sc8.nextDouble();
            System.out.println("please enter when will the funds be transferred: ");
            System.out.println("Year");
            Scanner sc9 = new Scanner(System.in);
            int year = sc9.nextInt();
            System.out.println("Month");
            Scanner sc10 = new Scanner(System.in);
            int month = sc10.nextInt() - 1;
            System.out.println("Date");
            Scanner sc11 = new Scanner(System.in);
            int day = sc11.nextInt();
            Calendar date = Calendar.getInstance();
            date.set(year,month,day);
            //cleared or not
            cleared = clearOrNot(date);
            System.out.println(cleared);
            Transaction newTrans = new Transaction(amount,date,cleared);

            while(true){
                if(newTrans.getCleared()){
                    //Immediate deposit
                    double juniorBalance = newJunior.getBalance() + amount;
                    newJunior.setBalance(juniorBalance);
                    System.out.println("your balance is: " + newJunior.getBalance());
                    break;
                }
                if(!newTrans.getCleared()){
                    System.out.println("your balance is: " + newJunior.getBalance());
                    break;
                }
            }
        }


        //judge date


        //immediate deposit
//        double juniorBalance = newJunior.getBalance() + amount;
//        newJunior.setBalance(juniorBalance);
//        System.out.println("your balance is: " + newJunior.getBalance());
    }

    public void depositFunds_Saver(SaverAccount newSaver){
        if(newSaver.isSuspended()){
            System.out.println("your account is suspended");
        }

        if(!newSaver.isSuspended()){
            boolean cleared;
            System.out.println("please enter how much you want to deposit: ");
            Scanner sc8 = new Scanner(System.in);
            double amount = sc8.nextDouble();
            System.out.println("please enter when will the funds be transferred: ");
            System.out.println("Year");
            Scanner sc9 = new Scanner(System.in);
            int year = sc9.nextInt();
            System.out.println("Month");
            Scanner sc10 = new Scanner(System.in);
            int month = sc10.nextInt() - 1;
            System.out.println("Date");
            Scanner sc11 = new Scanner(System.in);
            int day = sc11.nextInt();
            Calendar date = Calendar.getInstance();
            date.set(year,month,day);
            System.out.println(date.getTime());
            //cleared or not
            cleared = clearOrNot(date);
            System.out.println(cleared);
            Transaction newTrans = new Transaction(amount,date,cleared);

            //judge date
            while(true){
                if(newTrans.getCleared()){
                    //Immediate deposit
                    double saverBalance = newSaver.getBalance() + amount;
                    newSaver.setBalance(saverBalance);
                    System.out.println("your balance is: " +newSaver.getBalance());
                    break;
                }
                if(!newTrans.getCleared()){
                    System.out.println("your balance is: " +newSaver.getBalance());
                    break;
                }
            }
        }


        //immediate deposit
//        double saverBalance = newSaver.getBalance() + amount;
//        newSaver.setBalance(saverBalance);
//        System.out.println("your balance is: " +newSaver.getBalance());
    }

    public void depositFunds_Current(CurrentAccount newCurrent){
        if(newCurrent.isSuspended()){
            System.out.println("your account is suspended");
        }

        if(!newCurrent.isSuspended()){
            boolean cleared;
            System.out.println("please enter how much you want to deposit: ");
            Scanner sc8 = new Scanner(System.in);
            double amount = sc8.nextDouble();
            System.out.println("please enter when will the funds be transferred: ");
            System.out.println("Year");
            Scanner sc9 = new Scanner(System.in);
            int year = sc9.nextInt();
            System.out.println("Month");
            Scanner sc10 = new Scanner(System.in);
            int month = sc10.nextInt() - 1;
            System.out.println("Date");
            Scanner sc11 = new Scanner(System.in);
            int day = sc11.nextInt();
            Calendar date = Calendar.getInstance();
            date.set(year,month,day);
            //cleared or not
            cleared = clearOrNot(date);
            Transaction newTrans = new Transaction(amount,date,cleared);

            //存款时间校验
            while(true){
                if(newTrans.getCleared()){
                    //Immediate deposit
                    double currentBalance = newCurrent.getBalance() + amount;
                    newCurrent.setBalance(currentBalance);
                    System.out.println("your balance is: " + newCurrent.getBalance());
                    break;
                }
                if(!newTrans.getCleared()){
                    System.out.println("your balance is: " + newCurrent.getBalance());
                    break;
                }
            }
        }


//        //immediate deposit
//        double currentBalance = newCurrent.getBalance() + amount;
//        newCurrent.setBalance(currentBalance);
//        System.out.println("your balance is: " + newCurrent.getBalance());
    }

    public boolean clearOrNot(Calendar date){
        //System Date
        Calendar system = Calendar.getInstance();
        system.setTime(new Date());
        if(system.after(date)){
            return true;
        }
        return false;
    }

    public void clearFunds(){
        //
    }

    public void giveNotice(SaverAccount newSaver){
        System.out.println("please enter the date you want to deposit money");
        System.out.println("Year");
        Scanner sc12 = new Scanner(System.in);
        int year = sc12.nextInt();
        System.out.println("Month");
        Scanner sc13 = new Scanner(System.in);
        int month = sc13.nextInt() - 1;
        System.out.println("Date");
        Scanner sc14 = new Scanner(System.in);
        int day = sc14.nextInt();
        Date NoticDate = new Date(year,month,day);
        newSaver.setNoticeDate(NoticDate);
        System.out.println("please enter how much you will deposit");
        Scanner sc15 = new Scanner(System.in);
        newSaver.setNoticeAmount(sc15.nextDouble());
        System.out.println("Notice succeed!");
    }

    public void withdraw_Junior(JuniorAccount newJunior){
        if(newJunior.isSuspended()){
            System.out.println("your account is suspended");
        }

        if(!newJunior.isSuspended()){
            System.out.println("please enter how much you want to withdraw");
            Scanner sc16 = new Scanner(System.in);
            double amount = sc16.nextDouble();
            while (true){
                if(amount > newJunior.getBalance()){
                    System.out.println("you don't have enough balance! ");
                    break;
                }
                if(amount <= newJunior.getBalance()){
                    //withdraw limit is 100
                    while(true){
                        if(amount > 100){
                            System.out.println("Sorry your withdraw limit is 100 ");
                            break;
                        }
                        if(amount <=100){
                            double juniorBalance = newJunior.getBalance() - amount;
                            newJunior.setBalance(juniorBalance);
                            System.out.println("withdraw succeed!");
                            System.out.println("your balance is: " + newJunior.getBalance());
                            break;
                        }
                    }
                }
            }
        }
    }

    public void withdraw_Saver(SaverAccount newSaver){
        if(newSaver.isSuspended()){
            System.out.println("your account is suspended");
        }

        if(!newSaver.isSuspended()){
            System.out.println("please enter when do you notice to withdraw");
            System.out.println("Year:");
            Scanner sc3 = new Scanner(System.in);
            int noticeYear = sc3.nextInt();
            System.out.println("Month");
            Scanner sc4 = new Scanner(System.in);
            int noticeMonth = sc4.nextInt() - 1;
            System.out.println("Date");
            Scanner sc5 = new Scanner(System.in);
            int noticeDate = sc5.nextInt();
            Calendar notice = Calendar.getInstance();
            notice.set(noticeYear,noticeMonth,noticeDate);
            boolean noticed = clearOrNot(notice);

            while(true){
                if(noticed){
                    System.out.println("please enter how much you want to withdraw");
                    Scanner sc16 = new Scanner(System.in);
                    double amount = sc16.nextDouble();
                    if(amount > newSaver.getBalance()){
                        System.out.println("you don't have enough balance! ");
                        break;
                    }
                    if(amount <= newSaver.getBalance()){
                        double SaverBalance = newSaver.getBalance() - amount;
                        newSaver.setBalance(SaverBalance);
                        System.out.println("withdraw succeed!");
                        System.out.println("your balance is: " + newSaver.getBalance());
                        break;
                    }
                }

                if(!noticed){
                    System.out.println("you haven't noticed,please noticed before withdraw");
                    break;
                }
            }
        }
    }

    public void withdraw_Current(CurrentAccount newCurrent){
        if(newCurrent.isSuspended()){
            System.out.println("your account is suspended");
        }

        if(!newCurrent.isSuspended()){
            System.out.println("please enter how much you want to withdraw");
            Scanner sc16 = new Scanner(System.in);
            double amount = sc16.nextDouble();
            while (true){
                if(amount > newCurrent.getBalance() + 1000){
                    System.out.println("your overDraftLimit is 1000 ");
                    break;
                }
                if(amount <= newCurrent.getBalance() + 1000){
                    double juniorBalance = newCurrent.getBalance() - amount;
                    newCurrent.setBalance(juniorBalance);
                    System.out.println("withdraw succeed!");
                    System.out.println("your balance is: " + newCurrent.getBalance());
                    break;
                }
            }
        }
    }

    public void suspendedJunior(JuniorAccount newJunior){
        newJunior.setIsSuspended(true);
    }

    public void suspendedSaver(SaverAccount newSaver){
        newSaver.setIsSuspended(true);
    }

    public void suspendedCurrent(CurrentAccount newCurrent){
        newCurrent.setIsSuspended(true);
    }

    public void closeJuniorAccount(){
        System.out.println("enter your accNo");
        Scanner scanner = new Scanner(System.in);
        int accNo = scanner.nextInt();
        for(int i = 0; i < customers.size();i++){
            Customer tempcustomer = new Customer(null,null,null,-1);
            tempcustomer = customers.get(i);
            ArrayList<JuniorAccount>tempJuniors;
            tempJuniors = tempcustomer.getJuniors();
            for(int k = 0;k < tempJuniors.size();k++){
                JuniorAccount tempJunior = new JuniorAccount(0,null);
                tempJunior = tempJuniors.get(k);
                if(tempJunior.getAccNo() == accNo){
                    System.out.println("close successfully");
                    tempcustomer.deleteJunior(k,null);
                    break;
                }
            }
        }
    }

    public void closeSaverAccount(){
        
        System.out.println("enter your accNo");
        Scanner scanner = new Scanner(System.in);
        int accNo = scanner.nextInt();
        for(int i = 0; i <= customers.size();i++){
            Customer tempcustomer = new Customer(null,null,null,-1);
            tempcustomer = customers.get(i);
            ArrayList<SaverAccount>tempSavers;
            tempSavers = tempcustomer.getSavers();
            for(int k = 0;k <= tempSavers.size();k++){
                SaverAccount tempSaver = new SaverAccount(0,null);
                tempSaver = tempSavers.get(k);
                if(tempSaver.getAccNo() == accNo){
                    System.out.println("close successfully");
                    tempcustomer.deleteSaver(k,null);
                    break;
                }
            }
        }
    }

    public void closeCurrentAccount(){
        System.out.println("enter your accNo");
        Scanner scanner = new Scanner(System.in);
        int accNo = scanner.nextInt();
        for(int i = 0; i <= customers.size();i++){
            Customer tempcustomer = new Customer(null,null,null,-1);
            tempcustomer = customers.get(i);
            ArrayList<CurrentAccount>tempCurrents;
            tempCurrents = tempcustomer.getCurrents();
            for(int k = 0;k <= tempCurrents.size();k++){
                CurrentAccount tempCurrent = new CurrentAccount(0,null);
                tempCurrent = tempCurrents.get(k);
                if(tempCurrent.getAccNo() == accNo){
                    if(tempCurrent.getBalance()<0){
                        System.out.println("you can't close because your balance is under 0");
                        break;
                    }
                    if(tempCurrent.getBalance()>=0){
                        System.out.println("close successfully");
                        tempcustomer.deleteCurrent(k,null);
                        break;
                    }
                }
            }
        }
    }

    //Account exist or Not
    public boolean existJunior(int accNo){
        for(int i = 0; i < customers.size();i++){
            Customer tempcustomer = new Customer(null,null,null,-1);
            tempcustomer = customers.get(i);
            ArrayList<JuniorAccount>tempJuniors = new ArrayList<>(20);
            tempJuniors = tempcustomer.getJuniors();
            for(int k = 0;k < tempJuniors.size();k++){
                JuniorAccount tempJunior = new JuniorAccount(0,null);
                tempJunior = tempJuniors.get(k);
                if(tempJunior.getAccNo() == accNo){
                    System.out.println("account exist!");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existSaver(int accNo){
        for(int i = 0; i < customers.size();i++){
            Customer tempcustomer = new Customer(null,null,null,-1);
            tempcustomer = customers.get(i);
            ArrayList<SaverAccount>tempSavers;
            tempSavers = tempcustomer.getSavers();
            for(int k = 0;k < tempSavers.size();k++){
                SaverAccount tempSaver = new SaverAccount(0,null);
                tempSaver = tempSavers.get(k);
                if(tempSaver.getAccNo() == accNo){
                    System.out.println("account exist!");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existCurrent(int accNo){
        for(int i = 0; i < customers.size();i++){
            Customer tempcustomer = new Customer(null,null,null,-1);
            tempcustomer = customers.get(i);
            ArrayList<CurrentAccount>tempCurrents;
            tempCurrents = tempcustomer.getCurrents();
            for(int k = 0;k < tempCurrents.size();k++){
                CurrentAccount tempCurrent = new CurrentAccount(0,null);
                tempCurrent = tempCurrents.get(k);
                if(tempCurrent.getAccNo() == accNo){
                    System.out.println("account exist!");
                    return true;
                }
            }
        }
        return false;
    }
    //clear Funds
//    public void
}
