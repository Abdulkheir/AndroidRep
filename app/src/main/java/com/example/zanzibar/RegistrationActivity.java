package com.example.zanzibar;
//zanzibar-18ca6
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    private EditText regname,address,username,pasword, useremail;
    private TextView signup;
    private Button btn_regist;
    FirebaseAuth firebaseAuth;
    String name, adress,  user,  password, user_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();
        firebaseAuth=FirebaseAuth.getInstance();

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){

                    //upload data to the data base
                    String name=regname.getText().toString().trim();
                    String adress=address.getText().toString().trim();
                    String user=username.getText().toString().trim();
                    String password=pasword.getText().toString().trim();
                    String user_email=useremail.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(RegistrationActivity.this, "check ", Toast.LENGTH_SHORT).show();

                            if(task.isSuccessful()){
                                sendEmailVerfication();
                                //sendUserData();
                                Toast.makeText(RegistrationActivity.this, "Registration successefully", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }else{
                                Toast.makeText(RegistrationActivity.this, "Registration not successfully", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }

    private void setupUIViews(){
        regname =findViewById(R.id.edit_regname);
        address =findViewById(R.id.edit_address);
        username =findViewById(R.id.username);
        pasword =findViewById(R.id.pasword);
        useremail =findViewById(R.id.useremail);
        signup =findViewById(R.id.read_sign);
        btn_regist =findViewById(R.id.btn_regist);


    }
    private Boolean validate(){
        Boolean result =false;
        name=regname.getText().toString();adress=address.getText().toString();
       user=username.getText().toString();
        password=pasword.getText().toString();
        user_email=useremail.getText().toString();
        if(name.isEmpty() && adress.isEmpty() && adress.isEmpty()  && user.isEmpty() && password .isEmpty()&& user_email.isEmpty()){
            Toast.makeText(this, "Please enter your details", Toast.LENGTH_SHORT).show();
        }else{
            result=true;
        }
        return  result;
    }

    private void sendEmailVerfication(){
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser !=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        sendUserData();
                        Toast.makeText(RegistrationActivity.this, "Registration successefully", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }else {
                        Toast.makeText(RegistrationActivity.this, "Verification Email has not  been sent", Toast.LENGTH_SHORT).show();
                    }
                    }
                });

            }

        }
        private  void sendUserData(){
        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();

            DatabaseReference myRef=firebaseDatabase.getReference(firebaseAuth.getUid());
            UserProfile userProfile=new UserProfile(name,adress,user,password,user_email);
            myRef.setValue(userProfile);

        }
}