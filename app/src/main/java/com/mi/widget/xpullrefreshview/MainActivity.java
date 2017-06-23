package com.mi.widget.xpullrefreshview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.mi.widget.xpullrefreshview.activity.PullableExpandableListViewActivity;
import com.mi.widget.xpullrefreshview.activity.PullableGifActivity;
import com.mi.widget.xpullrefreshview.activity.PullableGridViewActivity;
import com.mi.widget.xpullrefreshview.activity.PullableImageViewActivity;
import com.mi.widget.xpullrefreshview.activity.PullableListViewActivity;
import com.mi.widget.xpullrefreshview.activity.PullableRecyclerViewActivity;
import com.mi.widget.xpullrefreshview.activity.PullableScrollViewActivity;
import com.mi.widget.xpullrefreshview.activity.PullableTextViewActivity;
import com.mi.widget.xpullrefreshview.activity.PullableWebViewActivity;
import com.mi.xrefreshview.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PullToRefreshLayout pullToRefreshLayout = ((PullToRefreshLayout) findViewById(R.id.refresh_view));
        pullToRefreshLayout.setOnPullListener(new MyPullListener());
        pullToRefreshLayout.setOnRefreshProcessListener(new MyOnPullProcessListener());
        listView = (ListView) pullToRefreshLayout.getPullableView();
        initListView();
    }

    /**
     * ListView初始化方法
     */
    private void initListView() {
        List<String> items = new ArrayList<>();
        items.add(getString(R.string.listview));
        items.add(getString(R.string.recyclerview));
        items.add(getString(R.string.gif_listview));
        items.add(getString(R.string.grid_view));
        items.add(getString(R.string.expandable_listview));
        items.add(getString(R.string.scrollview));
        items.add(getString(R.string.webview));
        items.add(getString(R.string.imageview));
        items.add(getString(R.string.textview));
        MyAdapter adapter = new MyAdapter(this, items);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        " LongClick on "
                                + parent.getAdapter().getItemId(position),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        intent.setClass(MainActivity.this,
                                PullableListViewActivity.class);
                        break;
                    case 1:
                        intent.setClass(MainActivity.this,
                                PullableRecyclerViewActivity.class);
                        break;
                    case 2:
                        intent.setClass(MainActivity.this,
                                PullableGifActivity.class);
                        break;
                    case 3:
                        intent.setClass(MainActivity.this,
                                PullableGridViewActivity.class);
                        break;
                    case 4:
                        intent.setClass(MainActivity.this,
                                PullableExpandableListViewActivity.class);
                        break;
                    case 5:
                        intent.setClass(MainActivity.this,
                                PullableScrollViewActivity.class);
                        break;
                    case 6:
                        intent.setClass(MainActivity.this,
                                PullableWebViewActivity.class);
                        break;
                    case 7:
                        intent.setClass(MainActivity.this,
                                PullableImageViewActivity.class);
                        break;
                    case 8:
                        intent.setClass(MainActivity.this,
                                PullableTextViewActivity.class);
                        break;

                    default:
                        break;
                }
                startActivity(intent);
            }
        });
    }


    public class MyOnPullProcessListener implements PullToRefreshLayout.OnPullProcessListener {

        @Override
        public void onPrepare(View v, int which) {
            Log.e("ActivityHome","onPrepare"+which);

        }

        @Override
        public void onStart(View v, int which) {
            Log.e("ActivityHome","onStart"+which);

        }

        @Override
        public void onHandling(View v, int which) {
            Log.e("ActivityHome","onHandling"+which);

        }

        @Override
        public void onFinish(View v, int which) {
            Log.e("ActivityHome","onFinish"+which);

        }

        @Override
        public void onPull(View v, float pullDistance, int which) {
            Log.e("ActivityHome","onPull"+which +" dis="+pullDistance);
        }

    }
}
