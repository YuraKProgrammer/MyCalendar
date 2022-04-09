package dal;

import android.content.Context;
import models.Date;
import models.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskProvider implements ITaskProvider{
    private Task[] tasks = new Task[0];

    Context context;

    public TaskProvider(Context context){
        this.context=context;
        try {
            InputStream fileStream = context.openFileInput("tasks.bin");
            byte[] bytes = new byte[fileStream.available()];
            fileStream.read(bytes);
            tasks = deserializeTasks(bytes);
        }
        catch (Exception e){
            tasks = new Task[0];
        }
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
        saveToFile();
    }

    @Override
    public void addTask(Task task) {
        ArrayList<Task> list = new ArrayList<>(Arrays.asList(tasks));
        int maxId=0;
        if (list.size()>0) {
            maxId = Arrays.stream(tasks)
                    .mapToInt(Task::getId)
                    .max()
                    .getAsInt();
        }
        task.setId(maxId+1);
        list.add(task);
        tasks=list.toArray(tasks);
    }

    private void saveToFile() {
        String filename = "tasks.bin";
        try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(serializeTasks(tasks));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void updateTask(int id) {
        saveToFile();
    }

    public static byte[] serializeTasks(Task[] tasks) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteStream);
        outputStream.writeInt(tasks.length);
        for (int i=0; i<tasks.length; i++) {
            outputStream.writeObject(tasks[i]);
        }
        outputStream.flush();
        return byteStream.toByteArray();
    }

    public static Task[] deserializeTasks(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
        ObjectInputStream inputStream = new ObjectInputStream(byteStream);
        int count = inputStream.readInt();
        Task[] tasks = new Task[count];
        for (int i=0; i<count; i++){
            tasks[i]=(Task)inputStream.readObject();
        }
        return tasks;
    }
}
