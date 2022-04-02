package com.yura.mycalendar;

import android.content.Context;
import dal.ITaskProvider;
import dal.TaskProvider;

public class Services {
    public void setContext(Context context) {
        this.context = context;
        taskProvider = new TaskProvider(context);
    }

    private Context context;
    private static Services instance = new Services();
    public static Services getInstance(){
        return instance;
    }
    private ITaskProvider taskProvider;
    public ITaskProvider getTaskProvider(){
        return taskProvider;
    }
    private Services(){

    }
}
