package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button CheckGradesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckGradesButton = (Button) findViewById(R.id.CheckGradesButton);
        CheckGradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGradesViewer();
            }
        });
    }
    public void openGradesViewer(){
        Intent intent = new Intent(this,GradesViewer.class);
        startActivity(intent);
    }
}
