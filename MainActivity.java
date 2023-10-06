package com.mgstarlites.jobkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernamem,password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernamem=findViewById(R.id.ed1);
        password=findViewById(R.id.ed2);

        Login=findViewById(R.id.Login1);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernamem.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    ;
                    Intent intent = new Intent(MainActivity.this, JobFilter.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
            }
        });

    }
}