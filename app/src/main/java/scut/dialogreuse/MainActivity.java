package scut.dialogreuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textView1,textView2;
    private List<TextView> textViewList;
    private List<String[]> selectedDataList;
    private final String[] selectedData1 = {"电子电器零件", "建筑材料", "医疗器械", "家用五金", "食用器皿", "交通器材", "运动器材", "照明设备", "家电产品", "办公器具", "光学用品"};
    private final String[] selectedData2 = {"语文","数学","英语"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        textViewList = new ArrayList<TextView>();//把用到的TextView放入List
        textViewList.add(textView1);
        textViewList.add(textView2);

        selectedDataList = new ArrayList<String[]>();//把用到的选择内容字符串数组放入List
        selectedDataList.add(selectedData1);
        selectedDataList.add(selectedData2);

        //使用Dialog重用类
        DialogReuse mdialogReuse = new DialogReuse();
        mdialogReuse.DialogChooseList(this,textViewList,selectedDataList);

//        textView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("选择一个参数");
//                //    指定下拉列表的显示数据
//                final String[] productType = {"电子电器零件", "建筑材料", "医疗器械", "家用五金", "食用器皿", "交通器材", "运动器材", "照明设备", "家电产品", "办公器具", "光学用品"};
//
//                //    设置一个下拉的列表选择项
//                builder.setItems(productType, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        textView1.setText(productType[which]);
//                    }
//                });
//                builder.show();
//            }
//        });

    }
}
