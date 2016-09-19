package com.netsite.vllogin.domain.ViewModel;

/**
 * 对应xxxxxml中的View
 */
public class User {

    public String phoneNumber;
    public String password;

    public User(String phoneNumber,String password){
        this.phoneNumber=phoneNumber;
        this.password=password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
