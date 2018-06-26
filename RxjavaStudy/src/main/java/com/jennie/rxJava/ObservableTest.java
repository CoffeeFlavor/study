package com.jennie.rxJava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Subscriber;
import sun.rmi.runtime.Log;

/**
 * @author : jennie
 * @date: 2017/12/27
 * @Time: 17:48
 */
public class ObservableTest {

    private static final Logger LOGGER= LoggerFactory.getLogger(ObservableTest.class);

    private void rxJavaCreate(){
        //定义被观察者
        Observable<String> observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("Hello");
                    subscriber.onNext("HI");
                    subscriber.onNext(getJson());
                    subscriber.onNext("Hello");
                    subscriber.onNext("END");
                    //完成
                    subscriber.onCompleted();
                }
            }
        });

    Subscriber<String> showSub=new Subscriber<String>() {
        @Override
        public void onCompleted() {
            LOGGER.info("onComplete");
        }

        @Override
        public void onError(Throwable e) {
            LOGGER.info(e.getMessage());
        }

        @Override
        public void onNext(String s) {
            LOGGER.info(s);
        }
    };
    observable.subscribe(showSub);
    }

    public static String getJson(){
        //这里进行网络解析,耗时操作
        return "Json Data";
    }

    public static void main(String[] args) {
        ObservableTest observableTest=new ObservableTest();
        observableTest.rxJavaCreate();
    }

}
