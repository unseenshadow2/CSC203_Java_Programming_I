package com.parsch.anthony;

/**
 * A contact to serve as a single entry in a
 * contact book.
 * @author unseenshadow2
 *
 */
public class Contact 
{
	// Public Variables
	public Address address = new Address();
	
	// Protected Variables
	protected String firstName;
	protected String lastName;
	protected String phoneNumber;
	
	// Private Variables
	
	// Getter and Setter for firstName
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String newFirstName)
	{
		firstName = newFirstName;
	}
	
	// Getter and Setter for lastName
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String newLastName)
	{
		lastName = newLastName;
	}
	
	// Getter and Setter for phoneNumber
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String newPhoneNumber)
	{
		phoneNumber = newPhoneNumber;
	}
	
	/**
	 * Returns a human readable string representing the values
	 * contained within the instance of this Contact.
	 * @return The human readable string that represents this object.
	 */
	public String getAllInfoAsString()
	{
		String toReturn = "";
		
		toReturn += lastName + ", " + firstName + ":\n";
		toReturn += "\tPhone Number: " + phoneNumber + "\n";
		toReturn += "\tAddress: " + address.getStreet() + "\n";
		toReturn += "\t\t" + address.getCity() + ", " + address.getState() + " " + address.getZip();
		
		return toReturn;
	}
}
