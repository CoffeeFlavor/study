import com.jennie.study.account.captcha.RandomGenerator;
import org.junit.Test;


import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;


/**
 * @author : jennie
 * @date: 2019/7/6
 * @Time: 17:21
 */
public class RandomGeneratorTest {

    @Test
    public void testGetRandomString(){
        Set<String> randoms=new HashSet<>(100);
        for (int i = 0; i < 100; i++) {
            String random= RandomGenerator.getRandomString();
            assertFalse(randoms.contains(random));
            randoms.add(random);
        }
    }
}
