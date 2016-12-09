package com.example.maheswari_v.todolistapp;

public class Task {

    public String todoTask;
    public String date;
    public String description;

    public Task(String task, String date)
    {
        this.todoTask = task;
        this.date = date;
    }

    public Task(String task, String date, String description)
    {
        this.todoTask = task;
        this.date = date;
        this.description = description;
    }

    public void setTodoTask(String todoTask) {
        this.todoTask = todoTask;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTodoTask() {
        return todoTask;
    }

    public String getDate(){
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
