package app.web;

import app.entity.User;
import app.service.UserCommonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserCommonServiceImpl userCommonServiceImpl;

    @Test
    void allUsers() throws Exception {

        mockMvc.perform(get("/")
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("users"));
    }

    @Test
    void createUser() throws Exception {
        User user = new User("testMvc", "art@email.com");

        mockMvc.perform(get("/create")
                .param("id", "")
                .param("name", user.getName())
                .param("email", user.getEmail()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        User byId = userCommonServiceImpl.findById(1);
        assertEquals(byId.getName(), user.getName());

    }

    @Test
    void updateUser() throws Exception {
        User user = new User("testMvc", "testMvc@test.com");
        userCommonServiceImpl.create(user);
        assertEquals(1, userCommonServiceImpl.getAll().size());


        User updateUser = new User("update", "update@update.com");

        mockMvc.perform(get("/create")
                .param("id", String.valueOf(user.getId()))
                .param("name", updateUser.getName())
                .param("email", updateUser.getEmail()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        User byId = userCommonServiceImpl.findById(user.getId());
        assertEquals(byId.getName(), updateUser.getName());
    }

    @Test
    void deleteUser() throws Exception {
        User user = new User("test", "test@test.com");
        userCommonServiceImpl.create(user);
        assertEquals(1, userCommonServiceImpl.getAll().size());

        mockMvc.perform(get("/delete/{id}", user.getId()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        assertTrue(userCommonServiceImpl.getAll().isEmpty());
    }
}