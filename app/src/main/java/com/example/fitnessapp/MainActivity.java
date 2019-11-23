package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton workoutButton;
    ImageButton timerButton;
    ImageButton calendarButton;
    ImageButton unitButton;
    private ArrayAdapter adapter;
    EditText workoutFilter;
    ListView workoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        workoutButton = findViewById(R.id.workoutButton);
        timerButton = findViewById(R.id.timerButton);
        calendarButton = findViewById(R.id.calendarButton);
        unitButton = findViewById(R.id.unitButton);
        workoutFilter = findViewById(R.id.workoutFilter);
        workoutList = findViewById(R.id.workoutList);

        ArrayList<String> workoutNames = new ArrayList<>();
        workoutNames.add("Dips");
        workoutNames.add("Bench Press");
        workoutNames.add("Squats");
        workoutNames.add("Preacher Curls");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, workoutNames);
        workoutList.setAdapter(adapter);

        workoutFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalendar();
            }
        });

    }
    public void openCalendar(){
        Intent intent = new Intent(this, CalendarA.class);
        startActivity(intent);
    }

}
