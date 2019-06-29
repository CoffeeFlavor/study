package chapter01.node23;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 14:07
 */
public class Blogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}
