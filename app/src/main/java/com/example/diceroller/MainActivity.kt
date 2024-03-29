package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allow users to roll a dice and view result on screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        // dice roll on app start
        rollDice()
    }

    /**
     * This rolls the dice and updates the screen with the result
     */
    private fun rollDice() {
        // create dice object
        val myDice = Dice(6)
        val rollResult = myDice.roll()

        // show dice roll result
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (rollResult) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // update dice Image
        diceImage.setImageResource(drawableResource)
        // update content description
        diceImage.contentDescription = rollResult.toString()

        // display message
        Toast.makeText(this, "Dice Rolled! You got ${rollResult}", Toast.LENGTH_SHORT).show()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}