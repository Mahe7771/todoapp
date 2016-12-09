package com.example.maheswari_v.todolistapp;

import java.text.SimpleDateFormat;


public class TodoManager {

    protected void addTask(TaskAdapter<Task> taskAdapter, String task){
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);

        Task newTask = new Task(task, dateString);
        taskAdapter.add(newTask);

    }

    protected void removeTask(TaskAdapter<Task> taskAdapter, Task task ) {
        taskAdapter.remove(task);
    }

}
