package com.jennie.rxsample;

/**
 * @author : jennie
 * @date: 2017/12/27
 * @Time: 16:42
 */
public class ConcreteWatcher implements Watcher {
    @Override
    public void update(String string) {
        System.out.println(string);
    }
}
