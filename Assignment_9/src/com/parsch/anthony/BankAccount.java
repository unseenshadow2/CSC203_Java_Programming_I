package com.parsch.anthony;

import java.text.DecimalFormat;

/**
 * A bank account that is made up of three parts: An account number, account holder, and current balance.
 * 
 * @author aparsch
 */
public class BankAccount 
{
	// Public Variables
	/**
	 * A String representing the person, or entity, that holds the account.
	 */
	public String accountHolder = "";
	public DecimalFormat df = new DecimalFormat(".##");
	
	// Private Variables
	private String accountNumber;
	private double currentBalance = 0;
	
	/**
	 * The constructor for BankAccount. Gets the account number on creation.
	 * 
	 * @param accountNumber The string referring to the series of numbers associated with the account
	 */
	public BankAccount (String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	/**
	 * The constructor for BankAccount. Gets the account number and account holder on creation.
	 * 
	 * @param accountNumber The string referring to the series of numbers associated with the account
	 * @param accountHolder The string referring to the holder of the account
	 */
	public BankAccount (String accountNumber, String accountHolder)
	{
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
	}
	
	/**
	 * Add money to the account.
	 * 
	 * @param change The amount of money deposited into the account.
	 */
	public void deposit (double change)
	{
		currentBalance += change;
	}
	
	/**
	 * Take money from the account.
	 * 
	 * @param change The amount of money withdrawn from the account.
	 */
	public void withdrawal (double change)
	{
		currentBalance -= change;
	}
	
	/**
	 * Returns the accountNumber associated with the account.
	 * 
	 * @return The accountNumber associated with the account.
	 */
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	/**
	 * Returns the currentBalance of the account.
	 * 
	 * @return The currentBalance of the account.
	 */
	public double getCurrentBalance()
	{
		return currentBalance;
	}
	
	/**
	 * Returns the string that represents the values of this BankAccount.
	 * 
	 * @return The string that represents the values of this BankAccount.
	 */
	public String getString()
	{
		String toReturn = "Account Number: " + accountNumber +"\n\t";
		toReturn += "Account Holder: " + accountHolder + "\n\t";
		toReturn += "Current Balance: $" + df.format(currentBalance);
		
		return toReturn;
	}
}
