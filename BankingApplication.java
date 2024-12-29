import java.util.ArrayList;
import java.util.Scanner;

class Account{
	private String accountHolderName;
	private double balance;
	
	public Account(String accountHolderName) {
	    this.accountHolderName = accountHolderName;
	    this.balance = 0.0;
	}

	public String getAccountHolderName(){
		return accountHolderName;
	}	
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		if(amount>0) {
			balance += amount;
			System.out.println("Deposited:$"+amount);
		}
		else {
			System.out.println("Deposit amount must be positive");
		}
	}
	public void withdraw(double amount) {
		if(amount>0 &&amount<=balance) {
			balance-=amount;
			System.out.println("Withdrew:$"+amount);
		}else {
			System.out.println("Insufficient funds");
		}
		
	}
}
public class BankingApplication{
		private static ArrayList<Account>accounts = new ArrayList<>();
		public static void main(String[]args) {
		int choice;
		do {
			System.out.println("\n---Banking Application Menu---");
			System.out.println("1.Create Account");
			System.out.println("2. Deposit money");
			System.out.println("3.Withdraw money");
			System.out.println("4.Check Balance");
			System.out.println("5. Exit ");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			
			switch(choice) {
			case 1:
				createAccount();
				break;
			case 2:
				depositMoney();
				break;
			case 3:
				withdrawMoney();
				break;
			case 4:
				checkBalance();
				break;
			case 5:
				System.out.println("Exiting the appllication .");
				break;
			default:
				System.out.println("Invalid choice.Please try again");
				
					
			}
			
		}while(choice!=5);
	}


	private static void createAccount() {
	    System.out.print("Enter Account holder's name: ");
	    String name = scanner.nextLine();
	    Account newAccount = new Account(name);
	    accounts.add(newAccount);
	    System.out.println("Account created for " + name);
	}




	private static void depositMoney() {
		System.out.print("Enter Account holder's name:");
		String name = scanner.nextLine();
		Account account = findAccount(name);
		if(account!=null) {
			System.out.print("Enter amount to deposit:");
			double amount = scanner.nextDouble();
			account.deposit(amount);
		}else {
			System.out.println("Account not found.");
		}
		}
	


	private static void withdrawMoney() {
		System.out.print("Enter Account holder's name:");
		Scanner scanner = null;
		String name = scanner.nextLine();
		Account account = findAccount(name);
		if(account!=null ) {
			System.out.print("Enter amount to withdraw:");
			double amount = scanner.nextDouble();
			account.withdraw(amount);
		}else {
			System.out.print("Account not found.");
		}
	}


	private static void checkBalance() {
		System.out.print("Enter Account holder's name:");
		Scanner scanner = null;
		String name = scanner.nextLine();
		Account account = findAccount(name);
		if(account!=null ) {
			System.out.print("Current balance for"+name+":$"+account.getBalance());
			double amount = scanner.nextDouble();
			account.withdraw(amount);
		}else {
			System.out.print("Account not found.");
		}


	}


	private static Account findAccount(String name) {
	    for (Account account : accounts) {
	        if (account.getAccountHolderName().equalsIgnoreCase(name)) {
	            return account;
	        }
	    }
	    return null;
	}


	private static Scanner scanner = new Scanner(System.in);

	}
