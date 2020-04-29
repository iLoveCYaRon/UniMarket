package moe.sui.unimarket.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

import moe.sui.unimarket.R;

public class UniPullRefreshLayout extends QMUIPullRefreshLayout {

    public UniPullRefreshLayout(Context context) {
        super(context);
    }

    public UniPullRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UniPullRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected View createRefreshView() {
        RefreshView refreshView = new RefreshView(getContext());
        refreshView.setColorSchemeResources(R.color.colorBackground);
        return refreshView;
    }
}
