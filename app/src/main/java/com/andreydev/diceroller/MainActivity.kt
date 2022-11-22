package com.andreydev.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val rollButton: Button = findViewById(R.id.button)
            rollButton.setOnClickListener { rollDice() }

            rollDice()
        }

        main()
    }

    fun main() {

        // Toda esta esta seccion del Main es para imprimer los lanzamientos por consola.
        val myFirstDice = Dice(6)
        val rollResult = myFirstDice.roll()
        val luckyNumber = 4

        when (rollResult) {
            luckyNumber -> println("You won!")
            1 -> println("¡Lo siento! Obtuviste un 1. ¡Inténtalo de nuevo!")
            2 -> println("Lamentablemente, sacaste un 2. ¡Inténtalo de nuevo!")
            3 -> println("Desafortunadamente, sacaste un 3. Inténtalo de nuevo")
            5 -> println("¡No llores! Sacaste un 5. ¡Inténtalo de nuevo!")
            6 -> println("¡Disculpas! Obtuviste un 6. ¡Inténtalo de nuevo!")
        }

//        val mySecondDice = Dice(20, "Green")
//        println("Your ${mySecondDice.numSides} sided dice rolled  ${mySecondDice.roll()} and has the color ${mySecondDice.colorSides}!")
//        val diceRage = 1..6 // Indica el rango de numero es decir del 1,2,3,4,5,6
//        val randomNumber = diceRage.random() // Manera mas tradicional de hacer un random
//        // val randomNumberTwo = (1..6).random() // Otra forma de hacer un random mas facil
//        println("Random number: $randomNumber")

    }

    /**
     * Tira los dados y actualiza la pantalla con el resultado.
     */
    private fun rollDice() {
        // Crea un nuevo objeto Dice con 6 lados y tira los dados
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Encuentre el ImageView en el diseño
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine qué ID de recurso extraíble usar en función de la tirada de dados
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Actualice ImageView con el ID de recurso dibujable correcto
        diceImage.setImageResource(drawableResource)

        // Actualizar la descripción del contenido
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(val numSides: Int) {

        fun roll(): Int {

            return (1..numSides).random()
        }
    }


}