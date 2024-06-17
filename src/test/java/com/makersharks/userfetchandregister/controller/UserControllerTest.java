package com.makersharks.userfetchandregister.controller;

import com.makersharks.userfetchandregister.model.User;
import com.makersharks.userfetchandregister.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testRegisterUserSuccess() throws Exception {
        User user = new User("john", "john@example.com", "password", "", "");

        mockMvc.perform(post("/api/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"john\", \"email\":\"john@example.com\", \"password\":\"password\", \"firstName\":\"John\", \"lastName\":\"Sanders\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("User registered successfully"));
    }

    @Test
    public void testRegisterUserFailure() throws Exception {
        when(userService.registerUser(any(User.class))).thenThrow(new RuntimeException());

        mockMvc.perform(post("/api/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"john\", \"email\":\"john@example.com\", \"password\":\"password\", \"firstName\":\"John\", \"lastName\":\"Sanders\"}"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("User registration failed"));
    }

    @Test
    public void testFetchUserSuccess() throws Exception {
        User user = new User("john", "john@example.com", "password", "", "");
        when(userService.fetchUserByUsername("john")).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/user/fetch")
                        .param("username", "john"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("john"))
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }

    @Test
    public void testFetchUserNotFound() throws Exception {
        when(userService.fetchUserByUsername("john")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/user/fetch")
                        .param("username", "john"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }
}
