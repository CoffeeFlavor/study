package com.springinaction.knights;

/**
 * @author : jennie
 * @date: 2019/7/12
 * @Time: 7:23
 */
public class DamselRescuingKnight implements Knight {

    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        this.quest = new RescueDamselQuest();
    }

    public void embarkOnQuest(){
        quest.embark();
    }
}
