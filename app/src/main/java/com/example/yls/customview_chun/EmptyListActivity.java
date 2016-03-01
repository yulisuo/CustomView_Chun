package com.example.yls.customview_chun;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EmptyListActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter adapter;
    ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initListView();
    }

    private void initListView() {
        lv = (ListView) findViewById(R.id.listView_empty);
        data = new ArrayList<String>();
        data.add("1");
        data.add("2");
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        lv.setAdapter(adapter);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_add:
                int num = data.size();
                data.add(""+num);
                break;
            case R.id.btn_del:
                data.remove(data.size() - 1);
                break;
            default:
                break;
        }
        adapter.notifyDataSetChanged();
    }
}
