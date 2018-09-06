package com.mwl.rxjava;


import rx.Observable;
import rx.Subscriber;

/**
 * @author mawenlong
 * @date 2018/09/06
 * describe:Observable与Subscribers
 */
public class OberVableDemo {
    public static void main(String[] args) {
        //创建事件源
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello RxJava");
                subscriber.onNext("do something");
                subscriber.onCompleted();
            }
        });
        //创建订阅者
        Subscriber<String> subscriber = new Subscriber<String>() {
            public void onCompleted() {

            }

            public void onError(Throwable e) {

            }

            public void onNext(String s) {
                System.out.println("Subscriber:" + s);
            }
        };
        observable.subscribe(subscriber);
    }
}
