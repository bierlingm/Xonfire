package com.example.xonfire.xonfire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class LogList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);

    }

    public void spiritualClick(View view){
        Intent intent = new Intent(this, LifeGoal.class);
        intent.putExtra("intVariableName", 0);
        startActivity(intent);

    }
    public void workClick(View view){

        Intent intent = new Intent(this, LifeGoal.class);
        intent.putExtra("intVariableName", 1);
        startActivity(intent);

    }
    public void wellbeingClick(View view){

        Intent intent = new Intent(this, LifeGoal.class);
        intent.putExtra("intVariableName", 2);
        startActivity(intent);

    }
}
