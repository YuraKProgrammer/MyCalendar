package com.yura.mycalendar;

import models.Date;
import models.Task;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class TaskTest {
    @Test
    public void binarySerialization_test() throws IOException, ClassNotFoundException {
        Task task = new Task(new Date(1234,12,12),"ый", 123);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteStream);
        outputStream.writeObject(task);
        outputStream.flush();

        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(byteStream.toByteArray()));
        Task task2=(Task)inputStream.readObject();
        Assert.assertTrue(Task.areEquals(task,task2));
    }
}
