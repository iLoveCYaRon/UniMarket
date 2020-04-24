package moe.sui.unimarket.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import moe.sui.unimarket.R;

public class ProductDetailFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        view = inflater.inflate(R.layout.product_detail_frag, container, false);
        return view;
    }

    public void refresh(String productTitle, String imageUri, String productContent) {
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView productTitleText = view.findViewById(R.id.product_name);
        PhotoView photoView = view.findViewById(R.id.detail_photo);
        TextView productContentText = view.findViewById(R.id.product_content);

        productTitleText.setText(productTitle);
        Glide.with(this).load(imageUri).into(photoView);
        productContentText.setText(productContent);
    }
}
