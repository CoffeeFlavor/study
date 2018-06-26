package com.jennie.rxsample;

import java.util.Observable;
import java.util.Observer;

/**
 * @author : jennie
 * @date: 2017/12/27
 * @Time: 17:00
 * 观察者
 */
public class ObserverTest implements Observer {

    public ObserverTest(ObservableTest observableTest) {
        observableTest.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("data is changed: "+((ObservableTest)o).getData()+"\n");
    }
}
