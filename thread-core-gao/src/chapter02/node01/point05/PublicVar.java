package chapter02.node01.point05;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 16:07
 */
public class PublicVar {

    private String username="A";

    private String password="AA";

    synchronized  public void  setValue(String username,String password){
        try {
            this.username=username;
            Thread.sleep(5000);
            this.password=password;
            System.out.println(" setValue method thread name="
                    +Thread.currentThread().getName()+" username="
                    +username+" password="+password
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void  getValue(){
        System.out.println(" getValue method thread name="
                +Thread.currentThread().getName()+" username="
                +username+" password="+password
        );
    }
}
