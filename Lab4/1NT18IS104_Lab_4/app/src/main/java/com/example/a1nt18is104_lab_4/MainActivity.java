package com.example.a1nt18is104_lab_4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText t1=findViewById(R.id.number);
        ImageButton call=findViewById(R.id.call_button);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = t1.getText().toString();
                Intent it = new Intent(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel:" + num));
                startActivity(it);
            }
        });
    }
}