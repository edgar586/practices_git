
package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public boolean login(String username, String password) {
        // Simple mock logic: correct credentials are user / pass
        return "user".equals(username) && "pass".equals(password);
    }
}
