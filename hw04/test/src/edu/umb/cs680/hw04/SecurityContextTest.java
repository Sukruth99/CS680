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

    @Test
    public void testingLoggedInIsSingleton() {
        LoggedIn login1 = LoggedIn.getInstance(new SecurityContext(new User()));
        LoggedIn login2 = LoggedIn.getInstance(new SecurityContext(new User()));

        assertEquals(login1, login2);
    }

    @Test
    public void testLoggedOutAfterLoggedOut() {
        
        SecurityContext context = new SecurityContext(new User());

        context.login(new EncryptedString());

        context.logout();

        assertTrue(context.getState() instanceof  LoggedOut);
    }



}