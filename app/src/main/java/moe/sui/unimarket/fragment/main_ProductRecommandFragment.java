package moe.sui.unimarket.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.qmuiteam.qmui.widget.popup.QMUIPopups;
import com.qmuiteam.qmui.widget.popup.QMUIQuickAction;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import moe.sui.unimarket.ProductViewActivity;
import moe.sui.unimarket.R;
import moe.sui.unimarket.datamodel.Product;
import moe.sui.unimarket.datamodel.ProductAPI;

public class main_ProductRecommandFragment extends Fragment {

    private QMUITipDialog dialog;

    // ProductAdapter 内部类
    class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
        private Context mContext;
        private List<Product> mProductList;

        class ViewHolder extends RecyclerView.ViewHolder {
            CardView cardView;
            ImageView productPhoto;
            TextView title;
            TextView shortDescription;
            TextView price;
            ImageButton option;

            ViewHolder(View view) {
                super(view);
                cardView = (CardView) view;
                productPhoto = view.findViewById(R.id.product_view);
                title = view.findViewById(R.id.textViewTitle);
                shortDescription = view.findViewById(R.id.textViewDesci);
                price = view.findViewById(R.id.textViewPrice);
                option = view.findViewById(R.id.buttonOption);
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
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main,parent,false);
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

            // 设置卡片文本
            holder.title.setText(product.getName());
            holder.price.setText(product.getPrice());
            String description =  product.getShort_description();
            description = description.substring(3, description.length()-5);
            holder.shortDescription.setText(description);

            // 设置按钮弹出菜单
            holder.option.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QMUIPopups.quickAction(getContext(),
                            QMUIDisplayHelper.dp2px(getContext(), 56),
                            QMUIDisplayHelper.dp2px(getContext(), 56))
                            .shadow(true)
                            .shadowElevation(50, 1f)
                            .skinManager(QMUISkinManager.defaultInstance(getContext()))
                            .edgeProtection(QMUIDisplayHelper.dp2px(getContext(), 10))
                            .addAction(new QMUIQuickAction.Action().icon(R.drawable.ic_logo).text("复制").onClick(
                                    new QMUIQuickAction.OnClickListener() {
                                        @Override
                                        public void onClick(QMUIQuickAction quickAction, QMUIQuickAction.Action action, int position) {
                                            quickAction.dismiss();
                                            Toast.makeText(getContext(), "复制成功", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                            ))
                            .addAction(new QMUIQuickAction.Action().icon(R.drawable.ic_logo).text("划线").onClick(
                                    new QMUIQuickAction.OnClickListener() {
                                        @Override
                                        public void onClick(QMUIQuickAction quickAction, QMUIQuickAction.Action action, int position) {
                                            quickAction.dismiss();
                                            Toast.makeText(getContext(), "划线成功", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                            ))
                            .addAction(new QMUIQuickAction.Action().icon(R.drawable.ic_logo).text("分享").onClick(
                                    new QMUIQuickAction.OnClickListener() {
                                        @Override
                                        public void onClick(QMUIQuickAction quickAction, QMUIQuickAction.Action action, int position) {
                                            quickAction.dismiss();
                                            Toast.makeText(getContext(), "分享成功", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                            ))
                            .show(v);
                }
            });
            // 加载图片
            Glide.with(mContext).load(product.getTitleImageLink()).into(holder.productPhoto);
        }
        @Override
        public int getItemCount() {
            return mProductList.size();
        }
    }
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        refreshProduct();

        // 设置RecyclerView
        List<Product> productList = SQLite.select()
                .from(Product.class)
                .queryList();

        //RecyclerView recyclerView = view.findViewById(R.id.main_product_title_recycler_view);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //recyclerView.setLayoutManager(linearLayoutManager);
        //recyclerView.setAdapter(new ProductAdapter(productList));


        return view;
    }

    private void refreshProduct() {

        // 在Android 4.0以上，网络连接不能放在主线程上，不+然就会报错android.os.NetworkOnMainThreadException
        new Thread(new Runnable(){
            @Override
            public void run() {
                List<Product> productList = ProductAPI.listProduct();
                ModelAdapter<Product> adapter = FlowManager.getModelAdapter(Product.class);
                adapter.deleteAll(SQLite.select().from(Product.class).queryList());
                for (Product product : productList) {
                    product.setTitleImageLink(product.getImages().get(0).getSrc());
                    adapter.insert(product);
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
                    // 获取完数据，可以加载recyclerView
                    //RecyclerView recyclerView = Objects.requireNonNull(getView()).findViewById(R.id.main_product_title_recycler_view);
                    //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    //recyclerView.setLayoutManager(linearLayoutManager);
                    //recyclerView.setAdapter(new ProductAdapter(SQLite.select().from(Product.class).queryList()));
                    break;
            }
        }
    };

}

