package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SendEmailTest {
   
   SendEmail se;

   
   @Before
   public void setUp(){

       se = new SendEmail();
   }

   @Test
   public void generateStringTest(){
       String gs = SendEmail.generateString();
       assertEquals(10, gs.length());
   }

   @Ignore
   @Test(expected = javax.mail.AuthenticationFailedException.class)
   public void enviarEmailTest(){
       se.enviarMail("test");
   }
}