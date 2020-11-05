package com.example.zanzibar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
private EditText username;
private EditText pasword;
private Button btn_login;
private TextView info ;
private TextView userRegistration;
private  int counter =3;

private FirebaseAuth firebaseAuth;
private android.app.ProgressDialog ProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login=findViewById(R.id.btn_log);
        username=findViewById(R.id.edit_username);
        pasword=findViewById(R.id.edit_pasword);
        userRegistration= findViewById(R.id.tv_logregist);
        info=findViewById(R.id.attempt);


        info.setText("NO of attempts remaining :3");

        firebaseAuth=FirebaseAuth.getInstance();
        ProgressDialog=new ProgressDialog(this);
        FirebaseUser user =firebaseAuth.getCurrentUser();

        if(user!= null){
            finish();
            startActivity(new Intent(getApplicationContext(),DistrictActivity.class));

        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(),pasword.getText().toString());
            }
        });
        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });

    }
    private void validate(String username,String pasword){
        ProgressDialog.setMessage("Wait to verified");
        ProgressDialog.show();

        /*if ((username == "Admin") && (pasword== "Admin")){
         startActivity(new Intent(getApplicationContext(),DistrictActivity.class));
         }else{
        counter--;
        info.setText("You have attempt:" +String.valueOf(counter));
        if(counter==0){
         btn_login.setEnabled(false);

        }
         }*/

        firebaseAuth.signInWithEmailAndPassword(username,pasword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    ProgressDialog.dismiss();
                    //Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                    checkEmailVerification();
                    //startActivity(new Intent(getApplicationContext(), DistrictActivity.class));

                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    counter--;
                    info.setText("You have attempt remaining:" + String.valueOf(counter));
                    if (counter == 0) {
                        btn_login.setEnabled(false);
                    }

                }
            }

            });

        }
        private void checkEmailVerification(){
        FirebaseUser firebaseUser=firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag=firebaseUser.isEmailVerified();
        if(emailflag){
            startActivity(new Intent(getApplicationContext(),DistrictActivity.class));

        }else{
            Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
        }
}