package com.springinaction.knights;

import java.io.PrintStream;

/**
 * @author : jennie
 * date: 2019/7/16
 * Time: 7:19
 */
public class Minstrel {

    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public void singBeforeQuest(){
        stream.println("Fa la la, the knight is so brave!");
    }

    public void singAfterQuest(){
        stream.println("The hee hee,the brave knight did embark on a quest");
    }
}
