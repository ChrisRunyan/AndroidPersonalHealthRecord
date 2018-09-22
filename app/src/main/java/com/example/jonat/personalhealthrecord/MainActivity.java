package com.example.jonat.personalhealthrecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_records:
                    openActivity(RecordsActivity.class);
                case R.id.navigation_profile:
                    mTextMessage.setText(R.string.title_profile);
                    return true;
                case R.id.navigation_about:
                    mTextMessage.setText(R.string.title_about);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
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
        context.setHeaderTitle("Options");
        context.add(0, view.getId(), 0, "Symptoms");
        context.add(0, view.getId(), 0, "Medications");
        context.add(0, view.getId(), 0, "Procedures");
        context.add(0, view.getId(), 0, "Allergies");
    }

    private void openActivity(Class c) {
        AppCompatActivity me = MainActivity.this;
        Intent intent = new Intent(me, c);
        me.startActivity(intent);
    }

}


