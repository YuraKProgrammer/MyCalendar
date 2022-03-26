package models;

import java.io.Serializable;

public class Task implements Serializable {
    public Date getDate() {
        return date;
    }

    private Date date;
    private String name;

    public int getId() {
        return id;
    }

    private int id;
    public Task(Date date, String name, int id){
        this.date=date;
        this.name=name;
        this.id=id;
    }
    @Override
    public String toString(){
        return name;
    }
}
