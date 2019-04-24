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
    String[] selected ;
    ArrayList<Integer> iter ;

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


        Bundle extras = getIntent().getExtras();
        Intent i = getIntent();

        String[] obj ;
        obj = i.getStringArrayExtra("names");
        iter = i.getIntegerArrayListExtra("iter");
        if (obj != null) {

            String[] isActive = loadData.loadArrayData(this, "isActive");
            String[] names = loadData.loadArrayData(this, obj);


            adapter = new LoadList(this, names, isActive, imgid);
            final ListView listView = findViewById(R.id.song_list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent intent = new Intent(this, UserInfo.class);
//                    intent.putExtra("user", position);
                }
            });


        }







        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();


    }
}
