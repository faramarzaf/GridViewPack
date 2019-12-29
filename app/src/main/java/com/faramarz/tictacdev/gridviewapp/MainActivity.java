package com.faramarz.tictacdev.gridviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.faramarz.tictacdev.gridviewapp.sample1.GridSample1Activity;
import com.faramarz.tictacdev.gridviewapp.sample2.GridSample2Activity;
import com.faramarz.tictacdev.gridviewapp.sample3.GridSample3Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSample1, btnSample2, btnSample3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSample1 = findViewById(R.id.btnSample1);
        btnSample2 = findViewById(R.id.btnSample2);
        btnSample3 = findViewById(R.id.btnSample3);

        btnSample1.setOnClickListener(this);
        btnSample2.setOnClickListener(this);
        btnSample3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSample1:
                startActivity(new Intent(this, GridSample1Activity.class));
                break;

            case R.id.btnSample2:
                startActivity(new Intent(this, GridSample2Activity.class));
                break;

            case R.id.btnSample3:
                startActivity(new Intent(this, GridSample3Activity.class));
                break;

        }
    }


}
