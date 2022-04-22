package com.mamedovga.lifesim.models;

public class Response {
    private String chatBotReply;

    public Response(String chatBotReply) {
        this.chatBotReply = chatBotReply;
    }

    public String getResponse() {
        return chatBotReply;
    }

    public void setResponse(String response) {
        this.chatBotReply = response;
    }
}
