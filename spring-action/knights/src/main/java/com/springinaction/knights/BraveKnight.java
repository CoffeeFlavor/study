package com.springinaction.knights;

/**
 * @author : jennie
 * @date: 2019/7/12
 * @Time: 7:34
 */
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }


    public void embarkOnQuest(){
        quest.embark();
    }


}
