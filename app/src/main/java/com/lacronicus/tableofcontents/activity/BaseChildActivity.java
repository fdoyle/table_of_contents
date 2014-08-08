package com.lacronicus.tableofcontents.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by fdoyle on 8/8/14.
 */
public class BaseChildActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle(this.getClass().getSimpleName());
    }
}
