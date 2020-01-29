package com.example.study.Presentation.Recicle;

import com.example.study.Constant.Kbn;

public class RecycleItemDto {

    private String familyName;

    private String firstName;

    private Kbn.SEX sex;

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
}
