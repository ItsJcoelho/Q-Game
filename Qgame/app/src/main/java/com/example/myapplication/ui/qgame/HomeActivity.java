package com.example.myapplication.ui.qgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button qGameBtn = (Button) findViewById(R.id.qgame);
        Button pickerBtn = (Button) findViewById(R.id.picker);
        Button searcherBtn = (Button) findViewById(R.id.googlesearch);
        ImageButton userBtn = (ImageButton) findViewById(R.id.user);
        ImageButton toolsBtn = (ImageButton) findViewById(R.id.tools);

        searcherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSearcherActivity();
            }
        });
        pickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPickerActivity();
            }
        });
        qGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenQGameActivity();
            }
        });
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUserActivity();
            }
        });
        toolsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenToolsActivity();
            }
        });


    }

    public void OpenQGameActivity(){
        Intent intent = new Intent(this, QgameStartActivity.class);
        startActivity(intent);
    }
    public void OpenUserActivity(){
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
    public void OpenToolsActivity(){
        Intent intent = new Intent(this, ToolsActivity.class);
        startActivity(intent);
    }
    public void OpenPickerActivity(){
        Intent intent = new Intent(this, PickerStartActivity.class);
        startActivity(intent);
    }
    public void OpenSearcherActivity(){
        Intent intent = new Intent(this, SeacherStartActivity.class);
        startActivity(intent);
    }
}
