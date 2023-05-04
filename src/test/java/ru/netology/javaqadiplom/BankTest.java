package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void transferToSavingAccount() {
        CreditAccount acCredit = new CreditAccount(
                2000,
                5_000,
                15
        );
        SavingAccount acSaving = new SavingAccount(
                3_000,
                500,
                11_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(acCredit, acSaving, 1_000);

        Assertions.assertEquals(1_000, acCredit.getBalance());
        Assertions.assertEquals(4_000, acSaving.getBalance());
    }

    @Test
    public void transferToSavingAccountMaxCreditLimit() {
        CreditAccount acCredit = new CreditAccount(
                2000,
                5_000,
                15
        );
        SavingAccount acSaving = new SavingAccount(
                3_000,
                500,
                11_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(acCredit, acSaving, 7_000);

        Assertions.assertEquals(-5_000, acCredit.getBalance());
        Assertions.assertEquals(10_000, acSaving.getBalance());
    }

    @Test
    public void transferToSavingAccountOverCreditLimit() {
        CreditAccount acCredit = new CreditAccount(
                2000,
                5_000,
                15
        );
        SavingAccount acSaving = new SavingAccount(
                3_000,
                500,
                11_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(acCredit, acSaving, 8_000);

        Assertions.assertEquals(2_000, acCredit.getBalance());
        Assertions.assertEquals(3_000, acSaving.getBalance());
    }

    @Test
    public void transferToSavingAccountNegativeAmount() {
        CreditAccount acCredit = new CreditAccount(
                2000,
                5_000,
                15
        );
        SavingAccount acSaving = new SavingAccount(
                3_000,
                500,
                11_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(acCredit, acSaving, -2_000);

        Assertions.assertEquals(2_000, acCredit.getBalance());
        Assertions.assertEquals(3_000, acSaving.getBalance());
    }

    @Test
    public void transferToSavingAccountOverMax() {
        CreditAccount acCredit = new CreditAccount(
                2_000,
                10_000,
                15
        );
        SavingAccount acSaving = new SavingAccount(
                10_000,
                500,
                11_000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(acCredit, acSaving, 2_000);

        Assertions.assertEquals(2_000, acCredit.getBalance());
        Assertions.assertEquals(10_000, acSaving.getBalance());
    }

    @Test
    public void transferToCreditAccount() {
        SavingAccount acSaving = new SavingAccount(
                3_000,
                500,
                11_000,
                10
        );
        CreditAccount acCredit = new CreditAccount(
                2_000,
                5_000,
                15
        );
        Bank bank = new Bank();
        bank.transfer(acSaving, acCredit, 1_000);

        Assertions.assertEquals(3_000, acCredit.getBalance());
        Assertions.assertEquals(2_000, acSaving.getBalance());
    }

    @Test
    public void transferToCreditAccountMinBalance() {
        SavingAccount acSaving = new SavingAccount(
                3_000,
                500,
                11_000,
                10
        );
        CreditAccount acCredit = new CreditAccount(
                2000,
                5_000,
                15
        );
        Bank bank = new Bank();
        bank.transfer(acSaving, acCredit, 2_500);

        Assertions.assertEquals(4_500, acCredit.getBalance());
        Assertions.assertEquals(500, acSaving.getBalance());
    }

    @Test
    public void transferToCreditAccountOverMinBalance() {
        SavingAccount acSaving = new SavingAccount(
                3_000,
                500,
                11_000,
                10
        );
        CreditAccount acCredit = new CreditAccount(
                2000,
                5_000,
                15
        );
        Bank bank = new Bank();
        bank.transfer(acSaving, acCredit, 3_300);

        Assertions.assertEquals(2_000, acCredit.getBalance());
        Assertions.assertEquals(3_000, acSaving.getBalance());
    }

    @Test
    public void transferToCreditAccountNegativeAmount() {
        SavingAccount acSaving = new SavingAccount(
                3_000,
                500,
                11_000,
                10
        );
        CreditAccount acCredit = new CreditAccount(
                2000,
                5_000,
                15
        );
        Bank bank = new Bank();
        bank.transfer(acSaving, acCredit, -1_000);

        Assertions.assertEquals(2_000, acCredit.getBalance());
        Assertions.assertEquals(3_000, acSaving.getBalance());
    }
}