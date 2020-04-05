package com.lukaszbezlada;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.repository.SkyObjectRepository;
import com.lukaszbezlada.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SkyObjectServiceTests {

    @MockBean
    SkyObjectRepository skyObjectRepository;

    @Autowired
    UserRepository userRepository;

    private SkyObject skyObject;

    @Before
    public void setUp() {
        User user1 = new User("userLogin", "pass", "user", "user", "ggg@oo.pl", null, null);
        userRepository.save(user1);
        skyObject = new SkyObject(1L, "firstObject", "22.10.2019", "path", user1);
        List<SkyObject> skyObjectList = new ArrayList<>();
        skyObjectList.add(skyObject);
        Mockito.when(skyObjectRepository.findSkyObjectsByUserId(user1.getUser_id())).thenReturn(skyObjectList);
    }

    @Test
    public void whenAddSkyObject_thenReturnSkyObject() {
        //when
        skyObjectRepository.save(skyObject);
        List<SkyObject> found = skyObjectRepository.findAll();

        //then
        assertThat(found.get(0)).isEqualTo(skyObject);
    }

    @Test
    public void whenFindUserSkyObject_thenReturnSkyObject() {
        //when
        long userId = 1L;
        List<SkyObject> found = skyObjectRepository.findSkyObjectsByUserId(userId);

        //then
        assertThat(found.get(0).getUser().getUser_id()).isEqualTo(userId);

    }
}
