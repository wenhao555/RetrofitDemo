package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        strToJson();

    }

    private void strToJson() {
        JsonArray array = new JsonArray();
        JsonObject object = new JsonObject();
        JsonObject obj = new JsonObject();
        object.addProperty("name", "ta");
        object.addProperty("name2", "ta2");
        array.add(object);
        obj.addProperty("a1", new Gson().toJson(array));
        Log.e("la", obj.toString());
        //查看数组转字符串
    }
}
