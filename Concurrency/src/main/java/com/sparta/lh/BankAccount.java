package com.sparta.lh;

public class BankAccount implements Runnable{
    private static int balance = 100;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " check the balance " + balance);
        makewithdrawal(75);
        if (balance < 0) {
            System.out.println("Account is withdrawn. Balance: " + balance);
        }
    }
    private void makewithdrawal(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is making a withdrawal");
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount);
        } else {
            System.out.println("Not enough balance for " + Thread.currentThread().getName() + " to withdraw");
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Thread husband = new Thread(bankAccount);
        Thread wife = new Thread(bankAccount);

        husband.setName("Husband");
        wife.setName("Wife");

        husband.start();
        wife.start();
    }
}
