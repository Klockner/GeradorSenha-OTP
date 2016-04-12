/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeradorSenha;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Conexao {
    public Socket client;
    
    public Conexao(String ip, int porta) {
        try (Socket client = new Socket(ip, porta)) {
            System.out.println("Cliente conectado ao servidor!");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void enviarGerarParaServidor(String nome, String senha) {
        try (PrintStream saida = new PrintStream(client.getOutputStream())) {
                
            saida.println(nome);
            saida.println(senha);
                
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
