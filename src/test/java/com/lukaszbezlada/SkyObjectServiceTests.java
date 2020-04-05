package com.lukaszbezlada;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.repository.SkyObjectRepository;
import com.lukaszbezlada.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SkyObjectServiceTests {

    @Autowired
    SkyObjectRepository skyObjectRepository;

    @Autowired
    UserRepository userRepository;

    private SkyObject skyObject;

    @Before
    public void setUp() {
        User user1 = new User("userLogin", "pass", "user", "user", "ggg@oo.pl", null, null);
        userRepository.save(user1);
        skyObject = new SkyObject(1L, "firstObject", "22.10.2019", "path", user1);
        skyObjectRepository.save(skyObject);
    }

    @Test
    public void whenAddSkyObject_thenReturnSkyObject() {
        //when
        List<SkyObject> found = skyObjectRepository.findAll();
        int liczba = found.size();

        //then
        assertThat(found.get(0).getName()).isEqualTo(skyObject.getName());
    }

    @Test
    public void whenFindUserSkyObject_thenReturnSkyObject() {
        //when
        long userId = 1L;
        List<SkyObject> found = skyObjectRepository.findSkyObjectsByUserId(userId);

        //then
        assertThat(found.get(0).getUser().getUser_id()).isEqualTo(userId);
        assertThat(found.get(0)).isEqualTo(skyObject);
    }
}
