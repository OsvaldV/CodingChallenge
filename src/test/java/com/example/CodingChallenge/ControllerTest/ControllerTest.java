package com.example.CodingChallenge.ControllerTest;

import com.example.CodingChallenge.controller.UserController;
import com.example.CodingChallenge.model.User;
import com.example.CodingChallenge.repository.UserRepository;
import com.example.CodingChallenge.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.websocket.servlet.UndertowWebSocketServletWebServerCustomizer;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ControllerTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserService userService;

    @Test
    public void whenCreate() {
        //given
        User user = new User();
        user.setFirstName("Osvaldo");
        user.setLastName("Valdiviezo");
        user.setDateOfBirth("14021982");
        entityManager.persist(user);
        entityManager.flush();

        User seconduser = new User();
        seconduser.setFirstName("Osvaldo");
        seconduser.setLastName("Valdiviezo");
        seconduser.setDateOfBirth("14021982");
        entityManager.persist(seconduser);
        entityManager.flush();

        //when
        List users;
        users = userService.getAllUsers();

        //then
      //  assertThat(users.size()).isEqualTo(2);

    }
}




