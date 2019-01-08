package io.example;

import io.vertx.core.AbstractVerticle;

/**
 * @author : jennie
 * @date: 2018/10/30
 * @Time: 上午10:35
 */
public class MainVerticle extends AbstractVerticle {
    public void start(){

        vertx.deployVerticle(MyFirtstVerticle.class.getName());
    }
}
