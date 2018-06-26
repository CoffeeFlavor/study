package com.jennie.rxsample;


import java.util.Observable;

/**
 * @author : jennie
 * @date: 2017/12/27
 * @Time: 16:56
 * 被观察者
 */
public class ObservableTest extends Observable {
    private int data=0;

    public int getData() {
        return data;
    }

    public void setData(int data){
        if (this.data!=data){
            this.data=data;
            setChanged();
            notifyObservers();
        }
    }
}
