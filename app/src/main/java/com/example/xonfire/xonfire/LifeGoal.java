package com.example.xonfire.xonfire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LifeGoal extends Activity {

    static final String FILENAME = "goal_file";
    private Goal goal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_goal);
        ImageView imgView = (ImageView) findViewById(R.id.lifeImageView);
        TextView goalView = (TextView) findViewById(R.id.goalName);

        //Get intent information from LogList Buttons
        Intent intentLifeGoal = getIntent();
        int goalInt = intentLifeGoal.getIntExtra("lifeGoalInt", 0);

        String goalType = null;
        //Spirituality option
        if (goalInt == 0) {
            imgView.setImageResource(R.drawable.spirituality_icon_gray);
            goalType = "Spirituality";
            goalView.setText(goalType);
        }

        //Work option
        else if (goalInt == 1) {
            imgView.setImageResource(R.drawable.work_icon_gray);
            goalType = "Work";
            goalView.setText(goalType);
        }

        //Well-being option
        else if (goalInt == 2) {
            imgView.setImageResource(R.drawable.wellbeing_icon_gray);
            goalType = "Well-being";
            goalView.setText(goalType);
        }

        //Data persistence for goal information
        goal = new Goal(this);
        goal.setGoalType(goalType);
        try {
            goal.read();
        } catch (IOException e) {
            Log.e(LifeGoal.class.getSimpleName(), "Error reading " + goal.getGoalType() + " goal", e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Log.e(LifeGoal.class.getSimpleName(), "Error reading " + goal.getGoalType() + " goal", e);
            e.printStackTrace();
        }
        Log.d(LifeGoal.class.getSimpleName(), goal.toString());
        EditText nameText = (EditText) findViewById(R.id.editGoalTitle);
        nameText.setText(goal.getName());
        EditText descriptionText = (EditText) findViewById(R.id.editGoalDescription);
        descriptionText.setText(goal.getDescription());

    }

    //Save Method
    public void saveButtonClick(View view) {
        try {
            EditText et = (EditText) view.getRootView().findViewById(R.id.editGoalTitle);
            Log.d(LifeGoal.class.getSimpleName(), "goal is " + goal);
            Log.d(LifeGoal.class.getSimpleName(), "et is " + et);
            Log.d(LifeGoal.class.getSimpleName(), "et.getText is " + et.getText());
            goal.setName(et.getText().toString());
            et = (EditText) view.getRootView().findViewById(R.id.editGoalDescription);
            goal.setDescription(et.getText().toString());
            goal.write();
        } catch (IOException e) {
            Log.e(LifeGoal.class.getSimpleName(), "Error writing " + goal.getGoalType() + " goal", e);
            e.printStackTrace();
        }

    }

}


