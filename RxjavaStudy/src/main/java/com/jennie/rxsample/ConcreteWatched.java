package com.jennie.rxsample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jennie
 * @date: 2017/12/27
 * @Time: 15:59
 *   被观察者
 */
public class ConcreteWatched implements Watched {

    private  List<Watcher> watchers=new ArrayList<Watcher>();


    @Override
    public void addWatcher(Watcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        watchers.remove(watcher);
    }

    @Override
    public void notifyWatcher(String s) {
        for (Watcher watcher : watchers) {
            watcher.update(s);
        }
    }
}
