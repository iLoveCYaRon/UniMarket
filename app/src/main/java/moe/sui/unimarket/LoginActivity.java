package moe.sui.unimarket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import static moe.sui.unimarket.datamodel.CustomerAuth.auth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;     //存储读入用户名，密码
    private EditText password;
    String token;


    @Override
    //对按钮的各自初始化
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.btn_login);
        username = findViewById(R.id.account);
        password = findViewById(R.id.pwd);
        button.setOnClickListener(this);
    }

    @Override             //点击登录按钮后执行操作
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                String user = username.getText().toString();
                String pass = password.getText().toString();
                login(user,pass);
                break;
                default:
                break;
        }
    }

    //子线程，进行登录操作
    private void login(final String user, final String pass){
       new Thread(new Runnable(){
           @Override
           public void run(){
               try {
                   token=auth("Yui","xs&(!g$ekBOJU!OxJH");
                   if(token!=null) {
                       Message message = new Message();
                       message.what = 1;
                       message.obj = "登录成功";

                   }else{
                       Message message=new Message();
                       message.what=2;
                       message.obj = "登录失败";
                   }

               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }

    //根据返回的token不同，进行不同操作
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    //Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    //startActivity(intent);
                    break;
                case 2:
                    Toast.makeText(LoginActivity.this, "登录失败，请重试", Toast.LENGTH_SHORT).show();
                    break;
                default:break;
            }
        }

    };

}