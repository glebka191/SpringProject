package com.innotech.service;

import com.innotech.entity.User;
import com.innotech.repo.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    UserRepo userRepoMock = Mockito.mock(UserRepo.class);

    @Test
    public void addUser() {
        User userTest = new User();
        userTest.setUsername("admin");
        userTest.setPassword("1234");

        Mockito.doReturn(userTest)
                .when(userRepoMock)
                .findByUsername("admin");
    }
}