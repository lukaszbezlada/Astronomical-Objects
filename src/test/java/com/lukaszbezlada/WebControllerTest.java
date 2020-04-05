package com.lukaszbezlada;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.utils.MessierObject;
import com.lukaszbezlada.utils.MessierService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MessierService messierService;

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
        when(messierService.readFile()).thenReturn(emptyList);
        mockMvc
                .perform(get("/messierdirectory"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("messierObjectAttribute"))
                .andExpect(model().attributeExists("messierListAttribute"))
                .andExpect(model().attribute("messierObjectAttribute", new MessierObject()))
                .andExpect(model().attribute("messierListAttribute", messierService.readFile()))
                .andExpect(view().name("messierdirectory"));

    }
}

//
//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("user", new User());
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String registrationWithEmail(@RequestParam(name = "e_mail") String e_mail, Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("e_mail", e_mail);
//        return "registration";
//    }
//
//    @RequestMapping("/account")
//    public String account(Model model) {
//        model.addAttribute("skyObject", new SkyObject());
//        return "account";
//    }
//
//    @GetMapping("/skyobjects")
//    public String skyobjects(Model model) {
//        model.addAttribute("skyObjectUserList", skyObjectService.findUserSkyObjects());
//        return "skyobjects";
//    }
//
//    @RequestMapping("/admin")
//    public String admin() {
//        return "admin";
//    }
//
//
//    @RequestMapping("/failure")
//    public String failure(Model model) {
//        model.addAttribute("failure", "Wprowadzono niepoprawne dane użytkownika");
//        return "login";
//    }