package com.springinaction.study.chapter02.javaconfigauto;

import com.springinaction.study.chapter02.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * @author : jennie
 * date: 2019/7/17
 * Time: 6:24
 */
@Component
public class SgtPeppers  implements CompactDisc {

    private String title="Sgt. Pepper's Lonely Hearts Club Band";

    private String artist="The Beatles";
    public void play() {
        System.out.println("Playing "+title+" by "+artist);
    }
}
