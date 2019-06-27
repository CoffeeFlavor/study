import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * @author : seven
 * date: 2019-04-10
 * time: 19:56
 */
public class Test {


    public static void main(String[] args) {
        File imageFile = new File( "/Users/seven/gitHub/study/logtest/src/main/resources/Log/test.png");
        ITesseract instance = new Tesseract();//调用Tesseract
        //URL url = ClassLoader.getSystemResource("tessdata");
//URL url = ClassLoader.getSystemResource("\\Applications\\Eclipse.app\\Contents\\MacOS\\Users\\xin\\.m2\\repository\\net\\sourceforge\\tess4j\\tess4j\\4.2.1\\tess4j-4.2.1\\tessdata");//获得Tesseract的文字库
//String tesspath = url.getPath().substring(1);
        instance.setDatapath("/Users/seven/gitHub/study/logtest/src/main/resources/tessdata");
//instance.setDatapath("\\Applications\\Eclipse.app\\Contents\\MacOS\\Users\\xin\\.m2\\repository\\net\\sourceforge\\tess4j\\tess4j\\4.2.1\\tess4j-4.2.1\\tessdata");//进行读取，默认是英文，如果要使用中文包，加上instance.setLanguage("chi_sim");
        instance.setLanguage("chi_sim");
        String result = null;
        try {

            result= instance.doOCR(imageFile);
        } catch (TesseractException e1) {
            e1.printStackTrace();
        }
        result = result.replaceAll("[^a-z^A-Z^0-9]", "");//替换大小写及数字
        System.out.print(result);
    }
}
