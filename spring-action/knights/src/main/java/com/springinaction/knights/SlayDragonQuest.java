package com.springinaction.knights;

import java.io.PrintStream;

/**
 * @author : jennie
 * date: 2019/7/12
 * Time: 8:06
 */
public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
