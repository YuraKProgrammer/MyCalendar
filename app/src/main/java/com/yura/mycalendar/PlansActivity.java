package com.yura.mycalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import dal.ITaskProvider;
import models.Date;
import models.Task;

import java.io.Serializable;

public class PlansActivity extends AppCompatActivity {
    private ListView listView;
    private ITaskProvider taskProvider;
    private TextView tV_selectedDate;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
        Serializable d = getIntent().getSerializableExtra("date");
        date = (Date)d;
        taskProvider = Services.getInstance().getTaskProvider();
        tV_selectedDate=findViewById(R.id.TextView_selectedDate);
        tV_selectedDate.setText(date.toString());
        listView=findViewById(R.id.listView);
        refreshTasks();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Task selectedTask = (Task)listView.getItemAtPosition(position);
                Intent myIntent = new Intent(PlansActivity.this, TaskActivity.class);
                myIntent.putExtra("id",selectedTask.getId());
                PlansActivity.this.startActivity(myIntent);
            }});
    }
    @Override
    public void onResume(){
        refreshTasks();
        super.onResume();
    }

    private void refreshTasks(){
        Task[] tasks = taskProvider.getTasks(date);
        listView.setAdapter(new ArrayAdapter<Task>(this, R.layout.support_simple_spinner_dropdown_item, tasks));
    }
}
