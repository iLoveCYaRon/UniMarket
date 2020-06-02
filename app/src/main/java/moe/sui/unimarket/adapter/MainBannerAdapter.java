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
import java.util.Objects;

import moe.sui.unimarket.ProductViewActivity;
import moe.sui.unimarket.R;
import moe.sui.unimarket.datamodel.MediaAPI;
import moe.sui.unimarket.datamodel.Post;
import moe.sui.unimarket.datamodel.Product;
import moe.sui.unimarket.fragment.ProductTitleFragment;

class BannerItemHolder extends RecyclerView.ViewHolder {
    PhotoView photoView;
    TextView textView;

    BannerItemHolder(View view) {
        super(view);

        photoView = view.findViewById(R.id.banner_photo);
        textView =  view.findViewById(R.id.banner_title);
    }
}


public class MainBannerAdapter extends BannerAdapter<Post, BannerItemHolder> {
    private Context mContext;
    public MainBannerAdapter(List<Post> mDatas) {
        super(mDatas);
    }

    @Override
    public BannerItemHolder onCreateHolder(ViewGroup parent, int viewType) {
        PhotoView photoView = new PhotoView(parent.getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.banner_item, parent,false);
        view.setLayoutParams(params);
        return new BannerItemHolder(view);
    }

    @Override
    public void onBindView(BannerItemHolder holder, Post data, int position, int size) {
        holder.textView.setText(data.getTitleRendered());
        Glide.with(mContext)
                .load(data.getFeatMediaLink())
                .into(holder.photoView);
        holder.photoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

}