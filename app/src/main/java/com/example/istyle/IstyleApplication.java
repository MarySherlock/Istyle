package com.example.istyle;

import android.app.Application;

import com.example.istyle.model.Model;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseIM;

public class IstyleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化环信SDK
        EMOptions options = new EMOptions();
        options.setAcceptInvitationAlways(false);
        options.setAutoAcceptGroupInvitation(false);

        EaseIM.getInstance().init(this,options);

        Model.getInstance().init(this);
    }

}
