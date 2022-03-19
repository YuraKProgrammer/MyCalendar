package com.yura.mycalendar;

import android.content.Intent;
import android.widget.CalendarView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import dal.ITaskProvider;
import dal.TaskProvider;
import models.Date;

public class MainActivity extends AppCompatActivity {
    private CalendarView calendarView;
    private ITaskProvider taskProvider = new TaskProvider();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView=findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            Intent myIntent = new Intent(MainActivity.this, PlansActivity.class);
            myIntent.putExtra("date", new Date(year, month, dayOfMonth));
            MainActivity.this.startActivity(myIntent);
        });
    }
}