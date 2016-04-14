package com.shell.service;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.shell.domain.ShellMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: jennie
 * Date: 2016/4/14
 * Time: 9:06
 */
public class SSHUtils {
    public static void main(String[] args) {

        String hostname = "192.168.199.36";
        String username = "root";
        String password = "huama";
        //指明连接主机的IP地址
        Connection conn = new Connection(hostname);
        Session ssh = null;
        try {
            //连接到主机
            conn.connect();
            //使用用户名和密码校验
            boolean isconn = conn.authenticateWithPassword(username, password);
            if (!isconn) {
                System.out.println("用户名称或者是密码不正确");
            } else {
                System.out.println("已经连接OK");
                ssh = conn.openSession();
                //使用多个命令用分号隔开
//              ssh.execCommand("pwd;cd /tmp;mkdir hb;ls;ps -ef|grep weblogic");
                ssh.execCommand("cd /;cd /usr; ls");
                //只允许使用一行命令，即ssh对象只能使用一次execCommand这个方法，多次使用则会出现异常
//              ssh.execCommand("mkdir hb");
                //将屏幕上的文字全部打印出来
                InputStream is = new StreamGobbler(ssh.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                while (true) {
                    String line = brs.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println(line);
                }
                ssh.execCommand("ifconfig");
                is = new StreamGobbler(ssh.getStdout());
                brs = new BufferedReader(new InputStreamReader(is));
                while (true) {
                    String line = brs.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println(line);
                }

            }
            //连接的Session和Connection对象都需要关闭
            ssh.close();
            conn.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String execCommand(ShellMessage shellMessage) {
        Connection conn = new Connection(shellMessage.getHost(), 22);
        Session ssh = null;
        StringBuffer sb=new StringBuffer();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss.SSS");
        sb.append("<br/>").append("<span>").append(dateFormat.format(new Date())).append("</span>");
        sb.append("<br/>").append("<span class='command_info'>").append(shellMessage.getCommand()).append("</span>");
        //连接主机
        try {
            conn.connect();
            if (conn.authenticateWithPassword(shellMessage.getUsername(), shellMessage.getPassword())) {
                System.out.println("连接成功");
            }else {
                return sb.append("请重新确认用户密码").toString();
            }
            ssh = conn.openSession();
            ssh.execCommand(shellMessage.getCommand());
            InputStream inputStream = new StreamGobbler(ssh.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            Boolean readFlag = Boolean.TRUE;
            while (readFlag) {
                String line = br.readLine();
                if (line == null) {
                    readFlag = Boolean.FALSE;
                    break;
                }
                sb.append("<br/>").append(line);
                System.out.println(line);
            }
        } catch (IOException e) {
           sb.append("<br/>").append("ssh exec IOException ").append(e.toString());
        }finally {
            if (ssh!=null){
                ssh.close();
            }
            conn.close();
            return sb.toString();
        }
    }
}
