package springinaction.study.chapter04.concert;

/**
 * @author : jennie
 * @date: 2019/7/28
 * @Time: 17:44
 */
public class CriticismEngineImpl implements CriticismEngine {
    public CriticismEngineImpl() {
    }

    public String getCriticism() {
        int i=(int)(Math.random()*critismPool.length);
        return critismPool[i];
    }
    private String[] critismPool;

    public void setCritismPool(String[] critismPool) {
        this.critismPool = critismPool;
    }
}
