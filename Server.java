package practice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {
	
	public static void main(String[] args)
	{
		ServerSocket serverSocket = null;
		Socket socket = null;
		InetAddress inetAddress = null;
		BufferedReader br = null;
		InputStream is = null;
		OutputStream os = null;
		PrintWriter pw = null;
		int port = 5503;
		String receiveMsg = null;
		
		try{
			
			serverSocket = new ServerSocket(port);
			System.out.println("Waiting for connection...");
 
			socket = serverSocket.accept();
			inetAddress = socket.getInetAddress();	
			
			System.out.println(inetAddress.getHostAddress() + " is connected");
			
			is = socket.getInputStream();
			os = socket.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(os));
			br = new BufferedReader(new InputStreamReader(is));
			
			while((receiveMsg = br.readLine())!=null)
			{
				pw.println(receiveMsg);
				pw.flush(); // empty buffer
			}
			
			pw.close(); // close stream
			br.close(); // close buffer
			socket.close(); // close socket
			 
		}
	 catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

 
	
}
