package com.example.xonfire.xonfire;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;


public class LogList extends Activity {
    Task[] tasksArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);
        tasksArray = readAllTasksIntoArray();
        setTaskButtonsImages();
        addLongClickToTasks(0);
        addLongClickToTasks(1);
        addLongClickToTasks(2);
    }

    private void addLongClickToTasks(final int buttonNumber) {
        getTaskImageButton(buttonNumber).setLongClickable(true);
        getTaskImageButton(buttonNumber).setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                startTaskActivity(buttonNumber);
                return false;
            }
        });
    }

    private Task[] readAllTasksIntoArray() {
        Task leftButtonTask = new Task(this);
        leftButtonTask.setTaskButtonNumber(0);
        Task centerButtonTask = new Task(this);
        centerButtonTask.setTaskButtonNumber(1);
        Task rightButtonTask = new Task(this);
        rightButtonTask.setTaskButtonNumber(2);
        try {
            leftButtonTask.read();
            centerButtonTask.read();
            rightButtonTask.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Task[] {leftButtonTask, centerButtonTask, rightButtonTask};
    }

    private void setTaskButtonsImages() {
        if (getGoalIconSmall(0) != 0) getTaskImageButton(0).setBackgroundResource(getGoalIconSmall(0));
        if (getGoalIconSmall(1) != 0) getTaskImageButton(1).setBackgroundResource(getGoalIconSmall(1));
        if (getGoalIconSmall(2) != 0) getTaskImageButton(2).setBackgroundResource(getGoalIconSmall(2));
    }


    //How to not repeat ourselves?

    public void spiritualClick(View view) {
        Intent intentLifeGoal = new Intent(this, LifeGoal.class);
        intentLifeGoal.putExtra("lifeGoalInt", 0);
        startActivity(intentLifeGoal);
    }

    public void workClick(View view) {
        Intent intentLifeGoal = new Intent(this, LifeGoal.class);
        intentLifeGoal.putExtra("lifeGoalInt", 1);
        startActivity(intentLifeGoal);
    }

    public void wellbeingClick(View view) {
        Intent intentLifeGoal = new Intent(this, LifeGoal.class);
        intentLifeGoal.putExtra("lifeGoalInt", 2);
        startActivity(intentLifeGoal);
    }

    public void wallPaperSave(View view) {

        View v = view.getRootView();
        v.setDrawingCacheEnabled(true);
        Bitmap b = v.getDrawingCache();
        try {
            WallpaperManager.getInstance(view.getContext()).setBitmap(b);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Toast.makeText(this, "Wallpaper set", Toast.LENGTH_SHORT).show();
    }

    //Need to code task buttons
    public void taskLeftClick(View view) {
        clickOnTask(0);
    }

    public void taskCenterClick(View view) {
        clickOnTask(1);
    }

    public void taskRightClick(View view) {
        clickOnTask(2);
    }

    private void clickOnTask(int value) {
        if (tasksArray[value].getTaskType() == null) {
            startTaskActivity(value);

        } else {
            if (!tasksArray[value].isDone()) {
                tasksArray[value].setDone(true);
                try {
                    tasksArray[value].write();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int goalIconSmall = getGoalIconSmall(value);
                if(goalIconSmall != 0) getTaskImageButton(value).setBackgroundResource(goalIconSmall);
            }
        }
    }

    private void startTaskActivity(int value) {
        Intent intentTask = new Intent(this, LogTask.class);
        intentTask.putExtra("taskInt", value);
        startActivityForResult(intentTask, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && data != null) {
            tasksArray = readAllTasksIntoArray();
            Log.d(LogList.class.getSimpleName(), "Tasks reloaded:" + Arrays.asList(tasksArray));
            ImageButton imgButton = getTaskImageButton(resultCode);

            // set the image resource id
            String taskType = data.getStringExtra("taskTypeSelected");
            Log.d(LogList.class.getSimpleName(), "onActivityResult resultCode=" + resultCode + ", taskType='" + taskType + "'");

            int imageResourceId = getGoalIconSmall(resultCode);
            if (imageResourceId != 0) imgButton.setBackgroundResource(imageResourceId);
        }
    }

    //    private int getGoalIconBig(String taskType) {
//        return
//    }
    private int getGoalIconSmall(int buttonNumber) {
        if (tasksArray[buttonNumber].isDone()) {
            return getGoalIconSmallRed(tasksArray[buttonNumber].getTaskType());
        } else {
            return getGoalIconSmall(tasksArray[buttonNumber].getTaskType());
        }
    }
    private int getGoalIconSmall(String taskType) {
        int imageResourceId = 0;
        if (Task.SPIRITUALITY.equals(taskType)) {
            imageResourceId = R.drawable.spirituality_icon_gray_110dp;
        } else if (Task.WORK.equals(taskType)) {
            imageResourceId = R.drawable.work_icon_gray_110dp;
        } else if (Task.WELL_BEING.equals(taskType)) {
            imageResourceId = R.drawable.wellbeing_icon_gray_110dp;
        }
        return imageResourceId;
    }

    private int getGoalIconSmallRed(String taskType) {
        int imageResourceId = 0;
        if (Task.SPIRITUALITY.equals(taskType)) {
            imageResourceId = R.drawable.spirituality_icon_red_white;
        } else if (Task.WORK.equals(taskType)) {
            imageResourceId = R.drawable.work_icon_red_white;
        } else if (Task.WELL_BEING.equals(taskType)) {
            imageResourceId = R.drawable.wellbeing_icon_red_white;
        }
        return imageResourceId;
    }


    private ImageButton getTaskImageButton(int buttonNumber) {
        // set the clicked task button
        ImageButton imgButton = (ImageButton) findViewById(R.id.leftTask);
        if (buttonNumber == 1) {
            imgButton = (ImageButton) findViewById(R.id.centerTask);

        } else if (buttonNumber == 2) {
            imgButton = (ImageButton) findViewById(R.id.rightTask);

        }
        return imgButton;
    }


}