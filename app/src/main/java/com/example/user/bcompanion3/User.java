package com.example.user.bcompanion3;

public class User {
    private String mName, mSurName, mPhone, mDate_of_birth, mCity;

    public User(){

    }

    public User(String name, String surname, String phone,String Date_of_birth, String City) {
        this.mName = name;
        this.mSurName = surname;
        this.mPhone = phone;
        this.mDate_of_birth=Date_of_birth;
        this.mCity= City;
    }

    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        mName = Name;
    }

    public String getSurName() {
        return mSurName;
    }

    public void setSurName(String surName) {
        mSurName = surName;
    }

    public String getDate_of_birth() {
        return mDate_of_birth;
    }

    public void setDate_of_birth(String dateOfBirth) {
        mDate_of_birth = dateOfBirth;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }


    @Override
    public String toString() {
        return "User{" +
                "Name='" + mName + '\'' +
                ", Surname='" + mSurName + '\'' +
                ", DateOfBirth='" + mDate_of_birth + '\'' +
                ", City='" + mCity + '\'' +
                ", Phone=" + mPhone +
                '}';
    }
}