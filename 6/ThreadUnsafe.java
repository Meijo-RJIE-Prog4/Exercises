
public class ThreadUnsafe {

	public static void main(String[] args) {
		Account account = new Account();
		Bank bank = new Bank(account);
		Thread thread1 = new Thread(bank);
		Thread thread2 = new Thread(bank);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException ie) {}
		
		System.out.println("balance = " + account.getBalance());
	}
}
