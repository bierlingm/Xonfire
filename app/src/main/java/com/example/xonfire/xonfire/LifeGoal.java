package com.example.xonfire.xonfire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LifeGoal extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_goal);

        //Get intent information from LogList Buttons
        Intent intent = getIntent();
        int intValue = intent.getIntExtra("intVariableName", 0);
        ImageView imgView = (ImageView) findViewById(R.id.lifeImageView);

        //Spirituality option
        if (intValue == 0) {
            imgView.setImageResource(R.drawable.spirituality_icon_gray);
        };

        //Work option
        if (intValue == 1) {
            imgView.setImageResource(R.drawable.work_icon_gray);
        };

        //Wellbeing option
        if (intValue == 2) {
            imgView.setImageResource(R.drawable.wellbeing_icon_gray);
        };

    }
    //Back Button
    public void backButtonClick(View view){
        Intent intent = new Intent(this, LogList.class);
        startActivity(intent);
    }

}


