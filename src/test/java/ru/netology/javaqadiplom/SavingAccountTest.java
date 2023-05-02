package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());

    }

    @Test
    public void shouldAddZeroThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-3_000);

        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void shouldAddNegativeThanMaxBalance1() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void initialBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.getBalance());
    }


    @Test
    public void minBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.getMinBalance());
    }

    @Test
    public void maxBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                0,
                5
        );

        Assertions.assertEquals(0, account.getMaxBalance());
    }

    @Test
    public void rateEqualZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );

        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void initialBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -2_000,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void minBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    -1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void maxBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    -10_000,
                    5
            );
        });
    }

    @Test
    public void rateNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -5
            );
        });
    }

    @Test
    public void maxBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    100,
                    5
            );
        });

    }

    @Test
    public void initialBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    200,
                    1_000,
                    10_000,
                    5
            );
        });

    }

    @Test
    public void initialBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    20_000,
                    1_000,
                    10_000,
                    5
            );
        });

    }

    @Test
    public void payNegative() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);


        boolean result = account.pay(-1_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payZero() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        boolean result = account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void successfulPay() {
        SavingAccount account = new SavingAccount(2_000, 500, 10_000, 5);
        boolean result = account.pay(100);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void balanceNegativePay() {
        SavingAccount account = new SavingAccount(2_000, 500, 10_000, 5);

        boolean result = account.pay(2_500);

        Assertions.assertEquals(2000, account.getBalance());
        Assertions.assertEquals(false, result);

    }

    @Test
    public void balanceEqualMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        boolean result = account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    @Test
    public void interestOnTheBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        int result = account.yearChange();

        Assertions.assertEquals(100, result);
    }

}
