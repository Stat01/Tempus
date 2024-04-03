package com.TempusTeam.tempus

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsSeekBar
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var checkbox_task_1: CheckBox

    private lateinit var addTaskButton: ImageButton

    private lateinit var tasks: ArrayList<CheckBox>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        checkbox_task_1 = findViewById<CheckBox>(R.id.checkbox_task_1)
        addTaskButton = findViewById<ImageButton>(R.id.addTaskButton)

        checkbox_task_1.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Log.println(Log.INFO, "", checkbox_task_1.isChecked.toString())
            }
        })

        //Add task button
        addTaskButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {

            }
        })
    }
}