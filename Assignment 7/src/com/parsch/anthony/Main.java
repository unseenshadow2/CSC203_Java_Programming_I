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
	// Our input gathering
	static Scanner scanner = new Scanner(System.in);

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
		
		// Display menu and gather input
		System.out.println("\nWelcome to the Parsch Rectangle generator!");
		
		vertical = GetHeight();
		horizontal = GetWidth();
		
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
		scanner.close();
	}
	
	/**
	 * Get the height from the user.
	 * @return The height value given by the user.
	 */
	public static int GetHeight()
	{
		int toReturn = -1; 
		
		while (!ValidateHWValue(toReturn))
		{
			System.out.print("\nPlease input the height of the rectangle (between 1 and 40): ");
			toReturn = scanner.nextInt();
		}
		
		return toReturn;
	}
	
	/**
	 * Get the width from the user.
	 * @return The width value given by the user.
	 */
	public static int GetWidth()
	{
		int toReturn = -1;
		
		while (!ValidateHWValue(toReturn))
		{
			System.out.print("Please input the Width of the rectangle (between 1 and 40): ");
			toReturn = scanner.nextInt();
		}
		
		return toReturn;
	}
	
	/**
	 * Validate a height/width value.
	 * @param value The value to validate.
	 * @return Whether the value is good.
	 */
	public static boolean ValidateHWValue(int value)
	{
		return (value > 0) && (value <= 40);
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
