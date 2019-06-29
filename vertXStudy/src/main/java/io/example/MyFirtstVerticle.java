package io.example;

import io.vertx.core.AbstractVerticle;

/**
 * @author : jennie
 * @date: 2018/10/30
 * @Time: 上午10:27
 */
public class MyFirtstVerticle extends AbstractVerticle {

    public void start(){

        vertx.setPeriodic(1000,event -> {
            System.out.println("timer fired");
        });

        vertx.createHttpServer().requestHandler(req->{
            req.response().putHeader("content-Type","text/plain")
                    .end("hello world");
        }).listen(8080);

    }
}
