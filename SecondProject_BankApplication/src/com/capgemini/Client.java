package com.capgemini;

public class Client {
	public static void main(String[] args) {
		ICICIBank bank = new ICICIBank();

		try {               //Creating an account
		System.out.println(bank.createAccount(100, 3000));
		System.out.println(bank.createAccount(101, 2000));
		System.out.println(bank.createAccount(102, 50)); //less than min balance
		} catch (InsufficientOpeningAmountException e) {
			System.out.println("InsufficientOpeningAmount balance..maintain 500rs balance minimum");
		}

		try {          // withdraw
			System.out.println("Balance = " + bank.withdrawAmount(100, 2000));
		} catch (InvalidAccountNumberException i) {
			System.out.println("Invalid account number ");
		} catch (InsufficientBalanceException ibe) {
			System.out.println("insufficient balance");
		}
		
		try {          // deposit
			System.out.println("Balance = " + bank.depositAmount(100, 5000));
		} catch (InvalidAccountNumberException i) {
			System.out.println("Invalid account number ");
		} catch (InsufficientBalanceException ibe) {
			System.out.println("insufficient balance");
		}
		
		try {          // fund tranfer
			System.out.println("Balance in Account to which amt is transfered = " + bank.fundTransferAmount(100, 101, 2000));
		} catch (InvalidAccountNumberException i) {
			System.out.println("Invalid account number ");
		} catch (InsufficientBalanceException ibe) {
			System.out.println("insufficient balance enter the amount within the balance");
		}

	}

}
