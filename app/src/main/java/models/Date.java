package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Date implements Serializable {
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int year;
    private int month;
    private int day;
    public Date(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {
        year = aInputStream.readInt();
        month = aInputStream.readInt();
        day = aInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
        aOutputStream.writeInt(year);
        aOutputStream.writeInt(month);
        aOutputStream.writeInt(day);
    }
}
