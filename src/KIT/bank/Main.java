package KIT.bank;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BankService bankService=new BankService();
		Scanner s=new Scanner(System.in);
		boolean exit=false;
		
		while(!exit) {
			System.out.println("\n---Bank Management System---");
			System.out.println("1.Create Account");
			System.out.println("2.Get Account Details");
			System.out.println("3.Deposit");
			System.out.println("4.Withdraw");
			System.out.println("5.Transfer");
			System.out.println("6.Transaction History");
			System.out.println("7.Exit");
			int choice=s.nextInt();
			s.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Enter accno:");
				  long accno = s.nextLong();
                  s.nextLine();
                  System.out.print("Enter accholder name: ");
                  String accholder = s.nextLine();
                  System.out.print("Enter  bal: ");
                  double bal = s.nextDouble();
                  bankService.createAccount(accno, accholder, bal);
                  break;
             
			 case 2:
                 System.out.print("Enter account number: ");
                 long accnoGet = s.nextLong();
                 bankService.getAccount(accnoGet);
                 break;
                 
			 case 3:
                 System.out.print("Enter account number: ");
                 long accnoDeposit = s.nextLong();
                 System.out.print("Enter amount to deposit: ");
                 double depositAmount = s.nextDouble();
                 bankService.deposit(accnoDeposit, depositAmount);
                 break;
                 
			 case 4:
                 System.out.print("Enter account number: ");
                 long accnoWithdraw = s.nextLong();
                 System.out.print("Enter amount to Withdraw: ");
                 double withdrawAmount = s.nextDouble();
                 bankService.withdraw(accnoWithdraw, withdrawAmount);
                 break;
                 
			 case 5:
                 System.out.print("Enter from account number: ");
                 long fromAcc = s.nextLong();
                 System.out.print("Enter to account number: ");
                 long toAcc = s.nextLong();
                 System.out.print("Enter amount to transfer: ");
                 double transferAmount = s.nextDouble();
                 bankService.transfer(fromAcc, toAcc, transferAmount);
                 break;
                 
			 case 6:
				 bankService.viewTransactionHistory();
				 break;
          
			   case 7:
                   exit = true;
                   System.out.println("Exiting... Goodbye!");
                   break;

               default:
                   System.out.println("Invalid choice! Please try again.");
			}
		}

	
		s.close();
	}	
		
}
		
	
	


