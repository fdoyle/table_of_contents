package com.lacronicus.tableofcontents;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fdoyle on 8/8/14.
 */
public class ActivityAdapter extends BaseAdapter {
    List<Class> activityClasses;
    Context c;

    public ActivityAdapter(Context c) {
        activityClasses = new ArrayList<Class>();
        this.c = c;
    }

    public void setContent(ActivityInfo[] content) {
        activityClasses.clear();
        try {
            for (int i = 0; i != content.length; i++) {
                activityClasses.add(getClassForActivityInfo(content[i]));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Class getClassForActivityInfo(ActivityInfo info) throws ClassNotFoundException {
        return Class.forName(info.name);
    }

    @Override
    public int getCount() {
        return activityClasses.size();
    }

    @Override
    public Class getItem(int position) {
         return activityClasses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView t = new TextView(c);
        t.setPadding(40,40,40,40);
        t.setText(activityClasses.get(position).getSimpleName());
        return t;
    }
}
