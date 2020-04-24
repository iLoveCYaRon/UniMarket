package moe.sui.unimarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.qmuiteam.qmui.widget.QMUITopBar;

import moe.sui.unimarket.fragment.ProductDetailFragment;

public class ProductViewActivity extends AppCompatActivity {

    public static void actionStart(Context context, String productTitle, String imageUri, String productContent) {
        Intent intent = new Intent(context, ProductViewActivity.class);
        intent.putExtra("title", productTitle);
        intent.putExtra("uri", imageUri);
        intent.putExtra("content", productContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        String imageUri = getIntent().getStringExtra("uri");

        ProductDetailFragment productDetailFragment = (ProductDetailFragment) getSupportFragmentManager().findFragmentById(R.id.product_detail_frag);
        productDetailFragment.refresh(title, imageUri, content);

    }
}
