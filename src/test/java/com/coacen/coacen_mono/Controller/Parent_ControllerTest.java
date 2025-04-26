package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.Parent;
import com.coacen.coacen_mono.Service.Parent_Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Parent_Controller.class)
class Parent_ControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Parent_Service parentService;

    private Parent parent;

    @BeforeEach
    public void setup()
    {
        parent= Parent.builder()
                .parent_first_name("Ramesh")
                .parent_last_name("Aravind")
                .parent_email("ramesh@gmail.com")
                .parent_mobile("1234567890")
                .build();
    }

    @Test
    public void save_Department() throws Exception {
        Parent inpparent= Parent.builder()
                .parent_first_name("Ramesh")
                .parent_last_name("Aravind")
                .parent_email("ramesh@gmail.com")
                .parent_mobile("1234567890")
                .build();
        Mockito.when(parentService.create_parent(inpparent)).thenReturn(parent);
        mockMvc.perform(post("/create_parent").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"parent_first_name\": \"Rameshwara\",\n" +
                        "   \"parent_last_name\": \"Reddy\",\n" +
                        "   \"parent_email\":\"rameshwara@gmail.com\",\n" +
                        "   \"parent_mobile\":\"1234567890\"\n" +
                        "}"));
    }
}