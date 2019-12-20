package com.example.rundiceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var textViewMessage: TextView

    lateinit var buttonClickMe: Button
    lateinit var buttonReset: Button
    lateinit var buttonNext1: Button

    var prev: String = ""
    var cnt_prev: Int = 0

    companion object{
        var nameList: ArrayList<String> = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //specify vars

        editTextName   = findViewById(R.id.editTextName)
        textViewMessage= findViewById(R.id.textViewMessage)

        buttonClickMe  = findViewById(R.id.buttonClickMe)
        buttonReset    = findViewById(R.id.buttonReset)
        buttonNext1    = findViewById(R.id.buttonNext1)

        //tell how to use this button - listener

        buttonClickMe.setOnClickListener{ it: View? ->

            this.cnt_prev++

            var name = cnt_prev.toString() + " " + editTextName.text + "\n"
            nameList.add(name)

            this.prev += name

            textViewMessage.text = "ADDED:" + "\n" + "$prev"

        }

        buttonReset.setOnClickListener{
            if(nameList.isNotEmpty()) {
                nameList.clear()
                this.prev = ""
                this.textViewMessage.text = ""
                this.cnt_prev = 0
            }
        }

        buttonNext1.setOnClickListener{

            if(nameList.isNotEmpty()) {
                //call new activity
                val intent  = Intent(this, QtdActivity::class.java)
                startActivity(intent)
            }
            else {
                textViewMessage.text = "You should Add first!"
            }

        }
    }


}
