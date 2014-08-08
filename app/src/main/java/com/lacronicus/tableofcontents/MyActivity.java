package com.lacronicus.tableofcontents;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MyActivity extends Activity {
    ListView l;
    ActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        l = (ListView) findViewById(R.id.lv);
        adapter = new ActivityAdapter(this);
        l.setAdapter(adapter);
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
            ActivityInfo[] activityInfos = info.activities;
            adapter.setContent(activityInfos);
            adapter.notifyDataSetChanged();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MyActivity.this, adapter.getItem(position)));
            }
        });
    }


}
