package com.mi.widget.xpullrefreshview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.mi.widget.xpullrefreshview.MyPullListener;
import com.mi.widget.xpullrefreshview.R;
import com.mi.xrefreshview.PullToRefreshLayout;


public class PullableWebViewActivity extends Activity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ((PullToRefreshLayout) findViewById(R.id.refresh_view))
                .setOnPullListener(new MyPullListener());
        webView = (WebView) findViewById(R.id.content_view);
        webView.loadUrl("http://blog.csdn.net/zhongkejingwang");
    }
}
