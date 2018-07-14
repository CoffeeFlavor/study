package chapter02.node01.point06;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 16:24
 */
public class Service {

    synchronized public void service1(){
        System.out.println("service1");
        service2();
    }
    synchronized public void service2(){
        System.out.println("service2");
        service3();
    }
    synchronized public void service3(){
        System.out.println("service3");
    }
}
