package com.example.xonfire.xonfire;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class LogList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);
<<<<<<< HEAD
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.log_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
=======

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
>>>>>>> origin/Life-Goals-Activity
    }

}
