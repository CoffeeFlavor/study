package chapter03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : jennie
 * @date: 2018/6/25
 * @Time: 11:26
 */
public class BufferedReaderMain {

    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\jennie\\Desktop\\data.txt"),"gbk"))){
            return p.process(br);
        }
    }

    public static void main(String[] args){
        try {
            System.out.println(processFile(b -> b.readLine()));
            System.out.println(processFile(b -> b.readLine()+b.readLine()+b.readLine()));
            System.out.println(processFile(b -> b.readLine()));
            System.out.println(processFile(b -> b.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
