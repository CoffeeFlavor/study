package com.shell.domain;

/**
 * User: jennie
 * Date: 2016/4/13
 * Time: 11:13
 */
public class ShellMessage {

    private String username;

    private String password;

    private String command;

    private String host;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
