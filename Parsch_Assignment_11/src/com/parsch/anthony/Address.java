package com.parsch.anthony;

/**
 * A quick data storage class to represent an address.
 * @author unseenshadow2
 *
 */
public class Address 
{
	// Public Variables
	
	// Protected Variables
	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	
	// Private Variables
	
	// Getter and Setter for street
	public String getStreet()
	{
		return street;
	}
	
	public void setStreet(String newStreet)
	{
		street = newStreet;
	}
	
	// Getter and Setter for city
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String newCity)
	{
		city = newCity;
	}
	
	// Getter and Setter for state
	public String getState()
	{
		return state;
	}
	
	public void setState(String newState)
	{
		state = newState;
	}
	
	// Getter and Setter for zip(code)
	public String getZip()
	{
		return zip;
	}
	
	public void setZip(String newZip)
	{
		zip = newZip;
	}
}
