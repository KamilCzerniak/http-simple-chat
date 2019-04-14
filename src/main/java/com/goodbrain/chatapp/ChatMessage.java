package com.goodbrain.chatapp;

public class ChatMessage {

    private String username;
    private String value;
    private String ip;


    public ChatMessage() {
    }

    public ChatMessage(String username, String ip, String value) {
        this.username = username;
        this.ip = ip;
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "username='" + username + '\'' +
                ", value='" + value + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
