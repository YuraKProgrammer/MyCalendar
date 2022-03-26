package com.yura.mycalendar;

import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import dal.ITaskProvider;
import dal.TaskProvider;
import models.Task;

import java.io.Serializable;

public class TaskActivity extends AppCompatActivity {
    private Task task;
    private TextView textView;
    private Button button_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        int taskId = getIntent().getIntExtra("id",-1);
        task=Services.getInstance().getTaskProvider().getTask(taskId);
        textView = findViewById(R.id.textView);
        textView.setText(task.toString());
        button_delete = findViewById(R.id.button);
        button_delete.setOnClickListener(q -> {
            Services.getInstance().getTaskProvider().deleteTask(taskId);
            super.finish();
        });
    }
}