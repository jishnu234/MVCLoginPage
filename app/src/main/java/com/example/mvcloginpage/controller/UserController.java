package com.example.mvcloginpage.controller;

import com.example.mvcloginpage.model.User;
import com.example.mvcloginpage.view.IView;

public class UserController implements IController{

    IView loginView;

    public UserController(IView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void OnLogin(String email, String password) {

        User user = new User(email, password);

        int loginCode = user.isValid();

        switch (loginCode) {

            case 0:
                loginView.OnLoginError("Enter the Email");
                break;
            case 1:
                loginView.OnLoginError("Enter a valid email address ");
                break;
            case 2:
                loginView.OnLoginError("Enter the password");
                break;
            case 3:
                loginView.OnLoginError("The password should have atleast 8 character");
                break;
            case -1:
                loginView.OnLoginSuccess("Login Successful");
                break;
            default:
                break;
        }
    }
}
