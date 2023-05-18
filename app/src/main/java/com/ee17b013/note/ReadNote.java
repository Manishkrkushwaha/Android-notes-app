package com.ee17b013.note;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ReadNote extends AppCompatActivity {
    TextView not;
    TextView titl;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);

        not = (TextView)findViewById(R.id.note);
        titl = (TextView)findViewById(R.id.title);

        x=Integer.valueOf(getIntent().getExtras().getString("pos"));
        SharedPreferences sharedPreferences = getSharedPreferences(String.valueOf(x+1),0);


      //  SharedPreferences sharedPreferences = getSharedPreferences("data",0);

        String note = sharedPreferences.getString("note","");
        String title = sharedPreferences.getString("title","");

        not.setText(note);
        titl.setText(title);
    }

    public void editnote(View view) {
        Intent intent = new Intent(ReadNote.this,editact.class);
        intent.putExtra("int",String.valueOf(x+1));
        startActivity(intent);
    }
}
