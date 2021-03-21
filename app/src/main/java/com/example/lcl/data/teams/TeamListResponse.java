package com.example.lcl.data.teams;

import com.example.lcl.data.playerlist.PlayerData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamListResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<TeamData> data = null;
    @SerializedName("totalRecords")
    @Expose
    private Integer totalRecords;

    @SerializedName("resPlayers")
    @Expose
    private List<PlayerData> resPlayers = null;

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

    public List<TeamData> getData() {
        return data;
    }

    public void setData(List<TeamData> data) {
        this.data = data;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<PlayerData> getResPlayers() {
        return resPlayers;
    }

    public void setResPlayers(List<PlayerData> resPlayers) {
        this.resPlayers = resPlayers;
    }
}
