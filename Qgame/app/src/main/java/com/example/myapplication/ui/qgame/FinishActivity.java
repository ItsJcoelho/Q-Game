package com.example.myapplication.ui.qgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishgame);
        final GlobalClass globalClass = (GlobalClass) getApplicationContext();
        Button returnbtn = (Button) findViewById(R.id.returnhome);

        TextView correctCount = findViewById(R.id.textView10);
        TextView pointsCount = findViewById(R.id.textView6);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        correctCount.setText("0" + globalClass.getQuantity().toString() + "/10");
        if (globalClass.getQuantity() < 10){
            correctCount.setText("0" + globalClass.getQuantity().toString() + "/10");
        }
        else{
            correctCount.setText(globalClass.getQuantity().toString() + "/10");
        }
        pointsCount.setText(globalClass.getScore().toString());
        final String userID = globalClass.getUserID();
        final String username = globalClass.getUserName();
        final String password = globalClass.getUserPassword();
        final String email = globalClass.getUserLogged();
        final Integer credits = Integer.parseInt(globalClass.getUserCredits()) ;
        final Integer points = globalClass.getScore() + Integer.parseInt(globalClass.getUserPoints());

        final Map<String,Object> updatePoints = new HashMap<>();
        updatePoints.put("points", points);
        final Map<String,Object> updateLastPoints = new HashMap<>();
        updatePoints.put("lastPoints", globalClass.getScore());
        final Map<String,Object> updateLastScore = new HashMap<>();
        updatePoints.put("lastScore", globalClass.getQuantity());
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("users")
                        .document(userID)
                        .update(updateLastPoints)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                            }
                        });
                db.collection("users")
                        .document(userID)
                        .update(updateLastScore)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                            }
                        });
                db.collection("users")
                        .document(userID)
                        .update(updatePoints)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                globalClass.setQuantity(0);
                                globalClass.setScore(0);
                                ReturnHomeActivity();
                            }
                        });

            }
        });
    }
    public void ReturnHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
