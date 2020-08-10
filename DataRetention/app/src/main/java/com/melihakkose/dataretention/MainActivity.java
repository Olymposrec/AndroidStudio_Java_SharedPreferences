package com.melihakkose.dataretention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText =findViewById(R.id.editTextNumber);
        textView=findViewById(R.id.textView);

        sharedPreferences =this.getSharedPreferences("com.melihakkose.dataretention", Context.MODE_PRIVATE);
        int age =40;

        int storedAge=sharedPreferences.getInt("storedAge",0);
        if(storedAge==0){
            textView.setText("Your Age:");
        }else{
            textView.setText("Your Age:"+storedAge);
        }


    }
    public void save(View view) {
        if(!editText.getText().toString().matches("")){
            int age=Integer.parseInt(editText.getText().toString());
            textView.setText("Your age:"+age);
            sharedPreferences.edit().putInt("storedAge",age).apply();
        }
    }
    public void delete(View view) {
        int storedData=sharedPreferences.getInt("storedAge",0);
        if(storedData!=0){
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your Age:");
        }

    }
}