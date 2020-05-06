package moe.sui.unimarket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.youth.banner.Banner;

import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;

import java.io.IOException;
import java.util.List;

import moe.sui.unimarket.adapter.MainBannerAdapter;
import moe.sui.unimarket.datamodel.CustomerAuth;
import moe.sui.unimarket.datamodel.Media;
import moe.sui.unimarket.datamodel.MediaAPI;
import moe.sui.unimarket.datamodel.Post;
import moe.sui.unimarket.datamodel.PostAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //判断用户令牌是否有效
        // SharedPreferences pref=getSharedPreferences("authtoken", Context.MODE_PRIVATE);
        //if (pref.contains("token") ){
        SharedPreferences sharedPreferences =getSharedPreferences("token", Context.MODE_PRIVATE);
        final String user_token=sharedPreferences.getString("token",null);
        if(user_token!=null){
            //网络请求需要在线程上进行
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if(CustomerAuth.authValidate(user_token)){
                            //线程中不能直接调用toast
                            Looper.prepare();
                            LoginActivity.setstatue(true);
                            Toast.makeText(MainActivity.this, "自动登录成功", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // TopBar设置
        QMUITopBar topBar = findViewById(R.id.detail_TopBar);
        topBar.addLeftImageButton(R.drawable.ic_main_logo, R.id.empty_view_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LoginActivity.isLogin_statue(false)){
                    Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);}
                else{
                    Intent intent=new Intent(MainActivity.this,PersonalPageActivity.class);
                    startActivity(intent);
                }
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

        final QMUIPullRefreshLayout pullRefresh = findViewById(R.id.pull_to_refresh);
        pullRefresh.setOnPullListener(new QMUIPullRefreshLayout.OnPullListener() {
            @Override
            public void onMoveTarget(int offset) {

            }

            @Override
            public void onMoveRefreshView(int offset) {

            }

            @Override
            public void onRefresh() {
                pullRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateDatabase();
                    }
                }, 2000);
            }
        });


        Message msg = new Message();
        msg.what = 1;
        handler.sendMessage(msg);

        pullRefresh.setToRefreshDirectly();
    }


    private void updateDatabase() {

        // 获取Post, 获取完存放到SQLite数据库并发送Msg请求刷新UI
        new Thread(new Runnable(){
            @Override
            public void run() {
                ModelAdapter<Post> adapter = FlowManager.getModelAdapter(Post.class);
                List<Post> postList = PostAPI.listPost();
                assert postList != null;
                for(Post post : postList) {
                    Media media = MediaAPI.getMedia(post.getFeatured_media());
                    post.setFeatMediaLink(media.getSource_url());
                    post.setContentRendered(post.getContent().getRendered());
                    post.setTitleRendered(post.getTitle().getRendered());
                    if(!adapter.exists(post))
                        adapter.insert(post);
                }

                Message msg = new Message();
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

                    List<Post> users = SQLite.select()
                            .from(Post.class)
                            .queryList();

                    // 开始轮播
                    banner.setAdapter(new MainBannerAdapter(users))
                            .setBannerRound2(BannerUtils.dp2px(6))
                            .setIndicator(new CircleIndicator(getApplicationContext()))
                            .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                            .setIndicatorSelectedColorRes(R.color.colorPrimary)
                            .setIndicatorNormalColorRes(R.color.colorAlphaBackground)
                            .setIndicatorNormalWidth((int) BannerUtils.dp2px(6))
                            .setIndicatorSelectedWidth((int) BannerUtils.dp2px(6))
                            .setIndicatorMargins(new IndicatorConfig.Margins((int) BannerUtils.dp2px(12)))
                            .start();
                    QMUIPullRefreshLayout pullRefresh = findViewById(R.id.pull_to_refresh);
                    pullRefresh.finishRefresh();


                    break;
            }
        }
    };
}
