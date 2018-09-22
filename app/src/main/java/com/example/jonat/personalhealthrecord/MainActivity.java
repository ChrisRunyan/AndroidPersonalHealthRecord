package com.example.jonat.personalhealthrecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
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
        setContentView(R.layout.activity_main);

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
        context.setHeaderTitle(R.string.addMenu_title);
        context.add(0, view.getId(), 0, R.string.addMenu_symptoms);
        context.add(0, view.getId(), 0, R.string.addMenu_medications);
        context.add(0, view.getId(), 0, R.string.addMenu_procedures);
        context.add(0, view.getId(), 0, R.string.addMenu_allergies);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (getString(R.string.addMenu_symptoms).contentEquals(item.getTitle())) {
            openActivity(AddObservationActivity.class);
        }
        return false;
    }


    private void openActivity(Class c) {
        AppCompatActivity me = MainActivity.this;
        Intent intent = new Intent(me, c);
        me.startActivity(intent);
    }

}


