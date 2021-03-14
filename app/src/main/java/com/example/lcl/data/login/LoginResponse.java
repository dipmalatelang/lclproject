package com.example.lcl.data.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("$id")
    @Expose
    private String $id;

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("role")
    @Expose
    private String role;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private LoginData data;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
    }
}
