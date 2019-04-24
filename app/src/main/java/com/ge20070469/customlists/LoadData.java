package com.ge20070469.customlists;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LoadData {

    String[] output;
    String id, name, age, about, isActive;
    ArrayList<String> userList;

    public String[] loadArrayData(Context context, String key) {

        try {
            JSONArray obj = new JSONArray(loadJSONFromAsset(context));

            userList = new ArrayList<String>();

            for (int i = 0; i < obj.length(); i++) {
                JSONObject info = obj.getJSONObject(i);
                id = info.getString("_id");
                age = info.getString("age");
                name = info.getString("name");
                about = info.getString("about");
                isActive = info.getString("isActive");

                switch (key) {
                    case "id":
                        userList.add(id);
                        break;
                    case "name":
                        userList.add(name);
                        break;
                    case "age":
                        userList.add(age);
                        break;
                    case "about":
                        userList.add(about);
                        break;
                    case "isActive":
                        userList.add(isActive);
                        break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        output = userList.toArray(new String[userList.size()]);

        return output;
    }


    public String[] loadArrayData(Context context, String[] names) {

        try {
            JSONArray obj = new JSONArray(loadJSONFromAsset(context));

            userList = new ArrayList<String>();

            for(int j = 0; j < names.length; j++) {

                for (int i = 0; i < obj.length(); i++) {
                    JSONObject info = obj.getJSONObject(i);
                    name = info.getString("name");
                    if(names[j].equals(name)) {
                        userList.add(name);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        output = userList.toArray(new String[userList.size()]);

        return output;
    }


    private String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("users.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
