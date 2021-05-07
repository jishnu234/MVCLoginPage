package com.example.mvcloginpage.model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IModel {

    String email;
    String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValid() {

        if(TextUtils.isEmpty(getEmail())) {
            return 0;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            return 1;
        } else if(TextUtils.isEmpty(getPassword())) {
            return 2;
        } else if(getPassword().length() <= 7) {
            return 3;
        } else{
            return -1;
        }

    }
}