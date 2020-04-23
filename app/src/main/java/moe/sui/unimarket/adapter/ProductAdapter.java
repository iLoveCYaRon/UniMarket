package moe.sui.unimarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import moe.sui.unimarket.R;
import moe.sui.unimarket.datamodel.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context mContext;
    private List<Product> mProductList;

    static class ViewHolder extends RecyclerView.ViewHolder {
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
        return new ViewHolder(view);
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
