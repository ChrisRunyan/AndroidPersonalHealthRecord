package com.example.jonat.personalhealthrecord;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AddObservationActivity extends AppCompatActivity {

    private View.OnClickListener onNavigationButtonClickListener
            = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.add_obs_back) {
                openActivity(MainActivity.class);
            } else if (v.getId() == R.id.add_obs_forward) {
                openActivity(RecordsActivity.class);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_observation);

        TextView obsType = (TextView) findViewById(R.id.observationTitle);
        EditText obsEntry = (EditText) findViewById(R.id.obs_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageButton backButton = (ImageButton) findViewById(R.id.add_obs_back);
        ImageButton forwardButton = (ImageButton) findViewById(R.id.add_obs_forward);

        backButton.setOnClickListener(onNavigationButtonClickListener);
        forwardButton.setOnClickListener(onNavigationButtonClickListener);
        setSupportActionBar(toolbar);
    }

    private void openActivity(Class c) {
        AppCompatActivity me = AddObservationActivity.this;
        Intent intent = new Intent(me, c);
        me.startActivity(intent);
    }

}
