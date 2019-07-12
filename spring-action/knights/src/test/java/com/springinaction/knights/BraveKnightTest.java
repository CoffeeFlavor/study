package com.springinaction.knights;


import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author : jennie
 * date: 2019/7/12
 * Time: 7:36
 */
public class BraveKnightTest {


    @Test
    public void knightShouldEmbarkOnQuest(){
        Quest mockQuest=mock(Quest.class);
        BraveKnight knight=new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest,times(1)).embark();
    }

}
