package com.jennie.rxsample;

/**
 * @author : jennie
 * @date: 2017/12/27
 * @Time: 16:43
 */
public class Test {
    public static void main(String[] args) {
//        Watched thief=new ConcreteWatched();
//        Watcher police1=new ConcreteWatcher();
//        Watcher police2=new ConcreteWatcher();
//        Watcher police3=new ConcreteWatcher();
//
//        thief.addWatcher(police1);
//        thief.addWatcher(police2);
//        thief.addWatcher(police3);
//
//        thief.notifyWatcher("Steal things \n");


        ObservableTest observableTest=new ObservableTest();
        ObserverTest observerTest=new ObserverTest(observableTest);
        observableTest.setData(1);
        observableTest.setData(2);
        observableTest.setData(2);
        observableTest.setData(3);
    }
}
