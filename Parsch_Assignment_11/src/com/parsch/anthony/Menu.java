/**
 * Name: Assignment 11
 * Author: Anthony Parsch Jr.
 * Date: 7/19/2016
 * Java Version: 1.8 JSE
 * Operating System: Windows 10
 * Purpose:	To demonstrate my control of polymorphic
 * 			Behavior.
 */

package com.parsch.anthony;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Menu 
{
	public static Scanner scanner;

	public static void main(String[] args) 
	{
		Vector<Contact> contacts = new Vector<Contact>();
		boolean isRunning = true;
		scanner = new Scanner(System.in);
		
		// Continue running the program until the user exits
		while (isRunning)
		{
			isRunning = mainMenu(contacts);
		}
	}

	/**
	 * Display the main menu and route to the appropriate
	 * sub-menus.
	 * @return Returns true if the user didn't exit.
	 */
	static boolean mainMenu(Vector<Contact> contacts)
	{
		System.out.println("\n\tMenu:");
		System.out.println("1) Add New Contact");
		System.out.println("2) Look Up a Contact by Last Name");
		System.out.println("3) Exit the Application");
		System.out.println("4) View All Contacts"); 
		System.out.println();
		System.out.print("Please choose an option: ");
		
		int input = getInt();
		
		// Process input
		switch(input)
		{
		case 1:
			addNewContact(contacts);
			break;
			
		case 2:
			searchByLastName(contacts);
			break;
			
		case 3:
			return false;
			
		case 4:
			for (Contact x : contacts)
			{
				System.out.println(x.getAllInfoAsString());
			}
			break;
			
		default:
			System.out.println("ERROR: Value not within allowed range.");
			break;
		}
		
		return true;
	}
	
	/**
	 * Adds either a normal contact or a friend contact.
	 */
	static void addNewContact(Vector<Contact> contacts)
	{
		boolean isRunning = false;
		boolean isAddingFriend = false;
		boolean isExiting = false;
		
		// Determine whether the user wants to add a friend or a normal contact
		do
		{
			System.out.println("\nAdd New Contact:");
			System.out.println("1) Add Contact");
			System.out.println("2) Add Friend");
			System.out.println("3) Return to Main Menu");
			System.out.println();
			System.out.print("Please choose an option: ");
			
			// Get input
			int input = getInt();
			
			// Process input
			switch (input)
			{
			case 1:
				isRunning = false;
				isAddingFriend = false;
				break;
				
			case 2:
				isRunning = false;
				isAddingFriend = true;
				break;
				
			case 3:
				isExiting = true;
				isRunning = false;
				break;
				
			default:
				System.out.println("ERROR: Value not within allowed range.");
				isRunning = true;
				break;
			}
		} while (isRunning);
		
		// If we aren't exiting, add the contact
		if (!isExiting)
		{
			Contact toAdd; // We can instantiate a Contact or a Friend
			
			// Set toAdd to either a new Contact or a new Friend
			if (isAddingFriend)
			{
				toAdd = new Friend();
			}
			else
			{
				toAdd = new Contact();
			}
			
			// Grab the floating \n
			scanner.nextLine();
			
			// Get the values for a standard contact
			System.out.print("Please input the contact's first name: ");
			toAdd.setFirstName(scanner.nextLine());
			
			System.out.print("Please input the contact's last name: ");
			toAdd.setLastName(scanner.nextLine());
			
			System.out.print("Please input the contact's phonenumber: ");
			toAdd.setPhoneNumber(scanner.nextLine());
			
			System.out.print("Please input the contact's street address: ");
			toAdd.address.setStreet(scanner.nextLine());
			
			System.out.print("Please input the contact's city: ");
			toAdd.address.setCity(scanner.nextLine());
			
			System.out.print("Please input the contact's state: ");
			toAdd.address.setState(scanner.nextLine());
			
			System.out.print("Please input the contact's zip: ");
			toAdd.address.setZip(scanner.nextLine());
			
			// Catch a few more values if we are adding a friend
			if (isAddingFriend)
			{
				Friend temp = (Friend) toAdd;
				
				System.out.print("Please input the friend's email address: ");
				temp.setEmailAddress(scanner.nextLine());
				
				System.out.print("Please input the friend's birth date: ");
				temp.setBirthDate(scanner.nextLine());
			}
			
			contacts.addElement(toAdd);
		}
	}
	
	/**
	 * Asks the user for the last name. After doing so, it
	 * displays all contacts with the last name the user
	 * input.
	 */
	static void searchByLastName(Vector<Contact> contacts)
	{
		// Grab the floating \n
		scanner.nextLine();
		
		// Get the last name
		System.out.println("Please enter the last name of the contact you would like to find: ");
		String toFind = scanner.nextLine();
		
		// Display the matches
		for (Contact x : contacts)
		{
			if (x.getLastName().contains(toFind)) { System.out.println(x.getAllInfoAsString()); }
		}
	}
	
	/**
	 * Gets an integer from the user. If the user does not
	 * input an integer, returns 0.
	 * @return The number that the user input.
	 */
	static int getInt()
	{
		int input;
		
		// Acquire input
		try 
		{
			input = scanner.nextInt();
		}
		catch(InputMismatchException ime)
		{
			System.out.println("ERROR: Invalid input");
			input = 0;
		}
		
		return input;
	}
}
