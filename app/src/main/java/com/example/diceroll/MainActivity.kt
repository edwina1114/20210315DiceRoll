package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //way1 :(public)data member(可為空）
    // var diceImage: ImageView ?= null

    //way2 :(public)data member(可為空）
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollbutton)
        rollButton.setOnClickListener{rollDice()}       //lambda expression

        diceImage = findViewById(R.id.diceimage)    //減少findViewById被呼叫的次數（只會呼叫一次）
    }

    private fun rollDice() {
        //chaining call
        //Toast.makeText(this,"Button Clicked",Toast.LENGTH_SHORT).show()

        val result = (1..6).random()

        val drawableResource = when (result)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6   //一定要有else!!!
        }

        //set image source to imageview
        diceImage.setImageResource(drawableResource)

    }


}