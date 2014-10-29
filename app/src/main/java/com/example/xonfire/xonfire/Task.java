package com.example.xonfire.xonfire;

import android.app.Activity;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Kien Truong on 10/29/2014.
 */
public class Task implements Serializable {
    public static final String WELL_BEING = "Well-being";
    public static final String WORK = "Work";
    public static final String SPIRITUALITY = "Spirituality";
    private String name;
    private String description;
    private String taskType;
    private int taskButtonNumber;

    private transient Activity actvitiy;

    public Task(Activity act) {
        this.actvitiy = act;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getTaskButtonNumber() {
        return taskButtonNumber;
    }

    public void setTaskButtonNumber(int taskButtonNumber) {
        this.taskButtonNumber = taskButtonNumber;
    }

    public void read() throws IOException, ClassNotFoundException {
        Log.d(Goal.class.getSimpleName(),"Reading Task");
        FileInputStream fis = actvitiy.openFileInput(LogTask.FILENAME + "_" + taskButtonNumber);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Task newTask = (Task) ois.readObject();
        fis.close();
        ois.close();
        this.setName(newTask.getName());
        this.setDescription(newTask.getDescription());
        this.setTaskType(newTask.getTaskType());

    }

    public void write() throws IOException {
        String filename = LogTask.FILENAME + "_" + taskButtonNumber;
        Log.d(Goal.class.getSimpleName(),"Writing " + toString() + " to file '" +filename + "'");
        FileOutputStream fos = actvitiy.openFileOutput(filename, LogTask.MODE_PRIVATE);

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", taskType='" + taskType + '\'' +
                ", taskButtonNumber=" + taskButtonNumber +
                '}';
    }
}
