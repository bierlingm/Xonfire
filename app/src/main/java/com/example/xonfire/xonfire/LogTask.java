package com.example.xonfire.xonfire;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class LogTask extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_task);

        //Declaring all imagebuttons
        final ImageButton spiritBtn = (ImageButton) findViewById(R.id.imageButton);
        final ImageButton workBtn = (ImageButton) findViewById(R.id.imageButton2);
        final ImageButton heartBtn = (ImageButton) findViewById(R.id.imageButton3);

        //Spirit Button option
        View.OnClickListener spiritListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*The button was clicked, so remove borders to other buttons, add a border to this one,
                change the variable to be equal to 0.
                 */
                workBtn.
                heartBtn.
                spiritBtn.setBackgroundResource(R.drawable.border);
            
            }
        };
        spiritBtn.setOnClickListener(spiritListener);
    }


}
