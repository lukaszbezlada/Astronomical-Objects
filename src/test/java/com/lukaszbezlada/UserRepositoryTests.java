package com.lukaszbezlada;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void whenFindByLogin_thenReturnUser() {
        //given
        User user = new User("user", "pass", "userName", "userLName", "ggg@oo.pl", null, null);
        userRepository.save(user);

        //when
        User found = userRepository.findByLogin("user");

        //then
        assertThat(found).isEqualTo(user);

    }

}
