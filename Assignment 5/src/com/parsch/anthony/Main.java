/**
 * Name: Assignment 5
 * Author: Anthony Parsch Jr.
 * Date: 6/9/2016
 * Java Version: 1.7 JSE
 * Operating System: Ubuntu Linux
 * Purpose: To display my ability to control looping and logic
 * 			in the Java programming language.
 */
package com.parsch.anthony;

import java.util.Scanner;

public class Main 
{

	/**
	 * The main body of the program.
	 * 
	 * @param args The arguments passed in from the command line
	 */
	public static void main(String[] args) 
	{
		// Our input ints
		int horizontal = 0;
		int vertical = 0;
		boolean filled = false;
		
		// Our input gathering
		Scanner scanner = new Scanner(System.in);
		
		// Display menu and gather input
		System.out.println("\nWelcome to the Parsch Rectangle generator!");
		
		System.out.print("\nPlease input the width of the rectangle: ");
		horizontal = scanner.nextInt();
		System.out.print("Please input the height of the rectangle: ");
		vertical = scanner.nextInt();
		
		// Booleans only have two values, ensure input is correct
		for (boolean isRunning = true; isRunning; )
		{
			int input = -1;
			
			System.out.println("Would you like a solid rectangle?");
			System.out.print("(1 for yes, 0 for no) ");
			input = scanner.nextInt();
			
			if (input == 1)
			{
				filled = true;
				isRunning = false;
			}
			else if (input == 0)
			{
				filled = false;
				isRunning = false;
			}
			else
			{
				System.out.print("\nERROR: Bad input!\n");
			}
		}
		
		
		// Build our rectangle
		GenerateRectangle(horizontal, vertical, filled);
	}

	/**
	 * Prints a rectangle made of asterisks with the sizes given.
	 * 
	 * @param width How many characters wide the rectangle is
	 * @param heigth How many characters tall the rectangle is
	 */
	public static void GenerateRectangle(int width, int height, boolean filled)
	{
		int i = 0;
		int j = 0;
		
		// Height
		while (i < height)
		{
			// Width
			while (j < width)
			{
				// Fill
				if (filled)
				{
					System.out.print('*');
				}
				else if ((i == 0) || (i == (height-1)))
				{
					System.out.print('*');
				}
				else if ((j == 0) || (j == (width-1)))
				{
					System.out.print('*');
				}
				else
				{
					System.out.print(' ');
				}
				
				j++;
			}
			
			// Add some space
			System.out.println();
			
			// Increment and reset
			i++;
			j = 0;
		}
	}
	
	public static void GenerateRectangle(int width, int height)
	{
		GenerateRectangle(width, height, false);
	}
}
