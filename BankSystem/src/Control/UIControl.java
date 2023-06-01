package Control;

import Boundary.ChooseType;
import Boundary.Homepage;
import Entity.CurrentAccount;
import Entity.JuniorAccount;
import Entity.SaverAccount;

import java.util.Scanner;

public class UIControl {
    public void test()  {
        BankControl main = new BankControl();

        while(true){
            Homepage page = new Homepage();
            ChooseType page2 = new ChooseType();
            page.homepage();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            while(true){

                if(choice == 1){
                    //open account
                    main.createAccount(main.addCustomer(main.customers));
                    Scanner pause = new Scanner(System.in);
                    break;
                }

                if(choice == 2){
                    //deposit funds
                    page2.chooseType();
                    Scanner scanner = new Scanner(System.in);
                    int type = scanner.nextInt();

                    if(type == 1){
                        JuniorAccount usingAccount = new JuniorAccount(0,null);
                        usingAccount = main.getJunior();
                        main.depositFunds_Junior(usingAccount);
                        break;
                    }

                    if(type == 2){
                        SaverAccount usingAccount = new SaverAccount(0,null);
                        usingAccount = main.getSaver();
                        main.depositFunds_Saver(usingAccount);
                        break;
                    }

                    if(type == 3){
                        CurrentAccount usingAccount = new CurrentAccount(0,null);
                        usingAccount = main.getCurrent();
                        main.depositFunds_Current(usingAccount);
                        break;
                    }
                }

                if(choice == 3){
                    //clear funds
                }

                if(choice == 4){
                    //withdraw funds
                    page2.chooseType();
                    Scanner scanner = new Scanner(System.in);
                    int type = scanner.nextInt();

                    if(type == 1){
                        JuniorAccount usingAccount = new JuniorAccount(0,null);
                        usingAccount = main.getJunior();
                        main.withdraw_Junior(usingAccount);
                        break;
                    }

                    if(type == 2){
                        SaverAccount usingAccount = new SaverAccount(0,null);
                        usingAccount = main.getSaver();
                        main.withdraw_Saver(usingAccount);
                        break;
                    }

                    if(type == 3){
                        CurrentAccount usingAccount = new CurrentAccount(0,null);
                        usingAccount = main.getCurrent();
                        main.withdraw_Current(usingAccount);
                        break;
                    }
                }

                if(choice == 5){
                    //suspend account
                    page2.chooseType();
                    Scanner scanner = new Scanner(System.in);
                    int type = scanner.nextInt();

                    if(type == 1){
                        JuniorAccount usingAccount = new JuniorAccount(0,null);
                        usingAccount = main.getJunior();
                        main.suspendedJunior(usingAccount);
                        System.out.println("your account is suspended successfully");
                        break;
                    }

                    if(type == 2){
                        SaverAccount usingAccount = new SaverAccount(0,null);
                        usingAccount = main.getSaver();
                        main.suspendedSaver(usingAccount);
                        System.out.println("your account is suspended successfully");
                        break;
                    }

                    if(type == 3){
                        CurrentAccount usingAccount = new CurrentAccount(0,null);
                        usingAccount = main.getCurrent();
                        main.suspendedCurrent(usingAccount);
                        System.out.println("your account is suspended successfully");
                        break;
                    }
                }

                if(choice == 6){
                    //close account
                    page2.chooseType();
                    Scanner scanner = new Scanner(System.in);
                    int type = scanner.nextInt();

                    if(type == 1){
                        JuniorAccount usingAccount = new JuniorAccount(0,null);
                        usingAccount = main.getJunior();
                        main.closeJuniorAccount();
                        break;
                    }

                    if(type == 2){
                        SaverAccount usingAccount = new SaverAccount(0,null);
                        usingAccount = main.getSaver();
                        main.closeSaverAccount();
                        break;
                    }

                    if(type == 3){
                        CurrentAccount usingAccount = new CurrentAccount(0,null);
                        usingAccount = main.getCurrent();
                        main.closeCurrentAccount();
                        break;
                    }
                }

                if(choice == 0){
                    System.out.println("Thanks for using!");
                    Scanner s = new Scanner(System.in);
                    String wait  = s.nextLine();
                    System.exit(0);
                }
            }
        }

    }
}
