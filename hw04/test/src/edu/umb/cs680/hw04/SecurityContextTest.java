package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityContextTest {

    @Test
    public void testingLoggedOutIsSingleton() {

        LoggedOut logout1 = LoggedOut.getInstance(new SecurityContext(new User()));
        LoggedOut logout2 = LoggedOut.getInstance(new SecurityContext(new User()));

        assertEquals(logout1, logout2);
    }

    @Test
    public void loginLogoutTest() {
        
        SecurityContext context = new SecurityContext(new User());

        assertTrue(context.getState() instanceof LoggedOut);

        context.login(new EncryptedString());

        assertTrue(context.getState() instanceof  LoggedIn);
    }




}