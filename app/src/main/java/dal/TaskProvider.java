package dal;

import models.Date;
import models.Task;

public class TaskProvider implements ITaskProvider{
    public Task[] getTasks(Date date){
        Task[] tasks = new Task[3];
        tasks[0]=new Task(new Date(2022, 3, 7),"Завтрак");
        tasks[1]=new Task(new Date(2022, 3, 8),"Обед");
        tasks[2]=new Task(new Date(2022, 3, 9),"Ужин");
        return tasks;
    }
}
