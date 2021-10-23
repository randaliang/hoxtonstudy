package aspect.controller;

import aspect.SampleAopApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
public class LogControllerTest {

    @Autowired
    LogController logController;

    private static MockMvc mockMvc;

    @BeforeAll
    public static void setup(){

    }


    @Test
    void shutdown()throws  Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(logController).build();
        String url = "/hello";
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(url));
        ResultActions ra = mockMvc.perform(MockMvcRequestBuilders.get(url));
        ra.andDo(x->System.out.println("result"+x.getRequest()));


    }

    @Test
    void getMessage() {
    }

    @Test
    void getConfigMessage() {
    }

    @Test
    void getExceptionMessage() {
    }

    @Test
    void getDivideMessage() {
    }

    @Test
    void createUser() {
    }
}