package com.example.xonfire.xonfire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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
        TextView goalView = (TextView) findViewById(R.id.goalName);

        //Spirituality option
        if (intValue == 0) {
            imgView.setImageResource(R.drawable.spirituality_icon_gray);
            goalView.setText("Spirituality");
            EditText editTitleSpirit = (EditText) findViewById(R.id.editGoalTitle);


        };

        //Work option
        if (intValue == 1) {
            imgView.setImageResource(R.drawable.work_icon_gray);
            goalView.setText("Work");
        };

        //Wellbeing option
        if (intValue == 2) {
            imgView.setImageResource(R.drawable.wellbeing_icon_gray);
            goalView.setText("Wellbeing");
        };

    }
    //Save Method
    public void saveButtonClick(View view){
        //Save all changes made to the text fields
    }

}


