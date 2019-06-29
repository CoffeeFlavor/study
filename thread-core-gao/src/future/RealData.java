package future;

/**
 * @author : jennie
 * date: 2019-01-08
 * time: 14:45
 */
public class RealData implements Data {

    private String result;

    @Override
    public String getResult() {
        return result;
    }

    public RealData(String params){
        StringBuffer sb=new StringBuffer();
        sb.append(params);
        try {
            //模拟构造真实数据耗时操作
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        result=sb.toString();
    }

}
