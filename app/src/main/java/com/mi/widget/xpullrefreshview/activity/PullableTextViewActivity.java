package com.mi.widget.xpullrefreshview.activity;

import android.app.Activity;
import android.os.Bundle;

import com.mi.widget.xpullrefreshview.MyPullListener;
import com.mi.widget.xpullrefreshview.R;
import com.mi.xrefreshview.PullToRefreshLayout;


public class PullableTextViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        ((PullToRefreshLayout) findViewById(R.id.refresh_view))
                .setOnPullListener(new MyPullListener());
    }
}
