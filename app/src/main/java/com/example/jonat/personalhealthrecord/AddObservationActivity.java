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
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AddObservationActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    openActivity(MainActivity.class);
                    return true;
                case R.id.navigation_records:
                    openActivity(RecordsActivity.class);
                    return true;
                case R.id.navigation_profile:
                    return true;
                case R.id.navigation_about:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_observation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setSupportActionBar(toolbar);
        registerForContextMenu(fab);
    }

    @Override
    public void onCreateContextMenu(ContextMenu context, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(context, view, menuInfo);
        context.setHeaderTitle(R.string.obs_menu_title);
        String[] itemValues = getResources().getStringArray(R.array.obs_values);
        for (String value : itemValues) {
            context.add(0, view.getId(), 0, value);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return false;
    }

    private void openActivity(Class c) {
        AppCompatActivity me = AddObservationActivity.this;
        Intent intent = new Intent(me, c);
        me.startActivity(intent);
    }

}
