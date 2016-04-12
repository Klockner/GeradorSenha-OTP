/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicativo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Server {
    public Server(int porta) {
        try {
            ServerSocket server = new ServerSocket(porta);
            System.out.println("Servidor aberto na porta " + porta);
            Socket client = server.accept();
            System.out.println("Nova conexão com o cliente " + client.getInetAddress().getHostAddress());
            
            Scanner s = new Scanner(client.getInputStream());
            while (s.hasNextLine()) {
              System.out.println(s.nextLine());
            }

            s.close();
            server.close();
            client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
