package moe.sui.unimarket.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.youth.banner.Banner;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;

import moe.sui.unimarket.ProductViewActivity;
import moe.sui.unimarket.R;
import moe.sui.unimarket.datamodel.APITest;
import moe.sui.unimarket.datamodel.Product;
import moe.sui.unimarket.datamodel.ProductAPI;

public class ProductTitleFragment extends Fragment {

    // ProductAdapter 内部类
    class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
        private Context mContext;
        private List<Product> mProductList;

        class ViewHolder extends RecyclerView.ViewHolder {
            CardView cardView;
            ImageView imageView;
            TextView textView;

            ViewHolder(View view) {
                super(view);

                cardView = (CardView) view;
                imageView = view.findViewById(R.id.product_view);
                textView =  view.findViewById(R.id.product_name);
            }
        }

        ProductAdapter(List<Product> productList) {
            mProductList = productList;
        }

        @NotNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (mContext == null) {
                mContext = parent.getContext();
            }
            View view = LayoutInflater.from(mContext).inflate(R.layout.product_item_card,parent,false);
            final ViewHolder viewHolder =  new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Product product = mProductList.get(viewHolder.getAdapterPosition());
                    ProductViewActivity.actionStart(getActivity(), product.getName(), product.getImages().get(0).getSrc(),
                            product.getDescription());
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder,int position) {
            Product product = mProductList.get(position);
            holder.textView.setText(product.getName());
            Glide.with(mContext).load(product.getImages().get(0).getSrc()).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return mProductList.size();
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.product_title_frag, container, false);
        // 在Android 4.0以上，网络连接不能放在主线程上，不+然就会报错android.os.NetworkOnMainThreadException
        new Thread(new Runnable(){
            @Override
            public void run() {
                List<Product> productList = ProductAPI.listProduct();
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putSerializable("productList", (Serializable) productList);
                bundle.putSerializable("container", (Serializable) container);
                msg.setData(bundle);
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }).start();

        // 设置topBar
        QMUITopBar topBar = view.findViewById(R.id.topbar);
        topBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
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
                    // 获取完数据，可以加载recyclerView
                    RecyclerView recyclerView = Objects.requireNonNull(getView()).findViewById(R.id.product_title_recycler_view);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(new ProductAdapter((List<Product>) msg.getData().getSerializable("productList")));
                    break;
            }
        }
    };

}

