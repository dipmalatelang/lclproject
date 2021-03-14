package com.example.lcl.data.registerplayer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterPlayerModel {

    @SerializedName("pNumber")
    @Expose
    private String pNumber;

    @SerializedName("pPassword")
    @Expose
    private String pPassword;

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

    @SerializedName("born")
    @Expose
    private String born;

    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("hieght")
    @Expose
    private String hieght;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("roles")
    @Expose
    private String roles;

    @SerializedName("batingStyle")
    @Expose
    private String batingStyle;

    @SerializedName("bowlingStyle")
    @Expose
    private String bowlingStyle;

    @SerializedName("basePrice")
    @Expose
    private Integer basePrice;

    @SerializedName("soldPrice")
    @Expose
    private Integer soldPrice;

    @SerializedName("purchaseByTeam")
    @Expose
    private String purchaseByTeam;

    @SerializedName("areaFrom")
    @Expose
    private String areaFrom;

    @SerializedName("buildingName")
    @Expose
    private String buildingName;

    @SerializedName("playerDescription")
    @Expose
    private String playerDescription;

    @SerializedName("registeredAt")
    @Expose
    private String registeredAt;

    @SerializedName("isActive")
    @Expose
    private Integer isActive;

    @SerializedName("isDisplayable")
    @Expose
    private Integer isDisplayable;

    @SerializedName("remark")
    @Expose
    private String remark;

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getpPassword() {
        return pPassword;
    }

    public void setpPassword(String pPassword) {
        this.pPassword = pPassword;
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

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHieght() {
        return hieght;
    }

    public void setHieght(String hieght) {
        this.hieght = hieght;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getBatingStyle() {
        return batingStyle;
    }

    public void setBatingStyle(String batingStyle) {
        this.batingStyle = batingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(Integer soldPrice) {
        this.soldPrice = soldPrice;
    }

    public String getPurchaseByTeam() {
        return purchaseByTeam;
    }

    public void setPurchaseByTeam(String purchaseByTeam) {
        this.purchaseByTeam = purchaseByTeam;
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

    public String getPlayerDescription() {
        return playerDescription;
    }

    public void setPlayerDescription(String playerDescription) {
        this.playerDescription = playerDescription;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getIsDisplayable() {
        return isDisplayable;
    }

    public void setIsDisplayable(Integer isDisplayable) {
        this.isDisplayable = isDisplayable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
