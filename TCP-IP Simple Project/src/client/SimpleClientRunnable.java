/*
NOTE: Please run a server runnable before running a client runnable
*/
package client;
import java.io.*;
import java.net.*;


public class SimpleClientRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Socket socket=new Socket("127.0.0.1",1501);
			DataInputStream inStream=new DataInputStream(socket.getInputStream());
			DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String clientMessage="",serverMessage="";
			while(!clientMessage.equals("/end/")){
				System.out.println("Enter message:");
				clientMessage=br.readLine();
				if (clientMessage.matches("-?\\d+")) {
					System.out.println("PING");
				};
				outStream.writeUTF(clientMessage);
				outStream.flush();
				serverMessage=inStream.readUTF();
				System.out.println(serverMessage);
			}
			outStream.close();
			socket.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
