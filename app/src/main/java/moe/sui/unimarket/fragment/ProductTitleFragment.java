package moe.sui.unimarket.fragment;

import android.content.Context;
import android.os.Bundle;
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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import moe.sui.unimarket.ProductViewActivity;
import moe.sui.unimarket.R;
import moe.sui.unimarket.datamodel.Product;
import moe.sui.unimarket.datamodel.ProductAPI;

public class ProductTitleFragment extends Fragment {

    class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
        private Context mContext;
        private List<Product> mProductList;

         class ViewHolder extends RecyclerView.ViewHolder {
            CardView cardView;
            ImageView imageView;
            TextView textView;

            public ViewHolder(View view) {
                super(view);

                cardView = (CardView) view;
                imageView = view.findViewById(R.id.product_view);
                textView =  view.findViewById(R.id.product_name);
            }
        }

        public ProductAdapter(List<Product> productList) {
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
                    ProductViewActivity.actionStart(getActivity(), product.getName(), //product.getImages().get(0).getSrc(),
                            product.getDescription());
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder,int position) {
            Product product = mProductList.get(position);
            holder.textView.setText(product.getName());
            //Glide.with(mContext).load(product.getImages().get(0).getSrc()).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return mProductList.size();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_title_frag, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.product_title_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        ProductAdapter adapter = new ProductAdapter(getProduct());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<Product> getProduct() {
        List<Product> productList = new ArrayList<>();
        for (int i = 1; i<10; i++) {
            Product product = new Product();
            product.setName("Name" + i);
            product.setDescription("This is drsifsaidnjkf" + i);
            productList.add(product);
        }
        return  productList;
    }
}

