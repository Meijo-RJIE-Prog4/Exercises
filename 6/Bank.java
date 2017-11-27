
public class Bank implements Runnable {

	private Account account;
	
	public Bank(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return this.account;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep((long) Math.random());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.deposit(1);
		}
	}

}
