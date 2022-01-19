package com.example.a1nt18is104_lab_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button next,prev;
    ImageView iv;
    boolean flag;
    int images[]= {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=(ImageView) findViewById(R.id.imgv);
        next=(Button) findViewById(R.id.next);
        prev=(Button) findViewById(R.id.prev);
        flag=true;

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(i==3) {
                    i=0;
                }
                else {
                    i++;
                }
                iv.setImageResource(images[i]);
            }
        });

        prev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(i==0) i=3;
                else i--;
                iv.setImageResource(images[i]);
            }
        });
    }
}