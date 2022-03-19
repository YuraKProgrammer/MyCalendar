package com.yura.mycalendar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import dal.ITaskProvider;
import models.Date;
import models.Task;

import java.io.Serializable;

public class PlansActivity extends AppCompatActivity {
    private ListView listView;
    private ITaskProvider taskProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
        Serializable d = getIntent().getSerializableExtra("date");
        Date date = (Date)d;
        taskProvider = Services.getInstance().getTaskProvider();
        Task[] tasks = taskProvider.getTasks(date);
        listView=findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<Task>(this, R.layout.support_simple_spinner_dropdown_item, tasks));
    }
}
