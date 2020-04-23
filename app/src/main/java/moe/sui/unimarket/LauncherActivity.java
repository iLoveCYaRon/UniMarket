package moe.sui.unimarket;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        new Thread( new Runnable( ) {
            @Override
            public void run() {
                //耗时任务，比如加载网络数据
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //这是网上的另一种方法，不过newinstance方法没有实现所以使用下面那种
                        //Intent intent = MainActivity.newinstance(LauncherActivity.this);
                        //startActivity(intent);
                        goHome();
                        LauncherActivity.this.finish();// 销毁当前活动界面
                    }
                });
            }
        } ).start();
    }


    private void goHome() {
        startActivity(new Intent(LauncherActivity.this, MainActivity.class));
    }

}