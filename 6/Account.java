
public class Account {
	private int balance;
	
	public Account() {
		this.balance = 0;
	}
	
	public void deposit(int money) {
		this.balance += money;
	}
	
	public int getBalance() {
		return this.balance;
	}
}
