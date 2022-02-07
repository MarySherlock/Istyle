package com.example.istyle.model;

import android.content.Context;
import android.view.Display;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//data model global class
public class Model {
    private Context mContext;
    private ExecutorService executors = Executors.newCachedThreadPool();
    private static Model model = new Model();

    private Model(){

    }

    public static Model getInstance(){
        return model;
    }

    public void init(Context context){
        mContext = context;
    }

    public  ExecutorService getGlobalThread(){
        return  executors;
    }
}
