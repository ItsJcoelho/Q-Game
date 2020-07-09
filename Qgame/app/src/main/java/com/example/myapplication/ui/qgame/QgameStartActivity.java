package com.example.myapplication.ui.qgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class QgameStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startgame);

        Button startGameBtn = (Button) findViewById(R.id.startgame);

        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGameActivity();
            }
        });
    }
    public void OpenGameActivity(){
        Intent intent = new Intent(this, IngameQActivity.class);
        startActivity(intent);
    }
}
