package com.ee17b013.note;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String title;

        ListView listView = (ListView) findViewById(R.id.lv);
        ArrayList arrayList = new ArrayList<String>();
        ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        SharedPreferences sp = getSharedPreferences("rec",0);
        SharedPreferences.Editor edi = sp.edit();
        if(sp.getString("rec","")=="")
        {
            edi.putString("rec",String.valueOf(1));
            edi.apply();
        }

        for(int i=1;i<=Integer.valueOf(sp.getString("rec",""));i++)
        {
            SharedPreferences sharedPreferences = getSharedPreferences(String.valueOf(i),0);
            title = sharedPreferences.getString("title","");
            arrayList.add(title);
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ReadNote.class);
                intent.putExtra("pos",String.valueOf(position));
                startActivity(intent);
            }
        });

    }
    public void enterNote(View view){
        Intent intent = new Intent(MainActivity.this, enterNote.class);
        startActivity(intent);
    }
    public void refresh(View view) {

    }
}

