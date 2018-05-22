package server;
import java.io.*;
import java.net.*;


public class SimpleServerRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 
		 * REFERENCE: https://systembash.com/a-simple-java-tcp-server-and-tcp-client/ 
		 * 
		 * 
		 * */
		
		
		//Error-catching BLOCK
		try {
			//creating server socket 
			ServerSocket serverSocket = new ServerSocket(1500);
			System.out.println("SERVER ONLINE.");
			String receivedMessage;
			String sentMessage;
			
			while (true) {		
				Socket connection = serverSocket.accept();
				BufferedReader inFromClient = new BufferedReader(
							  new InputStreamReader(connection.getInputStream()));
				DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());
				receivedMessage = inFromClient.readLine();
				System.out.println("Received from Client 1: " + receivedMessage);
	
	//this block is for the processing 
							  
				sentMessage = receivedMessage + '\n';
						  
				outToClient.writeBytes(sentMessage);
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
