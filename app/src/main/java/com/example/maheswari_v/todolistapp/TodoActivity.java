package com.example.maheswari_v.todolistapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;


public class TodoActivity extends AppCompatActivity  {

    private ArrayList<Task> tasks = new ArrayList<Task>();
    private TaskAdapter<Task> taskAdapter;
    private ListView taskList;

    TodoManager tm = new TodoManager();
    //public static final String mtask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = (ListView)findViewById(R.id.taskView);
        taskList.setEmptyView(findViewById(R.id.empty));
        taskAdapter = new TaskAdapter<Task>(this, tasks);
        taskList.setAdapter(taskAdapter);


        taskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                System.out.println("hello");
                onListItemClick(v,pos,id);
            }
        });
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                final EditText taskEditText = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add a new task")
                        .setMessage("Add your task to do")
                        .setView(taskEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());
                                tm.addTask(taskAdapter, task);
                                //mtask = task;

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onRemoveTask(View view) {
        int position = 0;
        View v = (View) view.getParent();
        Button doneTask = (Button) v.findViewById(R.id.doneBtn);
        doneTask.setTag(position);
        Task task = taskAdapter.getItem(position);
        tm.removeTask(taskAdapter, task);
   }

    public void onAddDescription(View view){
        int position = 0;
        final EditText descEditText = new EditText(this);
        View v = (View) view.getParent();
        Button doneTask = (Button) v.findViewById(R.id.descButton);
        doneTask.setTag(position);
        final Task task = taskAdapter.getItem(position);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Add description")
                .setMessage("Add description for your task to do")
                .setView(descEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String taskDesc = String.valueOf(descEditText.getText());
                        if(taskDesc!=null) {
                            task.setDescription(taskDesc);
                        }
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }

    public void onListItemClick(View v, int position, long id){
        displayPopupWindow(v, "task description hello");
    }

    private void displayPopupWindow(View anchorView, String taskDesc){
        TextView popupView;
        PopupWindow popup = new PopupWindow(this);
        View layout = getLayoutInflater().inflate(R.layout.popup_content, null);
        popup.setContentView(layout);

        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);

        popupView = (TextView) findViewById(R.id.popup_desc);
        popupView.setText(taskDesc);
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);

        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAsDropDown(anchorView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



}