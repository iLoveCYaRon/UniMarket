package moe.sui.unimarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.youth.banner.Banner;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import moe.sui.unimarket.adapter.ImageNetAdapter;

import moe.sui.unimarket.datamodel.APITest;
import moe.sui.unimarket.datamodel.PermissionsUtils;
import moe.sui.unimarket.datamodel.Product;
import moe.sui.unimarket.datamodel.ProductAPI;
import moe.sui.unimarket.fragment.ProductTitleFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TopBar设置
        QMUITopBar topBar = findViewById(R.id.main_TopBar);
        topBar.addLeftImageButton(R.drawable.ic_main_logo, R.id.empty_view_button);
        topBar.addRightImageButton(R.drawable.ic_main_search, R.id.empty_view_button);
        ImageView searchView = new ImageView(getApplicationContext());
        searchView.setImageResource(R.drawable.main_search_bar);
        searchView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        topBar.setCenterView(searchView);


        // 设置按钮监听
//        Button button = findViewById(R.id.btn_viewAllProduct);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ProductTitleActivity.class);
//                startActivity(intent);
//            }
//        });

        // 在Android 4.0以上，网络连接不能放在主线程上，不+然就会报错android.os.NetworkOnMainThreadException
        new Thread(new Runnable(){
            @Override
            public void run() {
                APITest.run();

                List<Product> productList = ProductAPI.listProduct();
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putSerializable("productList", (Serializable) productList);
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
                    banner.setAdapter(new ImageNetAdapter((ArrayList<Product>) msg.getData().getSerializable("productList")))
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
