package dal;

import models.Date;
import models.Task;

public interface ITaskProvider {
    Task[] getTasks(Date date);
}
