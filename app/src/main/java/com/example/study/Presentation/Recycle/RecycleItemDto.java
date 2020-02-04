package com.example.study.Presentation.Recycle;

import com.example.study.Common.Kbn;

public class RecycleItemDto {

//    public enum ItemType{
//        UserInfo,
//        Loading
//    }
//
//    private ItemType itemType;
//
//    public ItemType getItemType() {
//        return itemType;
//    }
//
//    public RecycleItemDto(ItemType itemType) {
//        this.itemType = itemType;
//    }

    private String familyName;

    private String firstName;

    private Kbn.SEX sex;

    private String zipCode;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Kbn.SEX getSex() {
        return sex;
    }

    public void setSex(Kbn.SEX sex) {
        this.sex = sex;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
