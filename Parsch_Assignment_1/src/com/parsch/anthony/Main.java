/**
 * Name: Assignment 1
 * Author: Anthony Parsch Jr.
 * Date: 5/15/2016
 * Java Version: 1.7 JSE
 * Operating System: Ubuntu Linux
 * Purpose: To display my name, major, and course that
 * 			this program applies to.
 */
package com.parsch.anthony;

import java.util.Scanner;

/**
 * @author Anthony Parsch
 */
public class Main 
{

	/**
	 * main() is just your everyday main() function.
	 * 
	 * @param args The arguments passed in by the command-line, if run from the command line
	 */
	public static void main(String[] args) 
	{
		// "Program variables"
		String course = "Java Programming 1 - CSC 203";
		String name = "Anthony Parsch Jr.";
		String major = "Dual Majored Batchelours Degree in Advancing Computer Science\nand Video Game Programming at the University of Advancing\nTechnology";
		String strIn = "";
		Scanner input = new Scanner(System.in);
		
		// Introduction/program header
		print("\n");
		println("***********************************");
		println("***** Welcome to Assignment 1 *****");
		println("***********************************");
		
		// The main loop of the program
		for (boolean isRunning = true; isRunning; )
		{
			// Options header with whitespace for readability
			println("\n\nPlease choose an option:");
			println("1. Display course");
			println("2. Display student's name");
			println("3. Display student's major");
			println("4. Exit program");
			print("\n");
			
			// Acquire input
			strIn = input.nextLine();
						
			// Process input
			if (strIn.equals("1")) println(course);
			else if (strIn.equals("2")) println(name);
			else if (strIn.equals("3")) println(major);
			else if (strIn.equals("4")) isRunning = false;
			else println("ERROR: Incorrect input");
		}
	}

	/**
	 * A quick wrapper around System.out's println to make things go a little faster
	 * @param toPrint The string to be printed
	 */
	public static void println(String toPrint)
	{
		System.out.println(toPrint);
	}
	
	/**
	 * A quick wrapper around System.out's print to make things a little faster
	 * @param toPrint The string to be printed
	 */
	public static void print(String toPrint)
	{
		System.out.print(toPrint);
	}
}
