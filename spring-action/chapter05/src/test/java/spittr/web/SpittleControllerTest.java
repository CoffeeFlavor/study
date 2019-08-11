package spittr.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleRespository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author : jennie
 * @date: 2019/8/4
 * @Time: 16:15
 */
public class SpittleControllerTest {

    @Test
    public void spittles() throws Exception{
        List<Spittle> expectedSpittles=createSpittleList(20);

        SpittleRespository mockRespository=mock(SpittleRespository.class);
        when(mockRespository.findSpittles(Long.MAX_VALUE,20))
                .thenReturn(expectedSpittles);
        SpittleController spittleController=new SpittleController(mockRespository);
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(spittleController)
                .setSingleView(new InternalResourceView("WEN-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleMessage"))
                .andExpect(model().attribute("spittleMessage",hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles=new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle"+i,new Date()));
        }
        return spittles;
    }

    @Test
    public void shouldProcessRegisterAction() throws Exception{
     SpittleRespository mockSpittleRespository=mock(SpittleRespository.class);
     Spittle unsave=new Spittle();
     unsave.setFirstName("jbauer");
     unsave.setLastName("24hour");
     unsave.setUsername("Jack");
     unsave.setPassword("Bauer");
     unsave.setId(21L);
//     when(mockSpittleRespository.save(unsave)).thenReturn()


    }
}
