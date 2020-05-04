package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;

import org.junit.Test;

public class SecurityUtilsTest {
    SecurityUtils su;

    @Before
    public void setUp() {
        
    }

    @Test
    public void getSaltTest() {
        
        try {
            byte[] salt = SecurityUtils.getSalt();
            assertTrue(salt!=null);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void get_SHA_256_SecurePasswordTest() throws NoSuchAlgorithmException {

        String password = "eyey";
        byte[] salt = SecurityUtils.getSalt();
        String sp = SecurityUtils.get_SHA_256_SecurePassword(password, salt);

        assertEquals(sp, SecurityUtils.get_SHA_256_SecurePassword("eyey", salt));

    }

    @Test
    public void validatePasswordTest() throws NoSuchAlgorithmException {
        byte[] salt = SecurityUtils.getSalt();
        String p1 = "eyey";
        String p2 = SecurityUtils.get_SHA_256_SecurePassword(p1, salt);

        assertTrue(SecurityUtils.validatePassword(p1, p2, salt));
        
    }
}