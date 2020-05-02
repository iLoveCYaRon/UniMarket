package moe.sui.unimarket;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

public class PersonalPageActivity  extends AppCompatActivity  {
    @Override
    //对按钮的各自初始化
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_page);
        //QMUIGroupListView groupListView = findViewById(R.id.grouplistview);

        Context context=getApplicationContext();
        QMUIGroupListView item1 = new QMUIGroupListView(context);
        QMUIGroupListView.Section setion=QMUIGroupListView.newSection(context);
      //  setion.setTitle("喜欢列表");
      //  setion.addTo(item1);

    }
}
