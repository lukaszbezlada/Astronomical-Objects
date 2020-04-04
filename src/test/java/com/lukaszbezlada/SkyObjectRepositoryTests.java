package com.lukaszbezlada;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.repository.SkyObjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SkyObjectRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SkyObjectRepository skyObjectRepository;

    @Test
    public void whenFindByNameContains_thenReturnSkyObject() {
        // given
        //User user = new User("user", "pass", "user", "user", "ggg@oo.pl", null , null);
        //userRepository.save(user);
        SkyObject skyObject = new SkyObject(1L, "firstObject", "22.10.2019", "patchImage", null);
        skyObjectRepository.save(skyObject);

        // when
        Optional<SkyObject> found = skyObjectRepository.findSkyObjectByNameContains("first");

        // then
        assertThat(found.get().getName())
                .isEqualTo(skyObject.getName());
    }
}
