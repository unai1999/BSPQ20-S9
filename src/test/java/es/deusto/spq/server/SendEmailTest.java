//package es.deusto.spq.server;
//
//import static org.junit.Assert.assertEquals;
//
//import javax.mail.SendFailedException;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class SendEmailTest {
//   
//   SendEmail se;
//   @Before
//   public void setUp(){
//
//       se = new SendEmail();
//   }
//
//   @Test
//   public void generateStringTest(){
//       String gs = SendEmail.generateString();
//       assertEquals(10, gs.length());
//   }
//
////    @Test(expected = javax.mail.SendFailedException.class)
////    public void enviarEmailTest(){
////        se.enviarMail("test");
////    }
//}