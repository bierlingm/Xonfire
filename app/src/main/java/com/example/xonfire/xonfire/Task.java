package com.example.xonfire.xonfire;

/**
 * Created by Kien Truong on 10/29/2014.
 */
public class Task {
    private String name;
    private String description;
    public Task(LogTask logTask) {
    }

    public void read() {
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
}
