package com.example.lcl.data.playerlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerData {

    @SerializedName("$id")
    @Expose
    private String $id;

    @SerializedName("uId")
    @Expose
    private Integer uId;

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

    @SerializedName("born")
    @Expose
    private String born;

    @SerializedName("age")
    @Expose
    private Integer age;

    @SerializedName("hieght")
    @Expose
    private String hieght;

    @SerializedName("photo")
    @Expose
    private String photo;

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
    private Boolean isActive;

    @SerializedName("isDisplayable")
    @Expose
    private Boolean isDisplayable;

    @SerializedName("remark")
    @Expose
    private String remark;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

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

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHieght() {
        return hieght;
    }

    public void setHieght(String hieght) {
        this.hieght = hieght;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
