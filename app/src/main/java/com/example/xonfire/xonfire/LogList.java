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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);
        setTaskButtonsImages();

    }

    private void setTaskButtonsImages() {
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
        ImageButton leftButton = getTaskImageButton(0);
        Log.d(LogList.class.getSimpleName(), "leftButton:" + leftButton + ", leftButtonTask:" + leftButtonTask);
        leftButton.setBackgroundResource(getGoalIconSmall(leftButtonTask.getTaskType()));
        ImageButton centerButton = getTaskImageButton(1);
        centerButton.setBackgroundResource(getGoalIconSmall(centerButtonTask.getTaskType()));
        ImageButton rightButton = getTaskImageButton(2);
        rightButton.setBackgroundResource(getGoalIconSmall(rightButtonTask.getTaskType()));
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
    public void wallPaperSave(View view){

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
    public void taskLeftClick(View view){
        startTaskActivity(0);
    }

    public void taskCenterClick(View view){
        startTaskActivity(1);
    }

    public void taskRightClick(View view){
        startTaskActivity(2);
    }

    private void startTaskActivity(int value) {
        Intent intentTask = new Intent(this, LogTask.class);
        intentTask.putExtra("taskInt", value);
        startActivityForResult(intentTask, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            ImageButton imgButton = getTaskImageButton(resultCode);

            // set the image resource id
            String taskType = data.getStringExtra("taskTypeSelected");
            Log.d(LogList.class.getSimpleName(), "onActivityResult resultCode=" + resultCode + ", taskType='"+taskType + "'");

            int imageResourceId = getGoalIconSmall(taskType);
            imgButton.setBackgroundResource(imageResourceId);
        }
    }

//    private int getGoalIconBig(String taskType) {
//        return
//    }
    private int getGoalIconSmall(String taskType) {
        int imageResourceId = R.drawable.spirituality_icon_gray_110dp;
        if (Task.WORK.equals(taskType)) {
            imageResourceId = R.drawable.work_icon_gray_110dp;
        } else if (Task.WELL_BEING.equals(taskType)) {
            imageResourceId = R.drawable.wellbeing_icon_gray_110dp;
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
