package com.example.roomsearch;

public class Backdata {
    String adress;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getTalentcount() {
        return talentcount;
    }

    public void setTalentcount(int talentcount) {
        this.talentcount = talentcount;
    }

    String des;
    String img1;
    String img2;
    String img3;
    String phone;
    int rent,talentcount;

    public Backdata(String adress, String des, String img1, String img2, String img3, String phone, int rent, int talentcount) {
        this.adress = adress;
        this.des = des;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.phone = phone;
        this.rent = rent;
        this.talentcount = talentcount;
    }
}
