package es.deusto.spq.server;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.io.*;

/**
* Clase con métodos útiles para la gestión de seguridad de datos
* @author Kike00
* @see <a href = "https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/">Almacenar contraseñas de forma segura en Java</a>
* 
*/
public class SecurityUtils {

     /**
     * Método que genera un array de bytes que forman el 'Salt' 
     * 'Salt' comprende bits aleatorios que se usan como una de las entradas en una función derivadora de claves
     * @return array de bytes que forman el 'Salt'
     */
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

     /**
     * Método que genera un hash tipo SHA 256 del string deseado
     * @param passwordToHash contraseña que se desea hashear
     * @param salt 'salt' usada para la generación del hash
     * 
     * @return hash de la contraseña indicada
     *
     */
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

     /**
     * Método que genera un hash tipo SHA 256 del string deseado
     * @param p1 contraseña 1 que se desea validar
     * @param p2 contraseña 2 que se desea validar 
     * @param salt 'salt' usada para la generación del hash
     * 
     * @return true si las contraseñas coinciden, false si no.
     *
     */
    public static boolean validatePassword(String p1, String p2, byte[] salt) throws NoSuchAlgorithmException {

        String securePassword = get_SHA_256_SecurePassword(p1, salt);

        if (securePassword.equals(p2))
            return true;
        else
            return false;
    }

     /**
     * Método que devuelve el 'salt' que peretenece al usuario
     * 
     * @return array de bytes que contiene el 'salt' guardado
     *
     */
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

     /**
     * Método que guarda un 'salt' aleatorio personal del usuario
     * Escribe los datos en el fichero salt.txt situado en la raiz del proyecto
     */
    public static void writeSalt() throws IOException, NoSuchAlgorithmException {

        try (FileOutputStream fos = new FileOutputStream("salt.txt")) {
            fos.write(getSalt());
         }
    }
    
}