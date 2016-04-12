/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeradorSenha;

import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class GeradorOTP {
    private static long SALT = 193867;
    public long[] listaTokens;
    
    // Fórmula token
    //(hashSemente + SALT) * i
    public void gerarTokens(int hashSemente) {
        long hashSementeLong = new Long(hashSemente);
        long time = System.currentTimeMillis();
        int seconds = (int) (time / 1000) % 60 ;
        int minutes = (int) ((time / (1000*60)) % 60);
        
        listaTokens = new long[5];
        for (int i = 0; i < 5; i++) {
            listaTokens[i] = ((hashSementeLong + SALT) * minutes) + i;
            System.out.println(listaTokens[i]);
        }
    }
    
    public String getToken() {
        Random rand = new Random();
        return String.valueOf(listaTokens[rand.nextInt(5)]);
    }
}
