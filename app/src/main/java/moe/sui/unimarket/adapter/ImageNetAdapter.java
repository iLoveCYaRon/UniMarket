package moe.sui.unimarket.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.github.chrisbanes.photoview.PhotoView;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;

import moe.sui.unimarket.ProductViewActivity;
import moe.sui.unimarket.R;
import moe.sui.unimarket.datamodel.Product;
import moe.sui.unimarket.fragment.ProductTitleFragment;

class ImageHolder extends RecyclerView.ViewHolder {
//    public PhotoView photoView;

    CardView cardView;
    ImageView imageView;
    TextView textView;

    ImageHolder(View view) {
        super(view);

        cardView = (CardView) view;
        imageView = view.findViewById(R.id.product_view);
        textView =  view.findViewById(R.id.product_name);
    }
}


public class ImageNetAdapter extends BannerAdapter<Product, ImageHolder> {

    private Context mContext;
    public ImageNetAdapter(List<Product> mDatas) {
        super(mDatas);
    }

    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
//        PhotoView imageView = new PhotoView(parent.getContext());
//        //通过裁剪实现圆角
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
//        imageView.setLayoutParams(params);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        return new ImageHolder(imageView);
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_item_card, parent,false);
        view.setLayoutParams(params);
        return new ImageHolder(view);
    }

    @Override
    public void onBindView(ImageHolder holder, Product data, int position, int size) {
        holder.textView.setText(data.getName());
        Glide.with(mContext).load(data.getImages().get(0).getSrc()).into(holder.imageView);
//        Glide.with(holder.itemView)
//                .load(data.getImages().get(0).getSrc())
//                .into(holder.photoView);

    }

}