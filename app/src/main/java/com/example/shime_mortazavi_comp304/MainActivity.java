package com.example.shime_mortazavi_comp304;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showChartActivity(View v)
    {
        //put selected items in Extras
        intent = new Intent(this, Second.class);
        intent.putExtra("checkedStates","");
        //
        startActivity(intent);
    }
}