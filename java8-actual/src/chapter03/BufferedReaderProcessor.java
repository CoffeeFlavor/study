package chapter03;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author : jennie
 * @date: 2018/6/25
 * @Time: 11:24
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader b) throws IOException;
}
