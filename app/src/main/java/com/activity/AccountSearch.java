package com.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imooc.weixin6_0.R;


public class AccountSearch extends Activity {

    private TextView textView ;
    private ImageButton button ;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Rect rect = new Rect();
        button.getWindowVisibleDisplayFrame(rect);
        Window window = getWindow();
        int statusBarHeight = rect.top;// 状态栏的高度
        int contentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT).getTop(); // 标题栏跟状态栏的总体高度
        int titleBarHeight = contentViewTop - statusBarHeight;// 标题栏的高度：用上面的值减去状态栏的高度及为标题栏高度
        LinearLayout.LayoutParams para = new LinearLayout.LayoutParams(titleBarHeight,titleBarHeight);
        button.setLayoutParams(para);

        textView = (TextView)window.findViewById(R.id.text);
        textView.setText("账号筛选");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); // 注意顺序
        setContentView(R.layout.activity_account_search);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,      // 注意顺序
                R.layout.title_account_info);

        button = (ImageButton) findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountSearch.this.setResult(RESULT_OK);
                AccountSearch.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_account_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
