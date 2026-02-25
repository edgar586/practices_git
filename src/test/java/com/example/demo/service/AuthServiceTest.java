
package com.example.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    private final AuthService authService = new AuthServiceImpl();

    @Test
    public void loginSucceedsWithCorrectCredentials() {
        assertTrue(authService.login("user", "pass"));
    }

    @Test
    public void loginFailsWithWrongCredentials() {
        assertFalse(authService.login("user", "wrong"));
    }
}
