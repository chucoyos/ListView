package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView lv;
    ArrayAdapter<String> adapter;
    String [] names = {"Pedro", "Pablo", "Pepe", "Toño","Kaori"};
    String [] edades = {"18", "25", "45", "54", "7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        lv = findViewById(R.id.lv);
        adapter = new ArrayAdapter<>(this, R.layout.list_view_item, names);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(String.format("%s %s, %s %s", getText(R.string.name), lv.getItemAtPosition(position), getText(R.string.age), edades[position] ));
            }
        });
    }
}