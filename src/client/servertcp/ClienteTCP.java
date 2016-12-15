package client.servertcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RICHARD
 */
public class ClienteTCP {


    /**
     * Trivial TCP client.
     */
    private static int SERVER_PORT = 9090;

    /**
     * Runs the client as an application. First it displays a dialog box asking
     * for the IP address or hostname of a host running the server, then
     * connects to it and displays the message that it serves.
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        String serverAddress = JOptionPane.showInputDialog("Enter IP Address of a machine that is\n" + "running the date service on port " + SERVER_PORT + ":");

        String suma = JOptionPane.showInputDialog("Ingrese la suma");
        //Establece la conexión con el servidor mediante un socket
        Socket clientSocket = new Socket(serverAddress, SERVER_PORT);

        //Obtiene el mensaje enviado por el servidor a través del socket
        InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());

        //Lee los datos del mensaje
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream out;
        out = new DataOutputStream(clientSocket.getOutputStream());

        out.writeUTF(suma);

        String answer = input.readLine();

        //Imprime los datos del mensaje
        JOptionPane.showMessageDialog(null, answer);

        //PrintWriter out = new PrintWriter (clientSocket.getOutputStream(), true);
        //out.println("1+2");
        System.exit(0);
    }

}
