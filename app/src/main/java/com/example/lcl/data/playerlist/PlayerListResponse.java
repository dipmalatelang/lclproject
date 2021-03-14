package com.example.lcl.data.playerlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerListResponse {

    @SerializedName("$id")
    @Expose
    private String $id;

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private PlayerData data;

    @SerializedName("resPlayers")
    @Expose
    private String resPlayers;

    @SerializedName("totalRecords")
    @Expose
    private Integer totalRecords;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PlayerData getData() {
        return data;
    }

    public void setData(PlayerData data) {
        this.data = data;
    }

    public String getResPlayers() {
        return resPlayers;
    }

    public void setResPlayers(String resPlayers) {
        this.resPlayers = resPlayers;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }
}
