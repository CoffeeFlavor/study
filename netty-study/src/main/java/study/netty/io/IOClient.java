package study.netty.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @author : seven
 * date: 2019-06-27
 * time: 18:25
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        socket.getOutputStream().flush();
                        byte[] data=new byte[2014];
                        int len;
                        InputStream inputStream=socket.getInputStream();
                        while ((len=inputStream.read(data))!=-1){
                            System.out.println(new String(data,0,len));
                        }
                        inputStream.close();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}