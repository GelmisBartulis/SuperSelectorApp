package com.ge20070469.customlists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private CheckBox cb;
    private Button next;
    private ListView list;
    private LoadList adapter;
    private String[] selected;

    Integer[] imgid={
            R.drawable.profile_1, R.drawable.profile_2,
            R.drawable.profile_3, R.drawable.profile_4,
            R.drawable.profile_5, R.drawable.profile_6,
            R.drawable.profile_7,  R.drawable.profile_8,
            R.drawable.profile_9,  R.drawable.profile_10,
            R.drawable.profile_11,  R.drawable.profile_12
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadData loadData = new LoadData();

        next = findViewById(R.id.next);
        final String[] names = loadData.loadArrayData(this, "name");
        String[] isActive = loadData.loadArrayData(this, "isActive");
        adapter = new LoadList(this,names, isActive, imgid, R.layout.list );
        final ListView listView = (ListView) findViewById(R.id.song_list);
        listView.setAdapter(adapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str  = "";
                if(adapter.mCheckStates.size() > 0) {
                    StringBuilder result = new StringBuilder();
                    for(int i=0;i<adapter.mCheckStates.size();i++) {
                        if(adapter.mCheckStates.get(i)) {
                            result.append(names[i]);
                            result.append("\n");
                            str = result.toString();
                            selected = str.split("[\\r\\n]+");
                        }
                    }
                    Intent intent = new Intent(getApplicationContext(), ShowUser.class);
                    intent.putExtra("names", selected);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Sorry, you didn't select anything", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
