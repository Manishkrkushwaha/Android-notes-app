package com.ee17b013.note;

import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class enterNote extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_note);
    }

    public void sd(View view) {
        EditText title = (EditText)findViewById(R.id.title);
        EditText note = (EditText)findViewById(R.id.note);
        String no = note.getText().toString();
        String titl = title.getText().toString();



        SharedPreferences sp = getSharedPreferences("rec",0);
        int x = Integer.valueOf(sp.getString("rec",""));
        SharedPreferences sharedPreferences = getSharedPreferences(String.valueOf(x),0);

        SharedPreferences.Editor edit = sp.edit();
        edit.putString("rec",String.valueOf(++x));
        edit.apply();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("title",titl);
        editor.putString("note",no);
        editor.apply();

        Toast.makeText(this,"Saved!",Toast.LENGTH_LONG).show();
        Intent intent1 = new Intent(enterNote.this,MainActivity.class);
        intent1.putExtra("NOTE",titl);
        startActivity(intent1);
    }
}
