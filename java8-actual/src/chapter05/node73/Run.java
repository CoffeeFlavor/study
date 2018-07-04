package chapter05.node73;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author : jennie
 * @date: 2018/7/2
 * @Time: 14:48
 */
public class Run {
    public static void main(String[] args) {
        long uniqueWords=0;
        try (Stream<String> lines=Files.lines(Paths.get("C:\\Users\\jennie\\Desktop\\data.txt"),Charset.forName("GBK"))){

//            uniqueWords=lines
//                    .flatMap(line -> Arrays.stream(line.split(" ")))
//                    .distinct()
//                    .count();
            System.out.println(uniqueWords);
            lines.forEach(System.out::println);
        }catch (IOException  e){
            e.printStackTrace();
        }
    }
}
