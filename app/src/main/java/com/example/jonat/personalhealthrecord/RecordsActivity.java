package com.example.jonat.personalhealthrecord;

import android.content.Intent;
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
import android.widget.TextView;

public class RecordsActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    openActivity(MainActivity.class);
                case R.id.navigation_records:
                    return true;
                case R.id.navigation_profile:
                    openActivity(ProfileActivity.class);
                case R.id.navigation_about:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_records);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(AddObservationActivity.class);
            }
        });

        registerForContextMenu(fab);
    }

    @Override
    public void onCreateContextMenu(ContextMenu context, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(context, view, menuInfo);
        context.setHeaderTitle(R.string.addMenu_title);
        context.add(0, view.getId(), 0, R.string.addMenu_symptoms);
        context.add(0, view.getId(), 0, R.string.addMenu_medications);
        context.add(0, view.getId(), 0, R.string.addMenu_procedures);
        context.add(0, view.getId(), 0, R.string.addMenu_allergies);
    }

    private void openActivity(Class c) {
        AppCompatActivity me = RecordsActivity.this;
        Intent intent = new Intent(me, c);
        me.startActivity(intent);
    }

}
