package chapter06.spittr.data;

import org.springframework.stereotype.Service;
import chapter06.spittr.Spittle;

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

    private List<Spittle> data=createSpittleList();

    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles=createSpittleList();
        List<Spittle> resultList=new ArrayList<Spittle>();
        for (Spittle spittle : spittles) {
            if (spittle.getId()<=count){
                if (resultList.size()>max) {
                    break;
                }
                resultList.add(spittle);
            }
        }
        return resultList;
    }


    public Spittle getSpittle(long id) {
        List<Spittle> spittles=createSpittleList();
        for (Spittle spittle : spittles) {
            if (id==spittle.getId()){
                return spittle;
            }
        }
        return null;
    }

    private List<Spittle> createSpittleList(){
        int count=100;
        List<Spittle> spittles=new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle((long) i,"Spittle"+i,new Date()));
        }
        return spittles;
    }

    public Spittle getProfile(String username) {
        for (Spittle datum : data) {
            if (username.equals(datum.getUsername())){
                return datum;
            }
        }
        return null;
    }


    public void save(Spittle spittle) {
        data.add(spittle);
    }
}
