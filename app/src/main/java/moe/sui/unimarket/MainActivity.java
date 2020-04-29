package moe.sui.unimarket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;
import com.youth.banner.Banner;

import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import moe.sui.unimarket.adapter.MainBannerAdapter;
import moe.sui.unimarket.datamodel.APITest;
import moe.sui.unimarket.datamodel.CustomerAuth;
import moe.sui.unimarket.datamodel.Media;
import moe.sui.unimarket.datamodel.MediaAPI;
import moe.sui.unimarket.datamodel.PermissionsUtils;
import moe.sui.unimarket.datamodel.Post;
import moe.sui.unimarket.datamodel.PostAPI;
import moe.sui.unimarket.datamodel.Product;
import moe.sui.unimarket.datamodel.ProductAPI;
import moe.sui.unimarket.fragment.ProductTitleFragment;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static moe.sui.unimarket.datamodel.CustomerAuth.auth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TopBar设置
        QMUITopBar topBar = findViewById(R.id.main_TopBar);
        topBar.addLeftImageButton(R.drawable.ic_main_logo, R.id.empty_view_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        topBar.addRightImageButton(R.drawable.ic_main_search, R.id.empty_view_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProductTitleActivity.class));
            }
        });
        ImageView searchView = new ImageView(getApplicationContext());
        searchView.setImageResource(R.drawable.main_search_bar);
        searchView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        topBar.setCenterView(searchView);

        // 下拉刷新
        QMUIPullRefreshLayout pullRefresh = findViewById(R.id.pull_to_refresh);


        //判断用户令牌是否有效
        SharedPreferences pref=getSharedPreferences("authtoken", Context.MODE_PRIVATE);
        if (pref.contains("token") ){
        SharedPreferences sharedPreferences=getSharedPreferences("token", Context.MODE_PRIVATE);
        String user_token=sharedPreferences.getString("token","");
        try {
            if(CustomerAuth.authValidate(user_token))
                Toast.makeText(MainActivity.this, "自动登录成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }}

        // 在Android 4.0以上，网络连接不能放在主线程上，不+然就会报错android.os.NetworkOnMainThreadException
        new Thread(new Runnable(){
            @Override
            public void run() {
                APITest.run();

                List<Post> postList = PostAPI.listPost();
                assert postList != null;
                for(Post post : postList) {
                    Media media = MediaAPI.getMedia(post.getFeatured_media());
                    post.setLink(media.getSource_url());;
                }
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putSerializable("postList", (Serializable) postList);
                msg.setData(bundle);
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }).start();
    }



    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:
                    // 1代表图片列表加载完毕 可以开始载入图片和轮播
                    Banner banner = findViewById(R.id.banner);
                    // 开始轮播
                    banner.setAdapter(new MainBannerAdapter((ArrayList<Post>) msg.getData().getSerializable("postList")))
                            .setBannerRound2(BannerUtils.dp2px(6))
                            .setIndicator(new CircleIndicator(getApplicationContext()))
                            .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                            .setIndicatorSelectedColorRes(R.color.colorPrimary)
                            .setIndicatorNormalColorRes(R.color.colorAlphaBackground)
                            .setIndicatorNormalWidth((int) BannerUtils.dp2px(6))
                            .setIndicatorSelectedWidth((int) BannerUtils.dp2px(6))
                            .setIndicatorMargins(new IndicatorConfig.Margins((int) BannerUtils.dp2px(12)))
                            .start();

                    break;
            }
        }
    };
}
