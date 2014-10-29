package com.example.xonfire.xonfire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by Kien Truong on 10/28/2014.
 */
public class LogTask extends Activity {

    static final String TASKNAME = "goal_task";
    public static final String FILENAME = "task_file";
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_task);
        //Get intent information from LogList Buttons
        Intent intentLifeGoal = getIntent();
        int taskInt = intentLifeGoal.getIntExtra("taskInt", 0);

        final ImageButton spiritualButton= (ImageButton) findViewById(R.id.spiritualtask);
        final ImageButton workButton = (ImageButton) findViewById(R.id.worktask);
        final ImageButton wellbeingButton = (ImageButton) findViewById(R.id.wellbeingtask);

        TextView goalView = (TextView) findViewById(R.id.goalName);

        task = new Task(this);
        task.setTaskButtonNumber(taskInt);
        try {
            task.read();
        } catch (IOException e) {
            Log.e(LogTask.class.getSimpleName(), "Error reading task", e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Log.e(LogTask.class.getSimpleName(), "Error reading task", e);
            e.printStackTrace();
        }
        Log.d(LogTask.class.getSimpleName(), task.toString());
        EditText nameText = (EditText) findViewById(R.id.editTaskTitle);
        nameText.setText(task.getName());
        EditText descriptionText = (EditText) findViewById(R.id.editTaskDescription);
        descriptionText.setText(task.getDescription());
        // set selected button Setting border for button corresponding to Work using button 2131034130
        ImageButton selectedButton = spiritualButton;
        if (Task.WORK.equalsIgnoreCase(task.getTaskType())) {
            selectedButton = workButton;
        } else if (Task.WELL_BEING.equalsIgnoreCase(task.getTaskType())) {
            selectedButton = wellbeingButton;
        }
        Log.d("TAG", "Setting border for button corresponding to " +task.getTaskType() + " using button " + selectedButton.getId());
        selectedButton.setBackgroundResource(R.drawable.border);
        //Spirit Button option
        View.OnClickListener goalTypeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.worktask) {
                    LogTask.this.task.setTaskType(Task.WORK);
                } else if (v.getId() == R.id.wellbeingtask) {
                    LogTask.this.task.setTaskType(Task.WELL_BEING);

                } else if (v.getId() == R.id.spiritualtask) {
                    LogTask.this.task.setTaskType(Task.SPIRITUALITY);

                } else {
                    Log.d("TG", "This is bad... The id is "+v.getId());
                }
                /*The button was clicked, so remove borders to other buttons, add a border to this one,
                change the variable to be equal to 0.
                 */
                workButton.setBackgroundResource(R.drawable.border_trans);
                wellbeingButton.setBackgroundResource(R.drawable.border_trans);
                spiritualButton.setBackgroundResource(R.drawable.border_trans);

                ImageButton thisButton = (ImageButton) v;
                thisButton.setBackgroundResource(R.drawable.border);

            }
        };
        spiritualButton.setOnClickListener(goalTypeListener);
        workButton.setOnClickListener(goalTypeListener);
        wellbeingButton.setOnClickListener(goalTypeListener);

    }

    //Save Method
    public void saveButtonClick(View view) {
        try {
            EditText et = (EditText) view.getRootView().findViewById(R.id.editTaskTitle);
            Log.d(LogTask.class.getSimpleName(), "goal is " + task);
            Log.d(LogTask.class.getSimpleName(), "et is " + et);
            Log.d(LogTask.class.getSimpleName(), "et.getText is " + et.getText());
            task.setName(et.getText().toString());
            et = (EditText) view.getRootView().findViewById(R.id.editTaskDescription);
            task.setDescription(et.getText().toString());
            task.write();
        } catch (IOException e) {
            Log.e(LogTask.class.getSimpleName(), "Error writing " + task.getTaskType() + " goal", e);
            e.printStackTrace();
        }
        finish();
    }
}
