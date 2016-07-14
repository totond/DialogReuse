package scut.dialogreuse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import java.util.List;


//对话框大量重用类
public class DialogReuse {


    //重用选择对话框使用入口，调用此方法，输入三个参数：上下文，绑定后的TextView列表，选择内容列表数组。
    public void DialogChooseList(final Context context, List<TextView> textViews,List<String[]> selectedDataList){
        for (int i = 0;i<textViews.size();i++){
//            System.out.println(selectedDataList.get(i)[0]);
//            System.out.println("textViews是否空"+ (textViews.get(i) == null));
//            System.out.println("context是否空"+(context == null));
            textViews.get(i).setOnClickListener(new DialogOnClickListener(textViews.get(i),selectedDataList.get(i),context));
        }
    }

    //重写Dialog的点击监听器，让它可以传入TextView,List<String>等参数
    class DialogSelectedItemOnClickListener implements DialogInterface.OnClickListener{
        private TextView ctv;
        private String[] selectedList;
        public DialogSelectedItemOnClickListener(TextView ctextView, String[] sList){
            ctv = ctextView;
            selectedList = sList;
        }
        //设置点击事件
        @Override
        public void onClick(DialogInterface dialog, int which) {
            ctv.setText(selectedList[which]);
        }
    }

    //重写TextView的点击监听器，让它可以传入TextView,List<String>等参数
    class DialogOnClickListener implements View.OnClickListener{
        private TextView textView;
        private String[] selectedList;
        private Context mcontext;
        public DialogOnClickListener(TextView tv,String[] sList,Context context){
            textView = tv;
            selectedList = sList;
            mcontext = context;
        }

        //设置点击事件
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
            builder.setTitle("选择一个参数");
            //    设置一个下拉的列表选择项
            builder.setItems(selectedList, new DialogSelectedItemOnClickListener(textView,selectedList));
            builder.show();
        }
    }
}
