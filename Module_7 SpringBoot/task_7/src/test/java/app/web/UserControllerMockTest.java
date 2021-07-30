package app.web;

import app.entity.User;
import app.service.UserCommonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = UserController.class)
class UserControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserCommonServiceImpl userCommonServiceImpl;

    @Test
    void allUsers() throws Exception {
        List<User> users = Collections.singletonList(
                new User("testMvc", "testMvc@test.com"));
        when(userCommonServiceImpl.getAll()).thenReturn(users);

        mockMvc.perform(get("/")
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("users"));
    }

    @Test
    void createUser() throws Exception {
        User user = new User("testMvc", "testMvc@test.com");

        mockMvc.perform(get("/create")
                .param("id", "")
                .param("name", user.getName())
                .param("email", user.getEmail()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        verify(userCommonServiceImpl, times(1)).create(user);
    }

    @Test
    void updateUser() throws Exception {
        User user = new User("testMvc", "testMvc@test.com");
        when(userCommonServiceImpl.findById(any(Long.class))).thenReturn(user);


        User updateUser = new User("update", "update@update.com");

        mockMvc.perform(get("/create")
                .param("id", String.valueOf(user.getId()))
                .param("name", updateUser.getName())
                .param("email", updateUser.getEmail()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        verify(userCommonServiceImpl, times(1)).create(updateUser);
    }

    @Test
    void deleteUser() throws Exception {
        int userId = 1;

        mockMvc.perform(get("/delete/{id}", userId))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        verify(userCommonServiceImpl, times(1)).delete(userId);
    }
}