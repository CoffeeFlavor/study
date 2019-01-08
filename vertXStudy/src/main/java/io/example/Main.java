package io.example;

import io.vertx.core.Vertx;

/**
 * @author : jennie
 * @date: 2018/10/30
 * @Time: 上午10:22
 */
public class Main {

    public static void main(String[] args) {
        Vertx vertx=Vertx.vertx();

        vertx.deployVerticle(MyFirtstVerticle.class.getName());
    }
}
