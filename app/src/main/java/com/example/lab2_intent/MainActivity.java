package com.example.lab2_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button implicit = findViewById(R.id.btnImplicit);
        Button explicit = findViewById(R.id.btnExplicit);
        Button passExplicit = findViewById(R.id.btnPassExplicit);

        implicit.setOnClickListener(this);
        explicit.setOnClickListener(this);
        passExplicit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnImplicit){
            i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://www.javatpoint.com"));
            startActivity(i);
        }
        if(view.getId()==R.id.btnExplicit){
            i = new Intent(getApplicationContext(), ExplicitActivity.class);
            startActivity(i);
        }
        if(view.getId()==R.id.btnPassExplicit){
            startIntent(ValuePassExplicitActivity.class);
        }
    }

    private void startIntent(Class activity){
        Intent i = new Intent(MainActivity.this, activity);
        startActivity(i);
    }
}