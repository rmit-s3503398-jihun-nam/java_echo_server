package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) throws IOException
	{
	    Socket socket = null;
	    String IP = "127.0.0.1";
	    int port = 5503;
	    BufferedReader insert = null;
		BufferedReader br = null;
		InputStream is = null;
		OutputStream os = null;
		PrintWriter pw = null;
		String sendMsg = null;
		String echo = null;
		InetAddress inetAddress = null;

		try{
			
			socket = new Socket(IP,port);
			insert = new BufferedReader(new InputStreamReader(System.in));
			os = socket.getOutputStream();
			is = socket.getInputStream();
			pw = new PrintWriter(new OutputStreamWriter(os));
			br = new BufferedReader(new InputStreamReader(is));
			
			System.out.println("[Local Address is :" + InetAddress.getLocalHost() + "]");
			System.out.println("[Port Number is :" + port + "]");
			
			System.out.println("Server Connected");
 
			while((sendMsg = insert.readLine())!=null)
			{
				pw.println(sendMsg);
				pw.flush();
				echo = br.readLine();
				System.out.println("From Server: " + echo);		
				
				if(echo.equals("X"))
				{
					System.out.println("Client close connection");
					break;
				}
			
			}
			
			pw.close();
			br.close();
			socket.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
