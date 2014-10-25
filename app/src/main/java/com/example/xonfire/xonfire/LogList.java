package com.example.xonfire.xonfire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class LogList extends Activity implements View.OnClickListener {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);

        ImageButton BoxOne = (ImageButton) findViewById(R.id.BoxOne);
        BoxOne.setOnClickListener(this);
        ImageButton BoxTwo = (ImageButton) findViewById(R.id.BoxTwo);
        BoxTwo.setOnClickListener(this);
        ImageButton BoxThree = (ImageButton) findViewById(R.id.BoxThree);
        BoxThree.setOnClickListener(this);
        ImageButton CircleOne = (ImageButton) findViewById(R.id.CircleOne);
        CircleOne.setOnClickListener(this);
        ImageButton CircleTwo = (ImageButton) findViewById(R.id.CircleTwo);
        CircleTwo.setOnClickListener(this);
        ImageButton CircleThree = (ImageButton) findViewById(R.id.CircleThree);
        CircleThree.setOnClickListener(this);
    }
    private void onBoxOneClick() {
                Intent intent_BoxOne = new Intent(this, Spirituality_Activity.class);
                startActivity(intent_BoxOne);
            }

    private void onBoxTwoClick() {
        Intent intent_BoxTwo = new Intent(this, Wellbeing_Activity.class);
        startActivity(intent_BoxTwo);
    }

    private void onBoxThreeClick() {
        Intent intent_BoxThree = new Intent(this, Wellbeing_Activity.class);
        startActivity(intent_BoxThree);
    }

    private void onCircleOneClick() {
        Intent intent_CircleOne = new Intent(this, Wellbeing_Activity.class);
        startActivity(intent_CircleOne);
    }

    private void onCircleTwoClick() {
        Intent intent_CircleTwo = new Intent(this, Wellbeing_Activity.class);
        startActivity(intent_CircleTwo);
    }

    private void onCircleThreeClick() {
        Intent intent_CircleThree = new Intent(this, Wellbeing_Activity.class);
        startActivity(intent_CircleThree);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BoxOne:
                onBoxOneClick();
                break;
        }

        switch (v.getId()) {
            case R.id.BoxTwo:
                onBoxTwoClick();
                break;
        }
        switch (v.getId()) {
            case R.id.BoxThree:
                onBoxThreeClick();
                break;
        }
        switch (v.getId()) {
            case R.id.CircleOne:
                onCircleOneClick();
                break;
        }
        switch (v.getId()) {
            case R.id.CircleTwo:
                onCircleTwoClick();
                break;
        }
        switch (v.getId()) {
            case R.id.CircleThree:
                onCircleThreeClick();
                break;
        }

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
        if (id == R.string.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

