package study.netty.io;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : seven
 * date: 2019-06-27
 * time: 14:42
 */
public class IOServer {

    public static void main(String[] args) throws Exception {
        final ServerSocket serverSocket = new ServerSocket(8000);
        //(1)接收新连接线程
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                byte[] data = new byte[1024];
                try {
                    InputStream inputStream = socket.getInputStream();
                    while (true) {
                        int len;
                        //按字节流方式读取数据
                        while ((len = inputStream.read(data)) != -1) {
                            System.out.println("len : " + len);
                            System.out.print(new String(data, 0, len));
                        }
                        break;
                    }
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("你好，好久不见".getBytes("utf-8"));
                    outputStream.flush();
                    inputStream.close();
                    outputStream.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
