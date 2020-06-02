package moe.sui.unimarket.fragment;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Objects;

import moe.sui.unimarket.R;
import moe.sui.unimarket.datamodel.Product;
import moe.sui.unimarket.datamodel.ProductAPI;

public class ProductDetailFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        view = inflater.inflate(R.layout.product_detail_frag, container, false);
        QMUITopBar topBar = view.findViewById(R.id.detail_TopBar);
        topBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        topBar.addRightImageButton(R.drawable.ic_detail_share, R.id.empty_view_button);
        topBar.setTitle("商品详情");

        LinearLayout btn = view.findViewById(R.id.FloatButtonLayout);
        btn.bringToFront();
        return view;
    }

    public void refresh(final int productID) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Product product = ProductAPI.getProduct(productID);
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putSerializable("product", product);
                msg.setData(bundle);
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:
                    // 获取完数据，可以加载recyclerView
                    Product product = (Product) msg.getData().getSerializable("product");
                    TextView price = view.findViewById(R.id.textPrice);
                    price.setText(product.getPrice());

                    TextView title = view.findViewById(R.id.textTitle);
                    title.setText(product.getName());

                    PhotoView photoView = view.findViewById(R.id.headerImage);
                    photoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    Glide.with(view).load(product.getImages().get(0).getSrc()).into(photoView);

                    WebView webView = view.findViewById(R.id.detail_web);
                    webView.getSettings().setBlockNetworkImage(false);//解决图片不显示
                    webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
                    String contex = product.getDescription();
                    contex = contex.replaceAll("http", "https");
                    webView.loadData(contex, "text/html", "UTF-8");

                    ImageView back = view.findViewById(R.id.imageView3);
                    back.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    };
}
