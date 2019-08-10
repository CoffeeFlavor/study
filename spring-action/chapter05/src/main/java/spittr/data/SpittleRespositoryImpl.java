package spittr.data;

import org.springframework.stereotype.Service;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : jennie
 * @date: 2019/8/10
 * @Time: 17:00
 */
@Service
public class SpittleRespositoryImpl implements SpittleRespository {

    public List<Spittle> findSpittles(long max, int count) {
        return createSpittleList(count);
    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles=new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle"+i,new Date()));
        }
        return spittles;
    }
}
