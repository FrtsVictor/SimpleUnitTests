package com.test.controller.User;


import com.test.User.User;
import com.test.User.UserRepository;
import com.test.User.UserServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:test.properties")
public class UserServicesTests {

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    UserServices userServices;

    @Test
    public void shouldReturnFalseWhenEmailIsUnique() {
        Integer userId = null;
        String userEmail = "victor@gmail.com";
        User user = new User();
        Mockito.when(userRepository.findByEmail(userEmail)).thenReturn(null);

        boolean result = userServices.isUniqueEmailViolated(userId, userEmail);

        Assertions.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenEmailIsNotUnique() {
        Integer userId = null;
        String userEmail = "victor@gmail.com";

        User user = new User();
        user.setEmail(userEmail);
        user.setId(1);

        Mockito.when(userRepository.findByEmail(userEmail)).thenReturn(user);

        boolean result = userServices.isUniqueEmailViolated(userId, userEmail);

        Assertions.assertTrue(result);

    }

}
