package com.example.a1nt18is104_lab_5;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer, mediaPlayer_two;
    int starttime = 0 ; // startime is 0s
    int stopttime = 0; // stoptime is 0s by default
    int forwardtime = 5000 ; // 5s for forward
    int backwardtime = 5000 ; // 5s for backwardtime
    int currentpos;
    TextView songtitle;
    Button play;
    Button pause;
    Button forward;
    Button rewind;
    Button stop;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.second);
        mediaPlayer_two=MediaPlayer.create(this, R.raw.second);;
         songtitle= findViewById(R.id.songname);
         play= findViewById(R.id.play);
         pause= findViewById(R.id.pause);
         forward= findViewById(R.id.forward);
         rewind= findViewById(R.id.rewind);
         stop= findViewById(R.id.stop);
         reset= findViewById(R.id.restart);

        songtitle.setText("second.mp3");

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Playing Media now", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Media paused", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentpos= mediaPlayer.getCurrentPosition();
                if((currentpos+forwardtime) <= (stopttime = mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos+forwardtime);
                }
            }
        });
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentpos= mediaPlayer.getCurrentPosition();
                if((currentpos-backwardtime) >= 0){
                    mediaPlayer.seekTo(currentpos-backwardtime);

                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Media stopped", Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer=mediaPlayer_two;
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mediaPlayer.reset();
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        });
    }
}