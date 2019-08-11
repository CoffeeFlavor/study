package spittr.data;

import spittr.Spittle;

import java.util.List;

/**
 * @author : jennie
 * @date: 2019/8/4
 * @Time: 15:50
 */
public interface SpittleRespository {

    List<Spittle> findSpittles(long max,int count);


    Spittle getSpittle(long id);


    Spittle getProfile(String username);

    void save(Spittle spittle);

}
