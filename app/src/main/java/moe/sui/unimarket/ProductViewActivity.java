package moe.sui.unimarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.qmuiteam.qmui.widget.QMUITopBar;

import moe.sui.unimarket.fragment.ProductDetailFragment;

public class ProductViewActivity extends AppCompatActivity {

    public static void actionStart(Context context, int productID) {
        Intent intent = new Intent(context, ProductViewActivity.class);
        intent.putExtra("ID", productID);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        int productId = getIntent().getIntExtra("ID",0);

        ProductDetailFragment productDetailFragment = (ProductDetailFragment) getSupportFragmentManager().findFragmentById(R.id.product_detail_frag);
        productDetailFragment.refresh(productId);

    }
}
