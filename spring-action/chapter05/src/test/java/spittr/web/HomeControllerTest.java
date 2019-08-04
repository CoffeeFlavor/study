package spittr.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author : jennie
 * @date: 2019/8/4
 * @Time: 15:33
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class HomeControllerTest {

    @Test
    public void home() throws Exception{
        HomeController homeController=new HomeController();
        MockMvc mockMvc= standaloneSetup(homeController).build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }
}
