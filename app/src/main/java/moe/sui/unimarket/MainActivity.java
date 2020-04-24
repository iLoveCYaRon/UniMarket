package moe.sui.unimarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.youth.banner.Banner;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import moe.sui.unimarket.adapter.ImageNetAdapter;
import moe.sui.unimarket.adapter.ProductAdapter;
import moe.sui.unimarket.datamodel.APITest;
import moe.sui.unimarket.datamodel.Product;
import moe.sui.unimarket.datamodel.ProductAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TopBar设置
        QMUITopBar topBar = findViewById(R.id.main_TopBar);
        topBar.setTitle("优易");
        topBar.addLeftImageButton(R.drawable.ic_account, R.id.empty_view_button);
        topBar.addRightImageButton(R.drawable.ic_search, R.id.empty_view_button);


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
                    banner.setAdapter(new ImageNetAdapter((ArrayList<Product>) msg.getData().getSerializable("productList")));
                    banner.start();

//                    GridLayoutManager layoutManager = new GridLayoutManager(getParent(), 2);
//                    ProductAdapter adapter = new ProductAdapter((ArrayList<Product>) msg.getData().getSerializable("productList"));
//                    RecyclerView recyclerView = findViewById(R.id.recycler_view);
//                    recyclerView.setLayoutManager(layoutManager);
//                    recyclerView.setAdapter(adapter);
                    break;
            }
        }
    };

}
