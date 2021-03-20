package com.example.lcl.data.playerlist;

import com.example.lcl.util.Helpers;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PlayerData implements Serializable {

    @SerializedName("$id")
    @Expose
    private String $id;

    @SerializedName("uId")
    @Expose
    private Integer uId;

    @SerializedName("pNumber")
    @Expose
    private String playerNumber;

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
    private String height;

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
        return $id == null ? "No Data available " : $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Integer getuId() {
        return uId == null ? 0 : uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getPlayerNumber() {
        return playerNumber == null ? "No Data available " : playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getpPassword() {
        return pPassword == null ? "No Data available " : pPassword;
    }

    public void setpPassword(String pPassword) {
        this.pPassword = pPassword;
    }

    public String getFirstName() {
        return firstName == null ? "No Data available " : firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName == null ? "No Data available " : middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName == null ? "No Data available " : lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile == null ? "No Data available " : mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email == null ? "No Data available " : email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBorn() {
        return born == null ? "No Data available " : born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getAge() {
        return age == null ? "No Data available " : String.valueOf(age);
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeight() {
        return height == null ? "No Data available " : height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPhoto() {
        return photo == null ? "No Data available " : photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category == null ? "No Data available " : category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRoles() {
        return roles == null ? "No Data available " : roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getBatingStyle() {
        return batingStyle == null ? "No Data available " : batingStyle;
    }

    public void setBatingStyle(String batingStyle) {
        this.batingStyle = batingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle == null ? "No Data available " : bowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }

    public String getBasePrice() {
        return basePrice == null ? "No Data available " : Helpers.convertCurrency(basePrice);
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public String getSoldPrice() {
        return soldPrice == null ? "No Data available " : Helpers.convertCurrency(soldPrice);
    }

    public void setSoldPrice(Integer soldPrice) {
        this.soldPrice = soldPrice;
    }

    public String getPurchaseByTeam() {
        return purchaseByTeam == null ? "No Data available " : purchaseByTeam;
    }

    public void setPurchaseByTeam(String purchaseByTeam) {
        this.purchaseByTeam = purchaseByTeam;
    }

    public String getAreaFrom() {
        return areaFrom == null ? "No Data available " : areaFrom;
    }

    public void setAreaFrom(String areaFrom) {
        this.areaFrom = areaFrom;
    }

    public String getBuildingName() {
        return buildingName == null ? "No Data available " : buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getPlayerDescription() {
        return playerDescription == null ? "No Data available " : playerDescription;
    }

    public void setPlayerDescription(String playerDescription) {
        this.playerDescription = playerDescription;
    }

    public String getRegisteredAt() {
        return registeredAt == null ? "No Data available " : registeredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Boolean getActive() {
        return isActive == null ? false : isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDisplayable() {
        return isDisplayable  == null ? false : isDisplayable;
    }

    public void setDisplayable(Boolean displayable) {
        isDisplayable = displayable;
    }

    public String getRemark() {
        return remark == null ? "No Data available " : remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
