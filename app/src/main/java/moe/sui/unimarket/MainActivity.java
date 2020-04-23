package moe.sui.unimarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.widget.EditText;

import java.io.IOException;

import moe.sui.unimarket.datamodel.APITest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 在Android 4.0以上，网络连接不能放在主线程上，不然就会报错android.os.NetworkOnMainThreadException
        new Thread(new Runnable(){
            @Override
            public void run() {
                APITest.run();
            }
        }).start();
    }
}
