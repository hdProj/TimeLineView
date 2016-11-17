package com.example.donghe.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected RecyclerView recyclerView;
    private TimeAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.ultimate_recycler_view);
        ArrayList<TimeLineModel> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            TimeLineModel time = new TimeLineModel();
            time.setAge(139);
            time.setName("物流时间线");
            list.add(time);
        }
        //目前只支持linearlayout
        adapter = new TimeAdapter(this, list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }


}
