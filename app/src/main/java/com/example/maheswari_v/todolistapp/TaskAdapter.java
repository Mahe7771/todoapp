package com.example.maheswari_v.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class TaskAdapter<T> extends ArrayAdapter<Task> {

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View taskView, ViewGroup parent) {

        Task task = getItem(position);
        if (taskView == null) {
            taskView = LayoutInflater.from(getContext()).inflate(R.layout.todotask, parent, false);
        }
        TextView tv_taskTitle = (TextView) taskView.findViewById(R.id.task_title);
        TextView tv_dateText = (TextView) taskView.findViewById(R.id.dateText);

        tv_taskTitle.setText(task.todoTask);
        tv_dateText.setText(task.date);

        return taskView;
    }
}