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


public class LogList extends Activity {
    Task[] tasksArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);
        tasksArray = readAllTasksIntoArray();
        setTaskButtonsImages();

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
        getTaskImageButton(0).setBackgroundResource(getGoalIconSmall(0));
        getTaskImageButton(1).setBackgroundResource(getGoalIconSmall(1));
        getTaskImageButton(2).setBackgroundResource(getGoalIconSmall(2));
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
            Intent intentTask = new Intent(this, LogTask.class);
            intentTask.putExtra("taskInt", value);
            startActivityForResult(intentTask, 1);

        } else {
            if (!tasksArray[value].isDone()) {
                tasksArray[value].setDone(true);
                getTaskImageButton(value).setImageResource(getGoalIconSmall(value));
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            ImageButton imgButton = getTaskImageButton(resultCode);

            // set the image resource id
            String taskType = data.getStringExtra("taskTypeSelected");
            Log.d(LogList.class.getSimpleName(), "onActivityResult resultCode=" + resultCode + ", taskType='" + taskType + "'");

            int imageResourceId = getGoalIconSmall(taskType);
            imgButton.setBackgroundResource(imageResourceId);
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
        int imageResourceId = R.drawable.spirituality_icon_gray_110dp;
        if (Task.WORK.equals(taskType)) {
            imageResourceId = R.drawable.work_icon_gray_110dp;
        } else if (Task.WELL_BEING.equals(taskType)) {
            imageResourceId = R.drawable.wellbeing_icon_gray_110dp;
        }
        return imageResourceId;
    }

    private int getGoalIconSmallRed(String taskType) {
        int imageResourceId = R.drawable.spirituality_icon_red_white;
        if (Task.WORK.equals(taskType)) {
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