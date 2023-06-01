package Control;

import Entity.Customer;

import java.util.Calendar;

class BankControlTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,2,20);
        Customer customer = new Customer("name","beijing",calendar,2);
        BankControlTest tdd = new BankControlTest();
        tdd.addCustomer(customer);
    }

    @org.junit.jupiter.api.Test
    void addCustomer(Customer customer) {
    }

    @org.junit.jupiter.api.Test
    void ageCount() {
    }

    @org.junit.jupiter.api.Test
    void confirmCreditStatus() {
    }

    @org.junit.jupiter.api.Test
    void createAccount() {
    }

    @org.junit.jupiter.api.Test
    void accNoCreate() {
    }

    @org.junit.jupiter.api.Test
    void getJunior() {
    }

    @org.junit.jupiter.api.Test
    void getSaver() {
    }

    @org.junit.jupiter.api.Test
    void getCurrent() {
    }

    @org.junit.jupiter.api.Test
    void depositFunds_Junior() {
    }

    @org.junit.jupiter.api.Test
    void depositFunds_Saver() {
    }

    @org.junit.jupiter.api.Test
    void depositFunds_Current() {
    }

    @org.junit.jupiter.api.Test
    void clearOrNot() {
    }

    @org.junit.jupiter.api.Test
    void clearFunds() {
    }

    @org.junit.jupiter.api.Test
    void giveNotice() {
    }

    @org.junit.jupiter.api.Test
    void withdraw_Junior() {
    }

    @org.junit.jupiter.api.Test
    void withdraw_Saver() {
    }

    @org.junit.jupiter.api.Test
    void withdraw_Current() {
    }

    @org.junit.jupiter.api.Test
    void suspendedJunior() {
    }

    @org.junit.jupiter.api.Test
    void suspendedSaver() {
    }

    @org.junit.jupiter.api.Test
    void suspendedCurrent() {
    }

    @org.junit.jupiter.api.Test
    void closeJuniorAccount() {
    }

    @org.junit.jupiter.api.Test
    void closeSaverAccount() {
    }

    @org.junit.jupiter.api.Test
    void closeCurrentAccount() {
    }

    @org.junit.jupiter.api.Test
    void existJunior() {
    }

    @org.junit.jupiter.api.Test
    void existSaver() {
    }

    @org.junit.jupiter.api.Test
    void existCurrent() {
    }
}