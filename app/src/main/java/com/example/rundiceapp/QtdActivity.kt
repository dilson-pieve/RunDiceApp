package com.example.rundiceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class QtdActivity : AppCompatActivity() {


    lateinit var editTextQtd: EditText
    lateinit var buttonQtd: Button

    companion object{
        var qtdDice: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qtd)

        buttonQtd  = findViewById(R.id.buttonQtd)
        editTextQtd= findViewById(R.id.editTextQtd)

        buttonQtd.setOnClickListener{
            qtdDice = editTextQtd.text.toString().toInt()

            if(qtdDice in 0..30) {
                //call new activity
                val intent1  = Intent(this, PlayActivity::class.java)
                startActivity(intent1)
            }

        }
    }
}
