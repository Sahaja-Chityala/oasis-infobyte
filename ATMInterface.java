import java.util.Scanner;
class ATMInterface {
	private int balance;
	private String userId;
	private String userPin;
	public ATMInterface() {
		this.balance=1000;
		this.userId="123456";
		this.userPin="7890";
	}
	public void displayMenu() {
		System.out.println("-------------");
		System.out.println("Welcome to ATM");
		System.out.println("1.View balance");
		System.out.println("2.Withdraw");
		System.out.println("3.Deposit");
		System.out.println("4.Transfer");
		System.out.println("5.Quit");
	}
	public void showBalance() {
		System.out.println("Available Balance is:$" +balance);
	}
	public void withDraw(int amount) {
		if(amount>0 && amount <=balance) {
			balance-=amount;
			System.out.println("$" +amount +" withdrawn successfully");
			System.out.println("--------------");
			}
			else {
			   System.out.println("Invalid amount or insufficient balance.");
			}
	}
	public void Deposit(int amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("$" +amount +" deposited successfully");
		}
		else {
			System.out.println("Invalid amount");
		}
	}
	public void transfer(int amount,ATMInterface receiver) {
		if(amount>0 && amount<=balance) {
			balance-=amount;
			receiver.balance+=amount;
			System.out.println("$" +amount +" transferred successfully");
			}
			else {
			   System.out.println("Invalid amount or insufficient balance.");
			}
	}
	public static void main(String[] args) {
		ATMInterface atm=new ATMInterface();
		Scanner src=new Scanner(System.in);
		System.out.print("Enter your User ID:");
		String inputUserId=src.nextLine();
		System.out.print("Enter your pin:");
		String inputPin=src.nextLine();
		if(inputUserId.equals(atm.userId)&&inputPin.equals(atm.userPin)) {
			int choice;
			do {
				atm.displayMenu();
				System.out.println("--------------");
				System.out.print("Enter your choice:");
				choice=src.nextInt();
				switch(choice)  {
					case 1:
						atm.showBalance();
						break;
					case 2:
						System.out.print("Enter the amount to withdraw:$");
						int withDrawAmount=src.nextInt();
						atm.withDraw(withDrawAmount);
						break;
					case 3:
						System.out.print("Enter the amount to Deposit:$");
						int depositAmount=src.nextInt();
						atm.Deposit(depositAmount);
						break;
					case 4:
						System.out.print("Enter the amount to transfer:$");
						int transferAmount=src.nextInt();
						atm.transfer(transferAmount,atm);
						break;
					case 5:
						System.out.println("Thank you for using ATM");
						break;
					default:
						System.out.println("Invalid choice.Try again.");
				}
			} while(choice!=5);
		} else {
			System.out.println("Invalid user id Or Pin.Access denied.");
		}
	src.close();	
	}
}

















