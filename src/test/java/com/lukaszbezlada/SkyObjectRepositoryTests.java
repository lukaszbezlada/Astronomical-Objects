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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SkyObjectRepositoryTests {

    @Autowired
    private SkyObjectRepository skyObjectRepository;

    @Autowired
    private UserRepository userRepository;

    private SkyObject skyObject;

    @Before
    public void createRepository() {
        //given
        User user1 = new User("user", "pass", "user", "user", "ggg@oo.pl", null , null);
        User user2 = new User("user2", "pass", "user2", "user2", "ggg@oo.pl", null , null);
        userRepository.save(user1);
        userRepository.save(user2);
        skyObject = new SkyObject(1L, "firstObject", "22.10.2019", "patchImage", user2);
        skyObjectRepository.save(skyObject);
    }

    @Test
    public void whenFindByNameContains_thenReturnSkyObject() {
        // when
        Optional<SkyObject> found = skyObjectRepository.findSkyObjectByNameContains("first");

        // then
        assertThat(found.get().getName())
                .isEqualTo(skyObject.getName());
    }

    @Test
    public void whenFindByUserId_thenReturnSkyObject() {
        //when
        List<SkyObject> found = skyObjectRepository.findSkyObjectsByUserId(2L);

        //then
        assertThat(found.get(0).getName()).isEqualTo(skyObject.getName());

    }

    @Test
    public void whenDeleteByName_thenListIsEmpty() {
        //when
        skyObjectRepository.deleteSkyObjectByName("firstObject");

        //then
        List<SkyObject> skyObjectList = skyObjectRepository.findAll();
        assertEquals(0, skyObjectList.size());
    }

}
