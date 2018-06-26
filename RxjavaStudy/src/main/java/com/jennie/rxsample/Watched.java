package com.jennie.rxsample;

/**
 * @author : jennie
 * @date: 2017/12/27
 * @Time: 15:55
 */
public interface Watched {

     void addWatcher(Watcher watcher);

     void removeWatcher(Watcher watcher);

     void notifyWatcher(String String);
}
