package com.ee17b013.note;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editact extends AppCompatActivity {
    EditText title;
    EditText note;
    String val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editact);

        title = (EditText)findViewById(R.id.title);
        note = (EditText)findViewById(R.id.note);
        val = getIntent().getExtras().getString("int");
        SharedPreferences sharedPreferences = getSharedPreferences(val,0);

        title.setText(sharedPreferences.getString("title",""));
        note.setText(sharedPreferences.getString("note",""));
    }

    public void saveText(View view) {
        String til = title.getText().toString();
        String not = note.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences(val,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("title",til);
        editor.putString("note",not);
        editor.apply();

        Toast.makeText(this,"Changes Saved !!!",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(editact.this,MainActivity.class);
        startActivity(intent);
    }
}
