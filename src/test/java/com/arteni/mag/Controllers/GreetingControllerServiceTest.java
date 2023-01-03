package com.arteni.mag.Controllers;

import com.arteni.mag.dao.CardPaymentRepositoryDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
public class GreetingControllerServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardPaymentRepositoryDAO cardPaymentRepositoryDAO;


    @Test
    public void pingShouldReturnPongMessageFromController() throws Exception {
        this.mockMvc.perform(get("/ping")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("pong")));
    }
    @Test
    public void findPaymentByIdShouldReturnVISA() throws Exception {
        this.mockMvc.perform(get("/test/payment/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("VISA")));
    }
}