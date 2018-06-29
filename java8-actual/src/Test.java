import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : jennie
 * @date: 2018/6/26
 * @Time: 13:58
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal v=new BigDecimal("2.135382482347");
       BigDecimal v2= v.divide(BigDecimal.ONE,RoundingMode.HALF_UP);
        System.out.println(v2);

        int portNumber=1234;
        Runnable r=() -> System.out.println(portNumber);

    }
}
