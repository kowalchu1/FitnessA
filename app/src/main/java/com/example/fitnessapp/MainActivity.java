package com.example.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    ImageButton workoutButton;
    ImageButton timerButton;
    ImageButton calendarButton;
    ImageButton unitButton;

    EditText workoutFilter;
    TextView workoutList;
    Button button;

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
        button = findViewById(R.id.button);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    BufferedReader reader = new BufferedReader(new FileReader("workoutList.txt")); //creates the buffer and filereader to search for workoutlist.txt
                    int lines = 0;
                    while (reader.readLine() != null){  //Iterates till blank space appears
                        lines++;}
                    reader.close(); //closes the file

                    FileInputStream fs= new FileInputStream("workoutList.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fs));
                    String workoutLine = br.readLine();
                    for(int i = 0; i < lines - 1; i++) //For every iteration, if the line is not null, print out the line
                        if(workoutLine != null)
                        {
                            workoutList.setText(br.readLine());
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalendar();
            }
        });
        workoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWorkout();
            }
        });

    }
    public void openCalendar(){
        Intent intent = new Intent(this, CalendarA.class);
        startActivity(intent);
    }
    public void openWorkout(){
        Intent intent = new Intent(this, workout.class);
        startActivity((intent));
    }





    }
