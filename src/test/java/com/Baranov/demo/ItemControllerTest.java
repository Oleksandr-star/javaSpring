package com.Baranov.demo;

import com.Baranov.demo.fleamarket.config.SecurityConfig;
import com.Baranov.demo.fleamarket.controller.ItemController;
import com.Baranov.demo.fleamarket.security.JwtAuthenticationFilter;
import com.Baranov.demo.fleamarket.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
@Import(SecurityConfig.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @MockBean
    private JwtAuthenticationFilter jwtFilter;

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeleteItem_AdminAccess() throws Exception {
        doNothing().when(itemService).deleteById("123");
        mockMvc.perform(delete("/items/123"))
                .andExpect(status().is3xxRedirection());
        verify(itemService).deleteById("123");
    }
}
