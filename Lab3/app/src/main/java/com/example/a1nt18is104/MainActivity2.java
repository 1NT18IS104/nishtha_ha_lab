package com.example.a1nt18is104;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView result= findViewById(R.id.result);
        Intent it= getIntent();
        String sum= it.getStringExtra("ans");
        result.setText(sum);
    }
}