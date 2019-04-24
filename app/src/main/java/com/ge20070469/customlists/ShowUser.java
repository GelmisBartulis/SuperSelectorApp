package com.ge20070469.customlists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;

public class ShowUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        Bundle extras = getIntent().getExtras();
        String[] selected;

        Object obj;
        if (extras != null) {
            obj = extras.get("name");
            // and get whatever type user account id is

            selected = Arrays.asList(obj).toArray(new String[0]);

            for (int i = 0; i < selected.length; i++) {
                Log.i("selected", selected[i]);
            }

        }
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();


    }
}
