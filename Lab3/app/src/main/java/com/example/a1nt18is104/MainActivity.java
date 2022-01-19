package com.example.a1nt18is104;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void sum(){
        EditText first= findViewById(R.id.num_one);
        EditText second= findViewById(R.id.num_two);

        Intent it;
        it= new Intent(this, MainActivity2.class);
        Button add= findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1= Integer.parseInt(first.getText().toString());
                int num2= Integer.parseInt(second.getText().toString());
                int ans= num1+num2;
                it.putExtra("ans",ans+"");
                startActivity(it);

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "Activity created", Toast.LENGTH_SHORT).show();
        sum();
    }

    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(), "Activity started", Toast.LENGTH_SHORT).show();
    }

    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(), "Activity paused", Toast.LENGTH_SHORT).show();
    }

    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(), "Activity resumed", Toast.LENGTH_SHORT).show();
    }

    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), "Activity stopped", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Activity destroyed", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Activity restarted", Toast.LENGTH_SHORT).show();
    }
}