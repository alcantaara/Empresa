package com.marina.empresas;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserRequest implements Serializable{

    @SerializedName("access-token")
    private String accessToken;

    @SerializedName("client")
    private String client;

    @SerializedName("uid")
    private String uid;

    public UserRequest(String accessToken, String client, String uid) {
        this.accessToken = accessToken;
        this.client = client;
        this.uid = uid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
