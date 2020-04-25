package moe.sui.unimarket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import static moe.sui.unimarket.datamodel.CustomerAuth.auth;

public class signin extends AppCompatActivity implements View.OnClickListener {

    private EditText username;     //存储读入用户名，密码
    private EditText password;


    //对按钮的各自初始化
    protected  void onCreat(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button) findViewById(R.id.button);
        username = (EditText) findViewById(R.id.account);
        password=(EditText)findViewById(R.id.pwd);
        button.setOnClickListener(this);
    }

    @Override             //点击登录按钮后执行操作
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String user=username.getText().toString();
                String pass=password.getText().toString();
                try {
                    auth(user,pass);
                } catch (IOException e) {
                    e.printStackTrace();
                }break;
            default:
                break;
        }
    }
}
