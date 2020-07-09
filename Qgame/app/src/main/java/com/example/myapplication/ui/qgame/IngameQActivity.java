package com.example.myapplication.ui.qgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class IngameQActivity extends AppCompatActivity {



    private static final String TAG = "Log in:";
    public Integer choosen = 0;
    public String clicked = "";
    public Integer rightOne = 0;
    public Integer questionIndex = 1;
    public Integer quantyRight = 0;
    public Integer points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qgame_ingame);
        final GlobalClass globalClass = (GlobalClass) getApplicationContext();
        final Button onebtn = (Button) findViewById(R.id.one);
        final Button twobtn = (Button) findViewById(R.id.two);
        final Button threebtn = (Button) findViewById(R.id.three);
        final Button fourbtn = (Button) findViewById(R.id.four);
        final Button next = (Button) findViewById(R.id.next);
        final TextView question = findViewById(R.id.textView8);
        final TextView ref = findViewById(R.id.textView9);

        //Getting the first question
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("questions")
                .whereEqualTo("number",questionIndex)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                onebtn.setText(document.getData().get("first").toString());
                                twobtn.setText(document.getData().get("second").toString());
                                threebtn.setText(document.getData().get("third").toString());
                                fourbtn.setText(document.getData().get("forth").toString());
                                question.setText(document.getData().get("question").toString());
                                rightOne = Integer.parseInt(document.getData().get("answer").toString());

                            }
                        } else {
                            Log.d(TAG, "Error: ");
                        }
                    }
                });


        onebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(clicked == "two"){
                    twobtn.setTextColor(Color.BLACK);
                    twobtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    onebtn.setTextColor(Color.WHITE);
                    onebtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "one";
                    choosen = 2;
                }
                else if(clicked == "three"){
                    //remover outra seleção
                    threebtn.setTextColor(Color.BLACK);
                    threebtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    onebtn.setTextColor(Color.WHITE);
                    onebtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "one";
                    choosen = 3;
                }
                else if(clicked == "four"){
                    //remover outra seleção
                    fourbtn.setTextColor(Color.BLACK);
                    fourbtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    onebtn.setTextColor(Color.WHITE);
                    onebtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "one";
                    choosen = 4;
                }
                else{
                    //selecionado
                    onebtn.setTextColor(Color.WHITE);
                    onebtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "one";
                    choosen = 1;

                }

            }
        });
        twobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == "one"){
                    onebtn.setTextColor(Color.BLACK);
                    onebtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    twobtn.setTextColor(Color.WHITE);
                    twobtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "two";
                    choosen = 1;
                }
                else if(clicked == "three"){
                    //remover outra seleção
                    threebtn.setTextColor(Color.BLACK);
                    threebtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    twobtn.setTextColor(Color.WHITE);
                    twobtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "two";
                    choosen = 3;
                }
                else if(clicked == "four"){
                    //remover outra seleção
                    fourbtn.setTextColor(Color.BLACK);
                    fourbtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    twobtn.setTextColor(Color.WHITE);
                    twobtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "two";
                    choosen = 4;
                }
                else{
                    //selecionado
                    twobtn.setTextColor(Color.WHITE);
                    twobtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "two";
                    choosen = 2;

                }
            }
        });
        threebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == "one"){
                    onebtn.setTextColor(Color.BLACK);
                    onebtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    threebtn.setTextColor(Color.WHITE);
                    threebtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "three";
                    choosen = 1;
                }
                else if(clicked == "two"){
                    //remover outra seleção
                    twobtn.setTextColor(Color.BLACK);
                    twobtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    threebtn.setTextColor(Color.WHITE);
                    threebtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "three";
                    choosen = 2;
                }
                else if(clicked == "four"){
                    //remover outra seleção
                    fourbtn.setTextColor(Color.BLACK);
                    fourbtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    threebtn.setTextColor(Color.WHITE);
                    threebtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "three";
                    choosen = 4;
                }
                else{
                    //selecionado
                    threebtn.setTextColor(Color.WHITE);
                    threebtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "three";
                    choosen = 3;

                }
            }
        });
        fourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == "one"){
                    onebtn.setTextColor(Color.BLACK);
                    onebtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    fourbtn.setTextColor(Color.WHITE);
                    fourbtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "four";
                    choosen = 1;
                }
                else if(clicked == "two"){
                    //remover outra seleção
                    twobtn.setTextColor(Color.BLACK);
                    twobtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    fourbtn.setTextColor(Color.WHITE);
                    fourbtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "four";
                    choosen = 2;
                }
                else if(clicked == "three"){
                    //remover outra seleção
                    threebtn.setTextColor(Color.BLACK);
                    threebtn.setBackgroundResource(R.drawable.button_awnser);
                    //selecionado
                    fourbtn.setTextColor(Color.WHITE);
                    fourbtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "four";
                    choosen = 3;
                }
                else{
                    //selecionado
                    fourbtn.setTextColor(Color.WHITE);
                    fourbtn.setBackgroundResource(R.drawable.button_awnser_choosen);
                    clicked = "four";
                    choosen = 4;
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                questionIndex++;
                if(questionIndex == 15){
                    next.setText("Terminar");
                }
                if(questionIndex > 15){
                    FinishGame();
                }
                if(clicked != ""){
                    fourbtn.setTextColor(Color.BLACK);
                    fourbtn.setBackgroundResource(R.drawable.button_awnser);
                    threebtn.setTextColor(Color.BLACK);
                    threebtn.setBackgroundResource(R.drawable.button_awnser);
                    twobtn.setTextColor(Color.BLACK);
                    twobtn.setBackgroundResource(R.drawable.button_awnser);
                    onebtn.setTextColor(Color.BLACK);
                    onebtn.setBackgroundResource(R.drawable.button_awnser);
                    clicked = "";
                    Log.d(TAG, "ans"+ rightOne.toString());
                    Log.d(TAG, "choosen"+choosen.toString());
                    if(choosen == rightOne ){
                        Log.d(TAG, "HIII!!");
                        points+=100;
                        globalClass.setScore(points);
                        quantyRight++;
                        globalClass.setQuantity(quantyRight);
                        Log.d(TAG, globalClass.getQuantity().toString());
                        Log.d(TAG, globalClass.getScore().toString());
                        choosen=0;
                    }
                    else{
                        choosen=0;
                    }

                    if (questionIndex < 10){
                        ref.setText("0"+questionIndex.toString()+"/15");
                    }
                    else{
                        ref.setText(questionIndex.toString()+"/15");
                    }

                    db.collection("questions")
                            .whereEqualTo("number",questionIndex)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                            onebtn.setText(document.getData().get("first").toString());
                                            twobtn.setText(document.getData().get("second").toString());
                                            threebtn.setText(document.getData().get("third").toString());
                                            fourbtn.setText(document.getData().get("forth").toString());
                                            question.setText(document.getData().get("question").toString());
                                            rightOne = Integer.parseInt(document.getData().get("answer").toString());


                                        }
                                    } else {
                                        Log.d(TAG, "Error: ");
                                    }
                                }
                            });

                }
                else {
                    Toast.makeText(getApplicationContext(),"Selecione uma resposta",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void FinishGame(){
        Intent intent = new Intent(this, FinishActivity.class);
        startActivity(intent);
    }
}
