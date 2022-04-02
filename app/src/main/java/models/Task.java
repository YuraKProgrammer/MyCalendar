package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable {
    public Date getDate() {
        return date;
    }

    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    public Task(Date date, String name, int id){
        this.date=date;
        this.name=name;
        this.id=id;
    }

    public Task(){
    }

    @Override
    public String toString(){
        return name;
    }

    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {
        date = (Date)aInputStream.readObject();
        id = aInputStream.readInt();
        name = aInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
        aOutputStream.writeObject(date);
        aOutputStream.writeInt(id);
        aOutputStream.writeUTF(name);
    }

    public static boolean areEquals(Task t1, Task t2){
        if (!Date.areEquals(t1.getDate(),t2.getDate()))
            return false;
        if (t1.getId()!=t2.getId())
            return false;
        if (!Objects.equals(t1.getName(), t2.getName()))
            return false;
        return true;
    }
}
