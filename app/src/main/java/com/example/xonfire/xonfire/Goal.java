package com.example.xonfire.xonfire;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Kien Truong on 10/25/2014.
 */
public class Goal {
    private final LifeGoal lifeGoal;
    //Enum GoalType {SPIRITUAL,WELLBEING,WORK}
    private String goalType;
    private String name;
    private String description;

    public Goal(LifeGoal lifeGoal) {
        this.lifeGoal = lifeGoal;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
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

    public void read() throws IOException, ClassNotFoundException {
        FileInputStream fis = lifeGoal.openFileInput(lifeGoal.FILENAME + "_" + goalType);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Goal newGoal = (Goal) ois.readObject();
        fis.close();
        ois.close();
        this.setName(newGoal.getName());
        this.setDescription(newGoal.getDescription());

    }

    public void write() throws IOException {
        FileOutputStream fos = null;
        fos = lifeGoal.openFileOutput(LifeGoal.FILENAME + "_" + goalType, LifeGoal.MODE_PRIVATE);

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);

    }
}
