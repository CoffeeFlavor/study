package io;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.IOException;

/**
 * User: jennie
 * Date: 2016/9/28
 * Time: 9:49
 */

public class MyReadListener implements ReadListener {

    private ServletInputStream inputStream;

    private AsyncContext context;

    public MyReadListener(ServletInputStream inputStream, AsyncContext context) {
        this.inputStream = inputStream;
        this.context = context;
    }

    @Override
    public void onDataAvailable() throws IOException {

        System.out.println("数据可用！");
        try {
            //暂停5秒，模拟读取数据是一个耗时的操作
            Thread.sleep(5000);
            StringBuilder sb=new StringBuilder();
            int len=-1;
            byte[] buff=new byte[1024];
            //采用原始IO方式读取浏览器向Servlet提交的数据
            while (inputStream.isReady()&&(len=inputStream.read(buff))>0){
                String data=new String(buff,0,len);
                sb.append(data);
            }
            System.out.println(sb);
            //将数据设置为request范围的属性
            context.getRequest().setAttribute("info",sb.toString());
            //转发到视图页面
            context.dispatch("/io_async.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onAllDataRead() throws IOException {
        System.out.println("数据读取完成");
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
