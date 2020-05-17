package es.deusto.spq.server;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.io.*;

public class SecurityUtils {

    // Add salt
    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String passwordToHash = "password";
        byte[] salt = getSalt();

        String securePassword = get_SHA_256_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);

        if(validatePassword(passwordToHash,securePassword, salt)){
        System.out.println("yey");
        }else{
        System.out.println("nay");
        }

    }

    public static String get_SHA_256_SecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static boolean validatePassword(String p1, String p2, byte[] salt) throws NoSuchAlgorithmException {

        String securePassword = get_SHA_256_SecurePassword(p1, salt);

        if (securePassword.equals(p2))
            return true;
        else
            return false;
    }

    public static byte[] getStoredSalt() throws IOException {
    
      InputStream is = null;
      byte[] buffer = new byte[16];
      char c;
      
      try {
         // new input stream created
         is = new FileInputStream("salt.txt");
         
         // read stream data into buffer
         is.read(buffer, 2, 3);
         
         // for each byte in the buffer
         for(byte b:buffer) {
         
            // convert byte to character
            if(b == 0)
               
               // if b is empty
               c = '-';
            else
               
               // if b is read
               c = (char)b;


         }
         
      } catch(Exception e) {
         // if any I/O error occurs
         e.printStackTrace();
      } finally {
         // releases system resources associated with this stream
         if(is!=null)
            is.close();
      }
      return buffer;
    }

    public static void writeSalt() throws IOException, NoSuchAlgorithmException {

        try (FileOutputStream fos = new FileOutputStream("salt.txt")) {
            fos.write(getSalt());
         }
    }
    
}