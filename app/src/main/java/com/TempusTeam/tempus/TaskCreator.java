package com.TempusTeam.tempus;

import android.content.Context;
import android.widget.CheckBox;

public class TaskCreator {

    static CheckBox createTask(Context context){
        CheckBox new_box = new CheckBox(context);
        return new_box;
    }
}
