// package es.deusto.spq.server;

// import java.io.FileInputStream;
// import java.io.IOException;
// import java.io.InputStream;
// import java.util.Properties;
// import java.util.Random;

// import javax.mail.Message;
// import javax.mail.MessagingException;
// import javax.mail.PasswordAuthentication;
// import javax.mail.Session;
// import javax.mail.Transport;
// import javax.mail.internet.InternetAddress;
// import javax.mail.internet.MimeMessage;

// public class SendEmail {

//     String address;
//     String password;

//     public String enviarMail(String destination){
 
//         try (InputStream input = new FileInputStream("src/main/resources/gmail.properties")) {

//             Properties prop = new Properties();

//             // load a properties file
//             prop.load(input);

//             // get the property value and print it out
//             address = (prop.getProperty("gmail.address"));
//             password = (prop.getProperty("gmail.password"));


//         } catch (IOException ex) {
//             ex.printStackTrace();
//         }
//         String code = generateString();
//          // Recipient's email ID needs to be mentioned.
//          String to = destination;

//          // Sender's email ID needs to be mentioned
//          String from = address;
 
//          // Assuming you are sending email from through gmails smtp
//          String host = "smtp.gmail.com";
 
//          // Get system properties
//          Properties properties = System.getProperties();
 
//          // Setup mail server
//          properties.put("mail.smtp.host", host);
//          properties.put("mail.smtp.port", "465");
//          properties.put("mail.smtp.ssl.enable", "true");
//          properties.put("mail.smtp.auth", "true");
 
//          // Get the Session object.// and pass username and password
//          Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
 
//              protected PasswordAuthentication getPasswordAuthentication() {
 
//                  return new PasswordAuthentication(address, password);
 
//              }
 
//          });
 
//          // Used to debug SMTP issues
//          session.setDebug(true);
 
//          try {
//              // Create a default MimeMessage object.
//              MimeMessage message = new MimeMessage(session);
 
//              // Set From: header field of the header.
//              message.setFrom(new InternetAddress(from));
 
//              // Set To: header field of the header.
//              message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
 
//              // Set Subject: header field
//              message.setSubject("Recuperación de contraseña");
 
//              // Now set the actual message
//              message.setText("Código de recuperación de contraseña: "+ code);
 
//              System.out.println("sending...");
//              // Send message
//              Transport.send(message);
//              System.out.println("Sent message successfully....");
//          } catch (MessagingException mex) {
//              mex.printStackTrace();
//          }
 
//          return code;
 
//     }

//     public String generateString(){

//         int leftLimit = 48; // numeral '0'
//         int rightLimit = 122; // letter 'z'
//         int targetStringLength = 10;
//         Random random = new Random();
 
//         String generatedString = random.ints(leftLimit, rightLimit + 1)
//             .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
//             .limit(targetStringLength)
//             .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//             .toString();

//          return generatedString;
//     }
// }