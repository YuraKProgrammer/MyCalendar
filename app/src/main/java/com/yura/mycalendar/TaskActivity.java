package com.yura.mycalendar;

import android.widget.Button;
import android.widget.EditText;
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
    private Button button_Save;
    private EditText editTextName;
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
        editTextName=findViewById(R.id.editTextName);
        editTextName.setText(task.getName());
        button_Save=findViewById(R.id.button_Save);
        button_Save.setOnClickListener(q -> {
            task.setName(editTextName.getText().toString());
            textView.setText(task.toString());
            Services.getInstance().getTaskProvider().updateTask(task.getId());
        });
    }
}