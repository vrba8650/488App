package com.example.tapsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class play_screen extends AppCompatActivity {
    private ImageButton settings;
    private Button fail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        //settings button
        settings = (ImageButton) findViewById(R.id.btnSettings);
        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSettingsActivity();
            }
        });

        //fail test
        fail = (Button) findViewById(R.id.FailButton);
        fail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openFailActivity();
            }
        });

    }
    public void openSettingsActivity(){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

    public void openFailActivity(){
        Intent intent = new Intent(this, fail.class);
        startActivity(intent);
    }
}
