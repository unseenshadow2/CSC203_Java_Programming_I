package com.parsch.anthony;

public class Friend extends Contact 
{
	// Public Variables
	
	// Protected Variables
	protected String emailAddress;
	protected String birthDate;
	
	// Private Variables
	
	// Getter and Setter for emailAddress
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public void setEmailAddress(String newEmailAddress)
	{
		emailAddress = newEmailAddress;
	}
	
	// Getter and Setter for birthDate
	public String getBirthDate()
	{
		return birthDate;
	}
	
	public void setBirthDate(String newBirthDate)
	{
		birthDate = newBirthDate;
	}
	
	/**
	 * Returns a human readable string representing the values
	 * contained within the instance of this Friend.
	 * @return The human readable string that represents this object.
	 */
	public String getAllInfoAsString()
	{
		String toReturn = "";
		
		toReturn += lastName + ", " + firstName + ":\n";
		toReturn += "\tBirth Date: " + birthDate + "\n";
		toReturn += "\tPhone Number: " + phoneNumber + "\n";
		toReturn += "\tEmail Address: " + emailAddress + "\n";
		toReturn += "\tAddress: " + address.getStreet() + "\n";
		toReturn += "\t\t" + address.getCity() + ", " + address.getState() + " " + address.getZip();
		
		return toReturn;
	}
}
