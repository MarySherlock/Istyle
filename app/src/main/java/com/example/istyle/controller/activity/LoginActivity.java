package com.example.istyle.controller.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.istyle.R;

public class LoginActivity extends Activity {

    Animation loginAnimation;

    ImageView imageView;
    EditText userPassword;
    EditText userName;
    TextView userRegister;
    TextView newPassword;
    CheckBox notice;
    Button userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
        loginAnimation();

        //注册
        userRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        //登录
        userLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //忘记密码
        newPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,ChangePasswordActivity.class);
                startActivity(intent);
            }
        });



    }

    private void initView()
    {
        loginAnimation = AnimationUtils.loadAnimation(this, R.anim.login_anim);

        imageView = findViewById(R.id.splash_img);
        userName = findViewById(R.id.user_name);
        userPassword = findViewById(R.id.user_password);
        userRegister = findViewById(R.id.user_register);
        newPassword = findViewById(R.id.forgot_password);
        notice = findViewById(R.id.notice);
        userLogin = findViewById(R.id.login_btn);
    }
    private void loginAnimation(){

        ObjectAnimator startAnimator = ObjectAnimator.ofFloat(imageView,"alpha",1f,0.85f);
        startAnimator.setDuration(2000);
        startAnimator.start();

        userName.startAnimation(loginAnimation);
        userPassword.startAnimation(loginAnimation);
        userLogin.startAnimation(loginAnimation);
        userRegister.startAnimation(loginAnimation);
        notice.startAnimation(loginAnimation);
        newPassword.startAnimation(loginAnimation);

    }

}