/**
 * Name: Assignment 9
 * Author: Anthony Parsch Jr.
 * Date: 6/9/2016
 * Java Version: 1.7 JSE
 * Operating System: Ubuntu Linux
 * Purpose: To display my ability to handle object
 * 			oriented programming in Java.
 */
package com.parsch.anthony;
 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
	static Scanner input = new Scanner(System.in);
	static int currentNumber = 0;

	/**
	 * Handles the running of the program and acts as the control.
	 * 
	 * @param args The command line arguments
	 */
	public static void main(String[] args)
	{
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		int menuChoice;
		
		// The main program loop
		for (boolean isRunning = true; isRunning; )
		{
			// The menu
			do { menuChoice = DisplayMenu(); } while (menuChoice == -1);
			
			switch (menuChoice)
			{
			case 1:
				CreateAccount(accounts);
				break;
				
			case 2:
				DeleteAccount(accounts);
				break;
				
			case 3:
				ViewAccounts(accounts);
				break;
				
			case 4:
				MakeDeposit(accounts);
				break;
				
			case 5:
				MakeWithdrawal(accounts);
				break;
				
			case 6:
				isRunning = false;
				break;
			}
		}
		
		input.close();
	}

	/**
	 * Displays the main menu.
	 * 
	 * @return The user's choice, or -1 if the choice is not valid.
	 */
	public static int DisplayMenu()
	{
		int userResponse = -1;
		
		// Display the menu
		System.out.println("\n\n1. Create New Account");
		System.out.println("2. Delete Account");
		System.out.println("3. View All Accounts");
		System.out.println("4. Make Deposit");
		System.out.println("5. Make Withdrawal");
		System.out.println("6. Exit Program");
		System.out.print("\nPlease choose an option (input the associated number): ");
		
		userResponse = GetInt();
		
		return userResponse;
	}
	
	/**
	 * Gets an int, with error catching.
	 * 
	 * @return The integer the user inputed, or a -1 if not an integer.
	 */
	public static int GetInt()
	{
		int toReturn;
		
		// Catch invalid input
		try { toReturn = input.nextInt(); }
		catch (InputMismatchException ex)
		{
			toReturn = -1;
			System.out.println("ERROR: Invalid Input\n");
			input.next();
		}
		
		return toReturn;
	}
	
	/**
	 * Gets a double, with error catching.
	 * 
	 * @return The double the user inputed, or a 0 if not an double.
	 */
	public static double GetDouble()
	{
		double toReturn;
		
		// Catch invalid input
		try { toReturn = input.nextDouble(); }
		catch (InputMismatchException ex)
		{
			toReturn = 0;
			System.out.println("ERROR: Invalid Input\n");
			input.next();
		}
		
		return toReturn;
	}
	
	/**
	 * Display all current accounts, or no accounts if none have been entered.
	 * 
	 * @param accounts The ArrayList<BankAccount> that holds the accounts.
	 */
	public static void ViewAccounts(ArrayList<BankAccount> accounts)
	{
		if (accounts.isEmpty())
		{
			System.out.println("\nNo accounts exist. Please create an account.");
		}
		else
		{
			System.out.println();
			
			for (BankAccount x : accounts)
			{
				System.out.println(x.getString());
			}
		}
	}
	
	/**
	 * Add an account.
	 * 
	 * @param accounts The ArrayList<BankAccount> that holds the accounts.
	 */
	public static void CreateAccount(ArrayList<BankAccount> accounts)
	{
		String holder;
		
		System.out.print("Please input the account holder's name: ");
		holder = input.next();
		++currentNumber;
		
		accounts.add(new BankAccount(String.valueOf(currentNumber), holder));
	}
	
	/**
	 * Deletes an account.
	 * 
	 * @param accounts The ArrayList<BankAccount> that holds the accounts.
	 */
	public static void DeleteAccount(ArrayList<BankAccount> accounts)
	{
		int userIn = -1;
		String toFind;
		
		// Find out what account to remove
		System.out.print("Please input the number of the account you want to delete: ");
		userIn = GetInt();
		
		if (userIn <= 0) // Number is too small
		{
			System.out.println("ERROR: Invalid input. Please try again.");
		}
		else
		{
			int deletePos = -1;
			toFind = Integer.toString(userIn);
			
			deletePos = GetAccountIndex(toFind, accounts);
			
			if (deletePos != -1)
			{
				accounts.remove(deletePos);
			}
		}
	}
	
	/**
	 * Returns the index of the given account number in accounts.
	 * 
	 * @param accountNumber The accountNumber to find.
	 * @param accounts The ArrayList<BankAccount> that holds the accounts.
	 * @return The index of the given account number in accounts, or -1 if it doesn't exist.
	 */
	public static int GetAccountIndex(String accountNumber, ArrayList<BankAccount> accounts)
	{
		int toReturn = -1;
		
		if (accounts.size() <= 0) // The size of accounts is too small
		{
			System.out.println("ERROR: No accounts exist. Please add an account and try again.");
			return toReturn;
		}
		
		// Find the account to remove
		for (int i = 0; i < accounts.size(); i++)
		{
			if (accounts.get(i).getAccountNumber().equals(accountNumber))
			{
				toReturn = i;
			}
		}
		
		// If no account found
		if (toReturn == -1)
		{
			System.out.println("ERROR: No account with that account number exists.");
		}
		
		return toReturn;
	}
	
	/**
	 * Make a deposit.
	 * 
	 * @param accounts The ArrayList<BankAccount> that holds the accounts.
	 */
	public static void MakeDeposit(ArrayList<BankAccount> accounts)
	{
		int index;
		int userIn;
		String toFind;
		double change;
		
		// Find out what account to use
		System.out.print("Please input the number of the account you want to deposit to: ");
		userIn = GetInt();
		
		if (userIn <= 0) // Number is too small
		{
			System.out.println("ERROR: Invalid input. Please try again.");
		}
		else
		{
			toFind = Integer.toString(userIn);
			index = GetAccountIndex(toFind, accounts);
			
			if (index != -1)
			{
				System.out.print("How much would you like to deposit: ");
				change = GetDouble();
				
				accounts.get(index).deposit(change);
			}
		}
	}
	
	/**
	 * Make a withdrawal.
	 * 
	 * @param accounts The ArrayList<BankAccount> that holds the accounts.
	 */
	public static void MakeWithdrawal(ArrayList<BankAccount> accounts)
	{
		int index;
		int userIn;
		String toFind;
		double change;
		
		// Find out what account to use
		System.out.print("Please input the number of the account you want to withdrawal from: ");
		userIn = GetInt();
		
		if (userIn <= 0) // Number is too small
		{
			System.out.println("ERROR: Invalid input. Please try again.");
		}
		else
		{
			toFind = Integer.toString(userIn);
			index = GetAccountIndex(toFind, accounts);
			
			if (index != -1)
			{
				System.out.print("How much would you like to withdrawal: ");
				change = GetDouble();
				
				accounts.get(index).withdrawal(change);
			}
		}
	}
}
