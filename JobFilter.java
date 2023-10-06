package com.mgstarlites.jobkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JobFilter extends AppCompatActivity {

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_filter);

        save=findViewById(R.id.Login1);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JobFilter.this,jobtime.class);
                startActivity(intent);
            }
        });

    }
}