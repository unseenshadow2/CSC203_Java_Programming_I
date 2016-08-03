package com.CSC203.Final_Project;

/**
 * This interface allows a class simple access to MQTT without
 * having to deal with little complexity. It is used with the
 * MessageSystem class's receiver public property.
 * 
 * @author Anthony Parsch Jr.
 */
public interface MessageSystemCallback 
{
	public void messageReceived(String message, String room, MessageSystem caller);
	public void disconnected();
}
