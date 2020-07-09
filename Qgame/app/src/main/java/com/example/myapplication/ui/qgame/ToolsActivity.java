package com.example.myapplication.ui.qgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.R;

public class ToolsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final GlobalClass globalClass = (GlobalClass) getApplicationContext();

        ImageButton homeBtn = (ImageButton) findViewById(R.id.home);
        ImageButton userBtn = (ImageButton) findViewById(R.id.user);
        Button userEditBtn = (Button) findViewById(R.id.editUser);
        Button logOutBtn = (Button) findViewById(R.id.logOut);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenHomeActivity();
            }
        });
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUserActivity();
            }
        });
        userEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUserEditActivity();
            }
        });
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalClass.setUserLogged("");
                globalClass.setUserName("");
                globalClass.setUserPassword("");
                globalClass.setUserID("");
                globalClass.setUserPoints("");
                globalClass.setUserCredits("");
                globalClass.setUserLastScore("");
                globalClass.setUserLastPoints("");
                OpenStartActivity();
                Toast.makeText(getApplicationContext(),"Volte Sempre!",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void OpenUserActivity(){
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
    public void OpenHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void OpenUserEditActivity(){
        Intent intent = new Intent(this, UserSettingsActivity.class);
        startActivity(intent);
    }
    public void OpenStartActivity(){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}
