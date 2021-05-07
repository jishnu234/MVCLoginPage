package com.example.mvcloginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvcloginpage.controller.IController;
import com.example.mvcloginpage.controller.UserController;
import com.example.mvcloginpage.view.IView;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements IView {

    TextInputLayout userEmail;
    TextInputLayout userPassword;
    UserController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmail = findViewById(R.id.email_field);
        userPassword = findViewById(R.id.password_field);
        controller = new UserController(this);

        Toast.makeText(this, "This Screen follows" +
                " MVC design pattern for validation", Toast.LENGTH_LONG).show();

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.my_primary_color));

    }

    public void logIn(View view) {

        controller.OnLogin(userEmail.getEditText().getText().toString().trim(),
                userPassword.getEditText().getText().toString().trim());

    }

    @Override
    public void OnLoginSuccess(String message) {

//        userPassword.setError("");
//        userEmail.setError("");
        userEmail.getEditText().setText("");
        userPassword.getEditText().setText("");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnLoginError(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}