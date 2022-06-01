package com.example.listjsonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> names = new ArrayList<>();
        names.add("Вешенская");
        names.add("Боковская");
        names.add("Ростов-на-Дону");
        names.add("Москва");
        names.add("Нью-Йорк");

        List<String> ids = new ArrayList<>();
        ids.add("11035");
        ids.add("100557");
        ids.add("39");
        ids.add("213");
        ids.add("202");


        ListView listView = findViewById(R.id.LVLocality);
        ArrayAdapter<String> adapter=  new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(MainActivity.this, "Нажатие на" + ids.get(position),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("id",ids.get(position));
            startActivity(intent);
        });

    }
}