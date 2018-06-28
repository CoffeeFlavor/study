package chapter01.node23;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 14:06
 */
public class ALogin extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("a","aa");
    }
}

