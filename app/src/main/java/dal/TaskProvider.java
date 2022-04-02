package dal;

import android.content.Context;
import models.Date;
import models.Task;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskProvider implements ITaskProvider{
    private Task[] tasks = new Task[1];

    Context context;

    public TaskProvider(Context context){
        tasks[0]=new Task(new Date(2000, 1, 1),"Новый план",1);
        this.context=context;
    }

    public Task[] getTasks(Date date){
        return Arrays.stream(tasks)
                .filter(t -> Date.areEquals(t.getDate(),date))
                .toArray(Task[]::new);
    }

    public Task getTask(int taskId) {
        return Arrays.stream(tasks)
                .filter(t -> t.getId()==taskId)
                .findFirst()
                .orElse(null);
    }

    public void deleteTask(int taskId){
        tasks = Arrays.stream(tasks)
                .filter(t -> t.getId()!=taskId)
                .toArray(Task[]::new);
    }

    @Override
    public void addTask(Task task) {
        ArrayList<Task> list = new ArrayList<>(Arrays.asList(tasks));
        int maxId = Arrays.stream(tasks)
                .mapToInt(Task::getId)
                .max()
                .getAsInt();
        task.setId(maxId+1);
        list.add(task);
        tasks=list.toArray(tasks);

        String filename = "file";
        try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(null);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void updateTask(int id) {
    }
}
