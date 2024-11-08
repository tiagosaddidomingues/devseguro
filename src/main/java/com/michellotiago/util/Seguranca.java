package com.michellotiago.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Seguranca {
    // método para gerar hash MD5 é static para não precisar instanciar a classe Seguranca
    public static String hashMD5(String entrada) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytesString = md.digest(entrada.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : bytesString) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro ao gerar hash MD5");
            e.printStackTrace();
        }
        return null;
    }
}
