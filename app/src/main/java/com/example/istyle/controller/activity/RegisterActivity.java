package com.example.istyle.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.istyle.R;
import com.example.istyle.model.Model;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    EditText registerName;
    EditText registerPassword;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        //获取输入的用户名和密码
        String user_name = registerName.getText().toString();
        String user_password = registerPassword.getText().toString();


        //校验输入的用户名和密码
        if(TextUtils.isEmpty(user_name)||TextUtils.isEmpty(user_password)){
            Toast.makeText(RegisterActivity.this,"输入的用户名或密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }


        //去服务器注册账号
        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    EMClient.getInstance().createAccount(user_name,user_password);

                    //注册成功，更新页面显示
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (HyphenateException e) {
                    e.printStackTrace();

                    //注册失败，更新页面显示
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this,"注册失败"+e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
    private void initView(){
        registerName = findViewById(R.id.register_name);
        registerPassword = findViewById(R.id.register_password);
        registerButton = findViewById(R.id.register_btn);
    }
}