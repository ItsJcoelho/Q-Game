package com.example.myapplication.ui.qgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Log in:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //btn
        Button loginbtn = (Button) findViewById(R.id.login);
        Button signbtn = (Button) findViewById(R.id.signup);
        //text
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        //GlobalVariables
        final GlobalClass globalClass = (GlobalClass) getApplicationContext();
        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSignActivity();
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Strings
                String msg ="";

                final String usernametext =username.getText().toString();
                final String passwordtext =password.getText().toString();
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("users")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                Boolean check = false;

                                if(task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {

                                        if (usernametext.equals(document.getData().get("username"))){
                                            check = true;
                                            globalClass.setUserLogged(document.getData().get("email").toString());
                                            globalClass.setUserName(document.getData().get("username").toString());
                                            globalClass.setUserPassword(document.getData().get("password").toString());
                                            globalClass.setUserPoints(document.getData().get("points").toString());
                                            globalClass.setUserCredits(document.getData().get("credits").toString());
                                            globalClass.setUserLastPoints(document.getData().get("lastPoints").toString());
                                            globalClass.setUserLastScore(document.getData().get("lastScore").toString());
                                            globalClass.setUserID(document.getId());
                                            Log.d(TAG, "password: " + globalClass.getUserPassword());
                                            Log.d(TAG, "username: " + globalClass.getUserName());
                                            Log.d(TAG, "email: " + globalClass.getUserLogged());
                                            Log.d(TAG, "points: " + globalClass.getUserPoints());
                                            Log.d(TAG, "credits: " + globalClass.getUserCredits());
                                            Log.d(TAG, "ID: " + globalClass.getUserID());
                                        }
                                        if (passwordtext.equals(document.getData().get("password"))){
                                            check = true;
                                        }

                                }
                                }
                                else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                }
                                if (check){
                                    Toast.makeText(getApplicationContext(),"Login bem sucedido",Toast.LENGTH_SHORT).show();
                                    OpenHomeActivity();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"Dados incorretos",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    public void OpenSignActivity(){
        Intent intent = new Intent(this, SignActivity.class);
        startActivity(intent);
    }
    public void OpenHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}
