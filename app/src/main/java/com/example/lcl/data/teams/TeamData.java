package com.example.lcl.data.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamData {

    @SerializedName("uId")
    @Expose
    private Integer uId;

    @SerializedName("tNumber")
    @Expose
    private String tNumber;

    @SerializedName("tPassword")
    @Expose
    private String tPassword;

    @SerializedName("teamName")
    @Expose
    private String teamName;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("middleName")
    @Expose
    private String middleName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("photo")
    @Expose
    private String photo;

    @SerializedName("allocatedFund")
    @Expose
    private Integer allocatedFund;

    @SerializedName("fundRemaining")
    @Expose
    private String fundRemaining;

    @SerializedName("fundSpent")
    @Expose
    private Integer fundSpent;

    @SerializedName("maxSquadSize")
    @Expose
    private Integer maxSquadSize;

    @SerializedName("totalPlayer")
    @Expose
    private Integer totalPlayer;

    @SerializedName("areaFrom")
    @Expose
    private String areaFrom;

    @SerializedName("buildingName")
    @Expose
    private String buildingName;
    @SerializedName("teamDescription")
    @Expose
    private String teamDescription;

    @SerializedName("registeredAt")
    @Expose
    private String registeredAt;

    @SerializedName("isActive")
    @Expose
    private Boolean isActive;

    @SerializedName("isDisplayable")
    @Expose
    private Boolean isDisplayable;

    @SerializedName("remark")
    @Expose
    private String remark;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String gettNumber() {
        return tNumber;
    }

    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getAllocatedFund() {
        return allocatedFund;
    }

    public void setAllocatedFund(Integer allocatedFund) {
        this.allocatedFund = allocatedFund;
    }

    public String getFundRemaining() {
        return fundRemaining;
    }

    public void setFundRemaining(String fundRemaining) {
        this.fundRemaining = fundRemaining;
    }

    public Integer getFundSpent() {
        return fundSpent;
    }

    public void setFundSpent(Integer fundSpent) {
        this.fundSpent = fundSpent;
    }

    public Integer getMaxSquadSize() {
        return maxSquadSize;
    }

    public void setMaxSquadSize(Integer maxSquadSize) {
        this.maxSquadSize = maxSquadSize;
    }

    public Integer getTotalPlayer() {
        return totalPlayer;
    }

    public void setTotalPlayer(Integer totalPlayer) {
        this.totalPlayer = totalPlayer;
    }

    public String getAreaFrom() {
        return areaFrom;
    }

    public void setAreaFrom(String areaFrom) {
        this.areaFrom = areaFrom;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDisplayable() {
        return isDisplayable;
    }

    public void setDisplayable(Boolean displayable) {
        isDisplayable = displayable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
