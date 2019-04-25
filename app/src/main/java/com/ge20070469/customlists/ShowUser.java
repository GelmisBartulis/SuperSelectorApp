package com.ge20070469.customlists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ShowUser extends AppCompatActivity {


    private ListView list;
    private LoadList adapter;
    private String[] obj ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);
        LoadData loadData = new LoadData();

        Integer[] imgid={
                R.drawable.profile_1, R.drawable.profile_2,
                R.drawable.profile_3, R.drawable.profile_4,
                R.drawable.profile_5, R.drawable.profile_6,
                R.drawable.profile_7,  R.drawable.profile_8,
                R.drawable.profile_9,  R.drawable.profile_10,
                R.drawable.profile_11,  R.drawable.profile_12
        };
        Intent i = getIntent();
        obj = i.getStringArrayExtra("names");

        if (obj != null) {
            String[] isActive = loadData.loadArrayData(this, "isActive");
            String[] names = loadData.loadArrayData(this, obj);

            adapter = new LoadList(this, names, isActive, imgid, R.layout.list1);
            final ListView listView = findViewById(R.id.song_list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Log.i("position!!!", " " + parent.getItemAtPosition(position));
                    String name = parent.getItemAtPosition(position) + "";
                    Intent intent = new Intent(getApplicationContext(), UserInfo.class);
                    intent.putExtra("user", name);
                    startActivity(intent);
                }
            });
        }
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
    }
}
