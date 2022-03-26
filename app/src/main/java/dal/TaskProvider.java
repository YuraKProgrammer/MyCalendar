package dal;

import models.Date;
import models.Task;

import java.util.Arrays;

public class TaskProvider implements ITaskProvider{
    private Task[] tasks = new Task[3];

    public TaskProvider(){
        tasks[0]=new Task(new Date(2022, 3, 7),"Завтрак",1);
        tasks[1]=new Task(new Date(2022, 3, 8),"Обед",2);
        tasks[2]=new Task(new Date(2022, 3, 9),"Ужин",3);
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
}
