
package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class AuthControllerTest {

    private MockMvc mockMvc;
    private AuthService authService;
    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        authService = Mockito.mock(AuthService.class);
        AuthController controller = new AuthController(authService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void loginReturns200WhenServiceAccepts() throws Exception {
        Mockito.when(authService.login(anyString(), anyString())).thenReturn(true);

        LoginRequest req = new LoginRequest();
        req.setUsername("user");
        req.setPassword("pass");

        mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    public void loginReturns401WhenServiceRejects() throws Exception {
        Mockito.when(authService.login(anyString(), anyString())).thenReturn(false);

        LoginRequest req = new LoginRequest();
        req.setUsername("user");
        req.setPassword("wrong");

        mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(req)))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.success").value(false));
    }
}
