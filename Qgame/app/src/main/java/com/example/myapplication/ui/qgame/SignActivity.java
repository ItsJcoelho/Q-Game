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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.HashMap;
import java.util.Map;

public class SignActivity extends AppCompatActivity {

    private static final String TAG = "Sign in:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        //btn
        Button loginbtn = (Button) findViewById(R.id.login);
        Button signbtn = (Button) findViewById(R.id.sign);
        //text
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        final EditText confirm = (EditText)findViewById(R.id.confirm);
        final EditText email = (EditText)findViewById(R.id.email);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
        FirebaseFirestore.setLoggingEnabled(true);

        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                        .setTimestampsInSnapshotsEnabled(true)
                        .build();
                db.setFirestoreSettings(settings);
                FirebaseFirestore.setLoggingEnabled(true);

                String usernameText = username.getText().toString();
                String passwordText = password.getText().toString();
                String confirmText = confirm.getText().toString();
                String emailText = email.getText().toString();

                Map<String, Object> user = new HashMap<>();
                user.put("username",usernameText);
                user.put("password",passwordText);
                user.put("email",emailText);
                user.put("points", 0);
                user.put("credits", 0);
                user.put("lastPoints", 0);
                user.put("lastScore", 0);

                //add to the database
                Log.e(TAG, "HIIII");
                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(getApplicationContext(),"Conta Criada",Toast.LENGTH_SHORT).show();
                                OpenLoginActivity();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Erro",Toast.LENGTH_SHORT).show();
                                Log.e(TAG, "Error adding document", e);

                            }
                        });


            }
        });


    }
    public void OpenLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
