package models;

import java.io.Serializable;

public class Task implements Serializable {
    private Date date;
    private String name;
    public Task(Date date, String name){
        this.date=date;
        this.name=name;
    }
    @Override
    public String toString(){
        return name;
    }
}
