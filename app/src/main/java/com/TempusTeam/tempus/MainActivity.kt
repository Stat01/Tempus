package com.TempusTeam.tempus

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AbsSeekBar
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var addTaskButton: ImageButton
    private lateinit var taskLinearLayout: LinearLayout
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
        addTaskButton = findViewById<ImageButton>(R.id.addTaskButton)
        taskLinearLayout = findViewById<LinearLayout>(R.id.taskLinearLayout)
        tasks = ArrayList()


        //Add task button
        addTaskButton.setOnClickListener(object: View.OnClickListener{
            @SuppressLint("SetTextI18n")
            override fun onClick(v: View?) {
                var newCheckBox = TaskCreator.createTask(applicationContext)

                newCheckBox.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
                newCheckBox.text = "Task" + tasks.size.toString()

                //Complete task
                newCheckBox.setOnClickListener(object: View.OnClickListener{
                    override fun onClick(v: View?) {
                        taskLinearLayout.removeView(v)
                        tasks.remove(v)
                    }
                })
                taskLinearLayout.addView(newCheckBox)

                tasks.add(newCheckBox)
                Log.println(Log.INFO, "Tasks", tasks.toString())
            }
        })
    }
}