package moe.sui.unimarket.adapter;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

public class UniMarketApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
