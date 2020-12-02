package com.capgemini;

import java.util.LinkedList;

public class ICICIBank {
	LinkedList<Account> accounts = new LinkedList<>();

	public String createAccount(int accountNumber, int amount) throws InsufficientOpeningAmountException {

		if (amount >= 500) {
			Account account = new Account(accountNumber, amount);

			accounts.add(account);

			return "account created successfully";
		}
		throw new InsufficientOpeningAmountException();

	}

	private Account searchAccount(int accountNumber) throws InvalidAccountNumberException {

		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		throw new InvalidAccountNumberException();

	}

	public int withdrawAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		Account account = searchAccount(accountNumber);

		if ((account.getAmount() - amount) >= 0) {
			account.setAmount(account.getAmount() - amount);
			return account.getAmount();
		}

		throw new InsufficientBalanceException();
	}

	public int depositAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		Account account = searchAccount(accountNumber);

		if ((account.getAmount() + amount) >= 0) {
			account.setAmount(account.getAmount() + amount);
			return account.getAmount();
		}

		throw new InsufficientBalanceException();
	}

	public int fundTransferAmount(int fromAccountNumber, int toAccountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		Account fromAccount = searchAccount(fromAccountNumber);
		Account toAccount = searchAccount(toAccountNumber);
		
		if (fromAccount.getAmount() >= amount) {
			toAccount.setAmount(toAccount.getAmount() + amount);
			fromAccount.setAmount(fromAccount.getAmount()-amount);
			//account.setAmount(account.getAmount() + amount);
			return toAccount.getAmount();
		}

		throw new InsufficientBalanceException();
	}

}
