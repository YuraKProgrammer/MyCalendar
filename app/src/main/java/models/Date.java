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
    /**
     * Нумерация с 1
     */
    private int month;
    /**
     * Нумерация с 1
     */
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

    @Override
    public String toString(){
        return pNull(day)+"."+pNull(month)+"."+year;
    }

    private static String pNull(int d){
        if (d<10){
            return "0"+d;
        }
        else{
            return String.valueOf(d);
        }
    }

    public static boolean areEquals(Date d1, Date d2){
        if (d1==null || d2==null)
            return false;
        if (d1.getYear()!=d2.getYear())
            return false;
        if (d1.getMonth()!=d2.getMonth())
            return false;
        if (d1.getDay()!=d2.getDay())
            return false;
        return true;
    }
}
