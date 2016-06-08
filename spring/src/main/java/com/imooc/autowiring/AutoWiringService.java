package com.imooc.autowiring;

import javax.sound.midi.Soundbank;

/**
 * User: jennie
 * Date: 2016/6/8
 * Time: 16:42
 */
public class AutoWiringService {

    private AutoWiringDAO autoWiringDAO;


    public AutoWiringService(AutoWiringDAO autoWiringDAO) {
        System.out.println("AutoWiringService");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
        System.out.println("setAutoWiringDAO");
        this.autoWiringDAO = autoWiringDAO;
    }



    public  void say(String word){
        this.autoWiringDAO.say(word);
    }
}
