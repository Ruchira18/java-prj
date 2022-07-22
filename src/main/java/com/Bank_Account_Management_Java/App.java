package com.Bank_Account_Management_Java;

import java.util.Scanner;

import com.Bank_Account_Management_Java.entity.BankAcc1;
import com.Bank_Account_Management_Java.service.BankService;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	BankService bs = new BankService();
		int AccNo;
		Double amt;
		char ch = 'Y';
		while(ch == 'Y')
		{
		System.out.println("*********BANKING SYSTEM***********");
		System.out.println("1)Add Account\n2)View Account\n3)View Accounts\n4)Withdraw Account\n5)Deposit Account\n6)Delete Account");
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter your choice: ");
		int option = ip.nextInt();
		switch(option)
		{
			case 1:
				System.out.println("Enter the number of Accounts:");
				int count = ip.nextInt();
				bs.addAccount(count);
				break;
			case 2:
				System.out.println("Enter the account number of Customer:");
				AccNo = ip.nextInt();
				System.out.println(bs.viewAccount(AccNo));
				break;
			case 3:
				for(BankAcc1 a:bs.viewAccounts())
				{
					System.out.println(a);
				}
				break;
			
			case 4:
				System.out.println("Enter the account number of Customer:");
				AccNo = ip.nextInt();
				System.out.println("Enter the amount to be withdrawn..");
				amt = ip.nextDouble();
				bs.withdraw(AccNo,amt);
				break;
			case 5:
				System.out.println("Enter the account number of Customer:");
				AccNo = ip.nextInt();
				System.out.println("Enter the amount to be deposited..");
				amt = ip.nextDouble();
				bs.deposite(AccNo,amt);
				break;
			case 6:
				System.out.println("Enter the account number of Customer:");
				AccNo = ip.nextInt();
				bs.deleteAccount(AccNo);
				break;
			default:
				System.out.println("Invalid Choice..");
				break;
		}
		System.out.println("Enter Y to continue...");
		ch = ip.next().charAt(0);
		}
		System.out.println("Thank you for using...");
    }
}
