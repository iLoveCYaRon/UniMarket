package moe.sui.unimarket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import java.net.ServerSocket;
import java.net.Socket;

public class PersonalPageActivity  extends AppCompatActivity  {
    private Object PersonalPageActivity;
    // private ServerSocket ButterKnife;

    @SuppressLint("Assert")
    @Override
    //对按钮的各自初始化
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_page);

        QMUIGroupListView groupListView = findViewById(R.id.person_page);

     //  Context context=getApplicationContext();
       // QMUIGroupListView item1 =;
       // QMUIGroupListView.Section setion=QMUIGroupListView.newSection(context);
       // setion.setTitle("喜欢列表");
       // setion.addTo(item1);
       QMUICommonListItemView listItemView=groupListView.createItemView("喜欢列表");
       QMUICommonListItemView listItemView1=groupListView.createItemView("历史记录");
       QMUICommonListItemView listItemView2=groupListView.createItemView("售后");
       QMUICommonListItemView listItemView3=groupListView.createItemView("设置");
       QMUICommonListItemView listItemView4=groupListView.createItemView("关于");
       QMUICommonListItemView listItemView5=groupListView.createItemView("信用");

  listItemView.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUIGroupListView.newSection(this)
                .addItemView(listItemView,null)
                .addItemView(listItemView1,null)
                .addItemView(listItemView2,null)
                .addItemView(listItemView3,null)
                .addItemView(listItemView4,null)
                .addItemView(listItemView5,null)
                .addTo(groupListView);

}
}
