package com.example.xonfire.xonfire;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class LogList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);

    }

    public void spiritualClick(View view){
        Intent intent = new Intent(this, LifeGoal.class);
        intent.putExtra("intVariableName", 0);
        startActivity(intent);

    }
    public void workClick(View view){

        Intent intent = new Intent(this, LifeGoal.class);
        intent.putExtra("intVariableName", 1);
        startActivity(intent);

    }
    public void wellbeingClick(View view){

        Intent intent = new Intent(this, LifeGoal.class);
        intent.putExtra("intVariableName", 2);
        startActivity(intent);

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
    }

}
