package com.example.myapplication.ui.qgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edituser);
        ImageButton homeBtn = (ImageButton) findViewById(R.id.home);
        ImageButton toolsBtn = (ImageButton) findViewById(R.id.tools);
        ImageButton userBtn = (ImageButton) findViewById(R.id.user);

        Button editEmail = (Button) findViewById(R.id.editEmail);
        Button editUser = (Button) findViewById(R.id.editUser);

        final GlobalClass globalClass = (GlobalClass) getApplicationContext();

        final String userId = globalClass.getUserID();

        final EditText username = (EditText)findViewById(R.id.username);
        final EditText email = (EditText) findViewById(R.id.email);


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
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUserActivity();
            }
        });
        editEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                String text = username.getText().toString();
                Map<String,Object> updateUser = new HashMap<>();
                updateUser.put("username", text);

                db.collection("users")
                        .document(userId)
                        .update(updateUser)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Username Mudado",Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });
        editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                String text = email.getText().toString();
                Map<String,Object> updateEmail = new HashMap<>();
                updateEmail.put("email", text);

                db.collection("users")
                        .document(userId)
                        .update(updateEmail)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Email Mudado",Toast.LENGTH_SHORT).show();
                            }
                        });


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
    public void OpenUserActivity(){
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
}
