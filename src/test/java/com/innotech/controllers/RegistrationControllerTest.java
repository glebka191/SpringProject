package com.innotech.controllers;

import com.innotech.entity.Role;
import com.innotech.entity.User;
import com.innotech.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationControllerTest {

    UserService userServiceMock = Mockito.mock(UserService.class);

    @Test
    public void addUser() {
        User userTest = new User();
        userTest.setRoles(Collections.singleton(Role.ADMIN));
        userTest.setUsername("newUser");
        userTest.setPassword("1234");

        Mockito.when(userServiceMock.addUser(userTest)).thenReturn(true);
    }
}