package com.yura.mycalendar;

import dal.ITaskProvider;
import dal.TaskProvider;

public class Services {
    private static Services instance = new Services();
    public static Services getInstance(){
        return instance;
    }
    private ITaskProvider taskProvider = new TaskProvider();
    public ITaskProvider getTaskProvider(){
        return taskProvider;
    }
    private Services(){

    }
}
