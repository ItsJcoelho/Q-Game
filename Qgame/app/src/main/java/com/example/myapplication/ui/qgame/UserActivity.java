package com.example.myapplication.ui.qgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final GlobalClass globalClass = (GlobalClass) getApplicationContext();

        ImageButton homeBtn = (ImageButton) findViewById(R.id.home);
        ImageButton toolsBtn = (ImageButton) findViewById(R.id.tools);
        Button badgesbtn = (Button) findViewById(R.id.badges);

        TextView username = (TextView) findViewById(R.id.username);
        TextView credits = (TextView) findViewById(R.id.credits);
        TextView points = (TextView) findViewById(R.id.points);
        TextView lastScore = (TextView) findViewById(R.id.lastScore);
        TextView lastPoints = (TextView) findViewById(R.id.pointsPre);

        username.setText(globalClass.getUserName());
        credits.setText(globalClass.getUserCredits());
        points.setText(globalClass.getUserPoints());
        lastScore.setText(globalClass.getUserLastScore());
        lastPoints.setText(globalClass.getUserLastPoints());


        homeBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            OpenHomeActivity();
        }
    });
        toolsBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            OpenToolsActivity();
        }
    });
        badgesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenBadgesActivity();
            }
        });
}
    public void OpenHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void OpenToolsActivity(){
        Intent intent = new Intent(this, ToolsActivity.class);
        startActivity(intent);
    }
    public void OpenBadgesActivity(){
        Intent intent = new Intent(this, BadgesActivity.class);
        startActivity(intent);
    }


}
