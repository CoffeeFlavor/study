package com.jennie.rxJava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func0;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jennie
 * @date: 2017/12/28
 * @Time: 15:15
 */
public class JianshuRxTest {

    public void RxCreate(){
        Observable<String>  sender=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hi,Weavet");
            }
        });

        Observable<String> normalObservable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("create1");
                subscriber.onNext("create2");
                subscriber.onCompleted();
            }
        });

        Observable<String> justObservable=Observable.just("just1","just2");

        List<String> list=new ArrayList<>();
        list.add("from1");
        list.add("from2");
        list.add("from3");
        Observable<String> fromObservable=Observable.from(list);


        Observable<String> deferObservable= Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just("deferObservable");
            }
        });

        Observer<String> receiver=new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complete");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

//        sender.subscribe(receiver);
//        normalObservable.subscribe(receiver);
//        justObservable.subscribe(receiver);
//        fromObservable.subscribe(receiver);
        deferObservable.subscribe(receiver);
    }






    public static void main(String[] args) {
        JianshuRxTest jianshuRxTest=new JianshuRxTest();
        jianshuRxTest.RxCreate();
    }
}
