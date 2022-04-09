package com.yura.mycalendar;

import dal.TaskProvider;
import models.Date;
import models.Task;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class TaskProviderTest {
    @Test
    public void serializeTasks_test() throws IOException, ClassNotFoundException {
        Task t1 = new Task(new Date(1999,9,8),"task",1);
        Task t2 = new Task(new Date(2005,1,15),"task2",2);
        Task[] tasks = new Task[]{t1,t2};
        byte[] b = TaskProvider.serializeTasks(tasks);
        Task[] tasks2 = TaskProvider.deserializeTasks(b);
        for (int i=0; i<tasks.length; i++) {
            Assert.assertTrue(Task.areEquals(tasks[i],tasks2[i]));
        }
    }
}
