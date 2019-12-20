package com.example.rundiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PlayActivity : AppCompatActivity() {

    lateinit var textViewResult: TextView
    lateinit var buttonPlay: Button

    fun runDice(qtdDice: Int) {
        var textResult: String = ""
        var qtdDiceTotal = QtdActivity.qtdDice + 1

        for (i in 1 until qtdDiceTotal){
            textResult += MainActivity.nameList.random()
        }

        textViewResult.text = textResult
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        buttonPlay = findViewById(R.id.buttonPlay)
        textViewResult = findViewById(R.id.textViewResult)

        buttonPlay.setOnClickListener{
            runDice(QtdActivity.qtdDice)
        }


    }
}
