package Core_Java_Assignment8_3;
/*
This program implements the basic functions for the online Banking Application
using Multithreading & Synchronization.
*/
public class Account {  // class having basic bank functions

	
	public static Account account;
	private static int balance = 5000;
	private static Person person;


	private Account() {
	}

	public static Account getAccount(Person p) {
	    if (account == null) {
	        account = new Account();
	    }
	    Account.person = p;
	    return account;
	}

	public static int getBal() {   // function to return balance
	    return balance;
	}

	public  synchronized void withdraw(int bal) {   // function to withdraw amount
	    try {

	        if (balance >= bal) {
	            System.out.println(person.getName() + " " + "tried to withdraw");
	            try {
	                Thread.sleep(100);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            balance = balance - bal;
	            System.out.println(person.getName() + " " + "withdrawn");
	        } else {
	            System.out.println(person.getName() + " " + "doesn't have enough money for withdrawl ");
	        }
	        System.out.println(person.getName() + " " + " New Account Balance is Rs." + balance);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public synchronized void deposit(int bal) {  // function to deposit amount
	    try {
	        if (bal > 0) {
	            System.out.println(person.getName() + " " + "tried to deposit");
	            try {
	                Thread.sleep(100);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            balance = balance + bal;
	            System.out.println(person.getName() + " " + "deposited");
	        } else {
	            System.out.println(person.getName() + " " + "doesn't have enough money for deposit");
	        }
	        System.out.println(person.getName() + " " + " New Account Balance is Rs." + balance);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}}
