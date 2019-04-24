package com.ge20070469.customlists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private CheckBox cb;
    private Button next;

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



        next = findViewById(R.id.next);


        LoadData loadData = new LoadData();
        String[] names = loadData.loadArrayData(this, "name");
        String[] isActive = loadData.loadArrayData(this, "isActive");

        final LoadList adapter = new LoadList(this, names, isActive, true, imgid);
        ListView list = findViewById(R.id.song_list);
        list.setAdapter(adapter);

//
//        public void onSubmit(View v)
//        {
//            SparseBooleanArray checked = listview.getCheckedItemPositions();
//            ArrayList<String> selectedItems = new ArrayList<String>();
//            for (int i = 0; i < checked.size(); i++) {
//                // Item position in adapter
//                int position = checked.keyAt(i);
//                // Add player if it is checked i.e.) == TRUE!
//                if (checked.valueAt(i))
//                    selectedItems.add(adapter.getItem(position));
//            }
//
//            // String[] outputStrArr = new String[selectedItems.size()];
//
//            for (int i = 0; i < selectedItems.size(); i++) {
//                // outputStrArr[i] = selectedItems.get(i);
//                Toast.makeText(getApplicationContext(), selectedItems.get(i),Toast.LENGTH_LONG).show();
//            }
//
//        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Log.i("Changes", i + " ");




//
//
//                    Intent intent = new Intent(getApplicationContext(), ShowUser.class);
//                    intent.putExtra("id", i);
//                    startActivity(intent);
            }
        });
    }

}
