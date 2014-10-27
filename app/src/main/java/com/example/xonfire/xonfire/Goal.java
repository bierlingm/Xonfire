package com.example.xonfire.xonfire;

import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Kien Truong on 10/25/2014.
 */
public class Goal implements Serializable {
    private static final long serialVersionUID =1l;
    private final transient LifeGoal lifeGoal;
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
        Log.d(Goal.class.getSimpleName(),"Reading Goal");
        FileInputStream fis = lifeGoal.openFileInput(lifeGoal.FILENAME + "_" + goalType);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Goal newGoal = (Goal) ois.readObject();
        fis.close();
        ois.close();
        this.setName(newGoal.getName());
        this.setDescription(newGoal.getDescription());

    }

    public void write() throws IOException {
        Log.d(Goal.class.getSimpleName(),"Writing Goal");
        FileOutputStream fos = null;
        fos = lifeGoal.openFileOutput(LifeGoal.FILENAME + "_" + goalType, LifeGoal.MODE_PRIVATE);

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);

    }
    @Override
    public String toString() {
        return "<name="+name+", description"+description+">";
    }
}
