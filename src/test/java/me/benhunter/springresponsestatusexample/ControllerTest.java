package me.benhunter.springresponsestatusexample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ControllerTest {

    @Autowired
    MockMvc mvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void respondsWithBadRequest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .content("BAD CONTENT");
        this.mvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    @Test
    void controllerRespondsWithOk() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }
}
