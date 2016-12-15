package client.servertcp;


import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package client.servertcp;


/**
 *
 * @author RICHARD
 */
public class ServerTCP {
    


/**cmd
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client a message, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
	private static int PORT = 9090;
	
  
    public static void main(String[] args) throws IOException {
        
    	ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server listening on port "+PORT);
        
        try {
            while (true) {
                    
                Socket socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                
                //Cada string està separado por el +
                StringTokenizer tokens = new StringTokenizer(in.readUTF(), "+");
                int a= Integer.parseInt(tokens.nextToken());
                int b= Integer.parseInt(tokens.nextToken());
                int suma = a + b ;
                
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("La suma de los dos números es: " + suma); 
                
            }
                } finally {
                    serverSocket.close();
                }
              
        }
    }
    
 