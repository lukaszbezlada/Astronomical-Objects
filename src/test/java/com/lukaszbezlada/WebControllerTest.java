package com.lukaszbezlada;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.entity.MessierObject;
import com.lukaszbezlada.repository.MessierRepository;
import com.lukaszbezlada.service.SkyObjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MessierRepository messierRepository;

    @MockBean
    SkyObjectService skyObjectService;

    @Test
    public void shouldReturnIndexPage() throws Exception {
        mockMvc
                .perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user", new User()))
                .andExpect(view().name("index"));
    }

    @Test
    public void shouldReturnLoginPage() throws Exception {
        mockMvc
                .perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void shouldReturnMessierPage() throws Exception {
        ArrayList<MessierObject> emptyList = new ArrayList();
        when(messierRepository.readFile()).thenReturn(emptyList);
        mockMvc
                .perform(get("/messierdirectory"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("messierObjectAttribute"))
                .andExpect(model().attributeExists("messierListAttribute"))
                .andExpect(model().attribute("messierObjectAttribute", new MessierObject()))
                .andExpect(model().attribute("messierListAttribute", messierRepository.readFile()))
                .andExpect(view().name("messierdirectory"));

    }

    @Test
    public void shouldReturnRegistrationPage() throws Exception {
        mockMvc
                .perform(get("/registration"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user", new User()))
                .andExpect(view().name("registration"));
    }
//TODO testy dla zalogowanych i metody post
    @Test
    public void shouldReturnRegistrationPagePost() throws Exception {
        String name = "e_mail";
        mockMvc
                .perform(post("/registration"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attributeExists("e_mail"))
                .andExpect(model().attribute("user", new User()))
                .andExpect(model().attribute("e_mail", name))
                .andExpect(view().name("registration"));
    }

//    @Test
//    public void shouldReturnAccountPage() throws Exception {
//        mockMvc
//                .perform(get("/account"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("skyObject"))
//                .andExpect(model().attribute("skyObject", new SkyObject()))
//                .andExpect(view().name("account"));
//    }

//    @Test
//    public void shouldReturnSkyObjectsPage() throws Exception {
//        List<SkyObject> emptylist = new ArrayList<>();
//        when(skyObjectService.findUserSkyObjects()).thenReturn(emptylist);
//        mockMvc
//                .perform(get("/skyObjects"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("skyObjectUserList"))
//                .andExpect(model().attribute("skyObjectUserList", emptylist))
//                .andExpect(view().name("skyObjects"));
//    }

    @Test
    public void shouldReturnLoginPageAfterFailure() throws Exception {
        String failure = "Wprowadzono niepoprawne dane użytkownika";
        mockMvc
                .perform(get("/failure"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("failure"))
                .andExpect(model().attribute("failure", failure))
                .andExpect(view().name("login"));
    }


}
