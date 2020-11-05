package com.example.zanzibar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class DistrictActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private Button btn_logout,mBtnView,mBtnSouth,btn_North,mBtnWest,mBtnNorthPba,mBtnSourthPba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);
        btn_logout=findViewById(R.id.btn_logout);
        mBtnView = findViewById(R.id.btn_view);
        mBtnSouth = findViewById(R.id.btn_south);
        mBtnNorthPba = findViewById(R.id.btn_northp);
        btn_North = findViewById(R.id.btn_North);
        mBtnWest = findViewById(R.id.btn_west);
        mBtnSourthPba = findViewById(R.id.btn_southp);

        firebaseAuth=FirebaseAuth.getInstance();



        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();

            }
        });
        mBtnView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(getApplicationContext(),User_list_View.class));

            }
        });


        mBtnSouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(getApplicationContext(),SourthActivity.class));

            }
        });
        btn_North.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(getApplicationContext(),NorthActivity.class));

            }
        });

        mBtnWest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(getApplicationContext(),WestActivity.class));
            }
        });
        mBtnNorthPba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(getApplicationContext(),NorthpbaActivity.class));
            }
        });
        mBtnSourthPba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(getApplicationContext(),SouthpbaActivity.class));
            }
        });

    }

    private  void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(),LandingActivity.class));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return  true;
    }

    @Override
    // this is the method that handle the menu
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.btn_logoutMenu:{
                Logout();

            }
        }
        return super.onOptionsItemSelected(item);
    }
}