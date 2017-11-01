package Core_Java_Assignment8_3;

	import java.util.logging.Level;
	import java.util.logging.Logger;

	public class ThreadExercise extends Thread implements Runnable {  //class implementing Runnable interface

	private Person person;

	public ThreadExercise(Person p) {
	    this.person = p;
	}

	public static void main(String[] args) {

	    ThreadExercise ts1 = new ThreadExercise(new Person("Ram"));
	    ts1.start();
	    ThreadExercise ts2 = new ThreadExercise(new Person("Shyam"));
	    ts2.start();
	    ThreadExercise ts3 = new ThreadExercise(new Person("Mohan"));
	    ts3.start();

	}

	@Override
	public void run() {
	    for (int i = 0; i < 3; i++) {
	        try {
	            Account acc = Account.getAccount(person);
	            acc.withdraw(1000);
	            try {
	                Thread.sleep(2000);
	            } catch (InterruptedException ex) {
	                Logger.getLogger(ThreadExercise.class.getName()).log(Level.SEVERE, null, ex);
	            }
	            if (acc.getBal() < 0) {
	                System.out.println("account is overdrawn!");
	            }
	            acc.deposit(2000);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    System.out.println("Final Acc balance is Rs." + Account.getBal());
	}}
