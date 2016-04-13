package com.shell.service;

import com.jcraft.jsch.*;
import org.apache.commons.lang3.StringUtils;
import sun.util.calendar.LocalGregorianCalendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * User: jennie
 * Date: 2016/4/13
 * Time: 11:05
 */
public class ShellUtils {

    private static Session session;
    /**
     * 连接到指定的IP
     *
     * @throws JSchException
     */
    public void connectServer(String ip,String username,String password ){
        JSch jSch=new JSch();
        try {
            session=jSch.getSession(username,ip,22);
            session.setPassword(password);
            Properties config=new Properties();
            config.put("StrictHostKeyChecking","no");
            session.setConfig(config);
            session.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    public  String excuteCommand(String command, String user, String passwd, String host){
        connectServer(user,passwd,host);
        StringBuffer log=new StringBuffer();
        BufferedReader reader = null;
        Channel channel = null;
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss.SSS");
        log.append("<br/>").append("<span>").append(dateFormat.format(new Date())).append("</span>");
        try {
            channel=session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            channel.connect();
            InputStream in=channel.getInputStream();
            reader=new BufferedReader(new InputStreamReader(in));
            while (StringUtils.isNotBlank(reader.readLine())){
                log.append("<br/>").append(reader.readLine());
            }
            return log.toString();
        } catch (JSchException e) {
            return log.append("JSchException  : ").append("<br/>").append(e.toString()).toString();
        }catch (IOException e){
            return log.append("IOException  : ").append("<br/>").append(e.toString()).toString();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                return log.append(" reader close IOException").append("<br/>").append(e.toString()).toString();
            }
            channel.disconnect();
        }
    }
}
