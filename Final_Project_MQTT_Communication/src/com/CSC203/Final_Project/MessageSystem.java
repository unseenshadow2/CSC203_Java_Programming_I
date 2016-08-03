package com.CSC203.Final_Project;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/**
 * This class handles the connecting to the MQTT broker and then facilitating the delivery
 * of messages as well as the handling of rooms. There is no form of persistence among the
 * messages. 
 * 
 * @author Anthony Parsch Jr.
 */
public class MessageSystem implements MqttCallback
{
	// Public Variables
	public MessageSystemCallback receiver = null;
	
	// Protected Variables
	
	// Private Variables	
	private String broker = "tcp://192.168.2.6:1883";
	private int qos = 2;
	private MqttClient client;
	private String room = "default room";
	private final String ip_filepath = ".broker_address";
	
	/**
	 * Connect to the central service...
	 * 
	 * @throws MqttException
	 * @throws IOException 
	 */
	public void connect() throws MqttException, IOException
	{
		// Check for the file containing the broker ip
		File f = new File(ip_filepath);
		
		if (f.isFile())
		{
			List<String> ip = Files.readAllLines(f.toPath());
			
			broker = "tcp://" + ip.get(0) + ":1883";
		}
		else
		{
			Files.write(f.toPath(), ("192.168.2.6").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
		}
		
		// Set up our broker
		client = new MqttClient(broker, MqttClient.generateClientId());
		client.setCallback(this);
		
		// Set up our connection options
		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		connOpts.setConnectionTimeout(30);
		
		// Connect
		client.connect(connOpts);
		
		if (client.isConnected())
		{
			client.subscribe(room, qos);
		}
	}
	
	
	/**
	 * Send a message to your current room
	 * 
	 * @param message The message that you wish to send
	 * @throws MqttException 
	 * @throws MqttPersistenceException 
	 */
	public void sendMessage(String message) throws MqttPersistenceException, MqttException
	{
		MqttMessage msg = new MqttMessage(message.getBytes());
		msg.setQos(qos);
		client.publish(room, msg);
	}
	
	public String getRoom() { return room; }
	
	/**
	 * Updates the room that the user is currently in
	 * 
	 * @param newRoom The new room for the user to be in
	 * @throws MqttException
	 */
	public void updateRoom(String newRoom) throws MqttException
	{
		if ((client != null) && client.isConnected())
		{
			client.unsubscribe(room);
			client.subscribe(newRoom, qos);
		}
		
		room = newRoom;
	}
	
	/**
	 * Close the message system and disconnect
	 * 
	 * @throws MqttException
	 */
	public void close() throws MqttException
	{
		if (client != null) { client.disconnect(); }
	}


	@Override
	public void connectionLost(Throwable arg0) 
	{
		try 
		{
			client.reconnect();
		} 
		catch (MqttException e) 
		{
			e.printStackTrace();
		}
		
		if (receiver != null)
		{
			receiver.disconnected();
		}
	}


	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) 
	{
		
	}


	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception 
	{
		if (receiver != null)
		{
			receiver.messageReceived(new String(message.getPayload()), topic, this);
		}
	}
}