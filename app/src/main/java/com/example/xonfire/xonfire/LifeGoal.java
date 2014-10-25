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
        ImageView imgView = (ImageView) findViewById(R.id.lifeImageView);
        TextView goalView = (TextView) findViewById(R.id.goalName);

        //Get intent information from LogList Buttons
        Intent intentLifeGoal= getIntent();
        int goalInt = intentLifeGoal.getIntExtra("lifeGoalInt", 0);

        //Spirituality option
        if (goalInt== 0) {
            imgView.setImageResource(R.drawable.spirituality_icon_gray);
            goalView.setText("Spirituality");
        }

        //Work option
        else if (goalInt == 1) {
            imgView.setImageResource(R.drawable.work_icon_gray);
            goalView.setText("Work");
        }

        //Well-being option
        else if (goalInt == 2) {
            imgView.setImageResource(R.drawable.wellbeing_icon_gray);
            goalView.setText("Well-being");
        }

    }
    //Save Method
    public void saveButtonClick(View view){
        //Save all changes made to the text fields
    }

}


