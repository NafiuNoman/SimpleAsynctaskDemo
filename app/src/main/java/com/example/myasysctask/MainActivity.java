package com.example.myasysctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MyprogressBar myprogressBar;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.buttonId);

    }


    public void doSomething(View view) {

        myprogressBar=new MyprogressBar(this);

        myprogressBar.execute();
    }
}
