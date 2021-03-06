package com.harry.mpv;

import android.app.Activity;
import android.os.Bundle;  
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;
  
public class QtFullscreenActivity extends org.qtproject.qt5.android.bindings.QtActivity
{  
    private final static String TAG = "QtFullscreen";

    private static String m_request_url;
    private static QtFullscreenActivity m_instance;
    public QtFullscreenActivity() {
        m_instance = this;
    }
    public static String getUrl() {
        return m_instance.m_request_url;
    }

    @Override  
    public void onCreate(Bundle savedInstanceState) {                   
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        // https://github.com/wang-bin/QtAV/blob/master/examples/QMLPlayer/main.cpp
        Intent intent = getIntent();
        String action = intent.getAction();

        if (intent.ACTION_VIEW.equals(action)) {
            m_request_url = intent.getDataString();
        }
    }
}
