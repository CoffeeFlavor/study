package future;

/**
 * @author : jennie
 * date: 2019-01-08
 * time: 14:49
 */
public class Main {
    public static void main(String[] args) {
//        Client client = new Client();
////        Data data = client.request("Hello Future!");
////        System.out.println("请求完毕！");
////
////        try {
////            //模拟处理其他业务
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////
////        System.out.println("真实数据：" + data.getResult());

        try {
            throw new RuntimeException("哈哈哈");
        }catch (Exception e){
            System.out.println("错了");
        }finally {
            System.out.println("一定要执行");
        }
    }
}
