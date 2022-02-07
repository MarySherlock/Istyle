package com.example.istyle.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.istyle.R;
import com.example.istyle.model.Model;
import com.hyphenate.chat.EMClient;

public class SplashActivity extends Activity {

    private Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            //current activity exited, don't handle the message
            if(isFinishing()){
                return;
            }
            else{
                //judge which view should the app get in
                toMainOrLogin();
            }
        }
    };

    private void toMainOrLogin() {

        Model.getInstance().getGlobalThread().execute(new Runnable() {
            @Override
            public void run() {
                //judge user login
                if(EMClient.getInstance().isLoggedInBefore()){
                    //signed in

                    //gain user's information

                    //turn to main page
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    //not

                    //turn to login page
                    Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                }

                //end current page
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //send 2 seconds delay message
        handler.sendMessageDelayed(Message.obtain(),2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //destroy message
        handler.removeCallbacksAndMessages(null);
    }
}