package com.CSC203.Final_Project;

import java.io.IOException;

import org.eclipse.paho.client.mqttv3.MqttException;

public class Main implements MessageSystemCallback
{
	public static MessageSystem msgSys = new MessageSystem();

	public static void main(String[] args) 
	{
		System.out.println("Beginning program");
		
		// Testing function
		try 
		{
			// Connect and setup to receive the data
			msgSys.connect();
			msgSys.receiver = new Main();
			System.out.println("Connection Successful");
			
			// Receive messages from the default room
			msgSys.sendMessage("This is a message...");
			System.out.println("Message Sent");
			System.in.read();
			System.in.skip(20);
			
			// Change to the Second Room
			System.out.println("Changing room to Second Room");
			msgSys.updateRoom("Second Room");
			System.in.read();
			
			// Close and disconnect
			msgSys.close();
			System.out.println("Closing Message System");
		}
		catch (MqttException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
		System.out.println("Ending program");		
	}

	@Override
	public void messageReceived(String message, String room, MessageSystem caller) 
	{
		System.out.println("\nMain recieved a message in the room \"" + room + "\"");		
		System.out.println("The message is \"" + message + "\"\n");
	}

	@Override
	public void disconnected() 
	{
		System.out.println("Main disconnected...");
	}
}
