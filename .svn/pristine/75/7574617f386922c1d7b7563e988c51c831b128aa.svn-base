package ua.nure.lytovchenko.task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Part4 {
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        StringBuilder sb = new StringBuilder();
        for(byte b : hash){
            if(Integer.toHexString(b).length()==1){
                sb.append("0").append(Integer.toHexString(b).toUpperCase(Locale.US));
            }else {
                sb.append(Integer.toHexString(b).substring(Integer.toHexString(b).length() - 2).toUpperCase(Locale.US));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
    }
}