package com.zendesk.ticket.viewer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void homepageControllerTest() throws Exception {
        this.mockMvc.perform(get("/tickets?per_page=25&page=1")
                        .header("Authorization", "Basic base64"))
                .andExpect(content().string("{\"data\":\"{\\\"error\\\":\\\"Couldn't authenticate you\\\"}\",\"status\":401}"));
    }

    @Test
    public void TicketControllerTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

}
