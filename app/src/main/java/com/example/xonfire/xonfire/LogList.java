package com.example.xonfire.xonfire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LogList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);

    }

    //How to not repeat ourselves?

    public void spiritualClick(View view){
        Intent intentLifeGoal = new Intent(this, LifeGoal.class);
        intentLifeGoal.putExtra("lifeGoalInt", 0);
        startActivity(intentLifeGoal);
    }
    public void workClick(View view){
        Intent intentLifeGoal = new Intent(this, LifeGoal.class);
        intentLifeGoal.putExtra("lifeGoalInt", 1);
        startActivity(intentLifeGoal);
    }
    public void wellbeingClick(View view){
        Intent intentLifeGoal = new Intent(this, LifeGoal.class);
        intentLifeGoal.putExtra("lifeGoalInt", 2);
        startActivity(intentLifeGoal);
    }

       //Need to code task buttons
    public void taskCenterClick(View view){
        Intent intentTask = new Intent(this, LogTask.class);
        intentTask.putExtra("taskInt", 0);
        startActivity(intentTask);
    }
    public void taskLeftClick(View view){
        Intent intentTask = new Intent(this, LogTask.class);
        intentTask.putExtra("taskInt", 1);
        startActivity(intentTask);
    }
    public void taskRightClick(View view){
        Intent intentTask = new Intent(this, LogTask.class);
        intentTask.putExtra("taskInt", 2);
        startActivity(intentTask);
    }
}
