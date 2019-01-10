package chapter01.node83;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 11:08
 */
public class MyObject {

    private String username="1";

    private String passowrd="11";

    public void setValue(String u,String p){
        this.username=u;
        if (Thread.currentThread().getName().equals("a")){
            System.out.println(" 停止a 线程");
            Thread.currentThread().suspend();
        }
        this.passowrd=p;
    }

    public void  printUssernamePassword(){
        System.out.println(username+" "+passowrd);
    }
}
