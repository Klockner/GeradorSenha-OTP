/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicativo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Gabriel
 */
public class GeradorOTP {
    private long hashSementeLong;
    private static long SALT = 193867;
    public long[] listaTokens;
    public int minutes;
    
    public void lerHashSemente() {
        try {
            FileReader arq = new FileReader("HashSemente.txt");
            BufferedReader lerArq = new BufferedReader(arq); 
            String linha = lerArq.readLine();
            hashSementeLong = Long.valueOf(linha);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Fórmula token
    //((hashSemente + SALT) * minutes) + i
    public void gerarTokens() {
        long time = System.currentTimeMillis();
        int seconds = (int) (time / 1000) % 60 ;
        minutes = (int) ((time / (1000*60)) % 60);
        
        listaTokens = new long[5];
        for (int i = 0; i < 5; i++) {
            listaTokens[i] = ((hashSementeLong + SALT) * minutes) + i;
            System.out.println(listaTokens[i]);
        }
    }
    
    public boolean validaToken(String token) {
        long tokenLong = Long.valueOf(token);
        for (int i = 0; i < 5; i++) {
            if (tokenLong == listaTokens[i]) {
                return true;
            }
        }
        return false;
    }
}
