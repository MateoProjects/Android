package com.example.firstaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_carta_view.*

var flipped : Boolean = false
var id_image : Int = -1
var id_button : Int = -1
var flipper : FlipedCard? = null
class CartaView : AppCompatActivity() {
    // data variables
    private var cartaGirada: FlipedCard? = null
    private var cardList = emptyList<FlipedCard>()
    private var count_card : Int = 0
    // UI compoenents
    private lateinit var buttonBack: View
    private lateinit var buttonStart: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carta_view)
        loadComponents()
        setUpClickListeners()

    }


    private fun loadComponents() {
        buttonBack = findViewById<Button>(R.id.back_main)
        buttonStart = findViewById<Button>(R.id.start) // he creat aquest button
    }




    private fun setUpClickListeners() {
        buttonBack.setOnClickListener {
            finish()
        }

        buttonStart.setOnClickListener{
            cronometre.format = "Time: %s"
            cronometre.base = (SystemClock.elapsedRealtime())
            cronometre.start()
            startGame() // he mogut unicament start game al listener aqui i poc mes
        }



    }


    private fun finish_game() {
        cronometre.stop()
        Toast.makeText(applicationContext, "Game finished! Your time was " + (
            .elapsedRealtime() - cronometre.base)/1000 + " seconds", Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 2000)
    }
    private fun startGame() {
        cardList = generateRandomizedCardList()
        count_card = 0
        for (card in cardList) {
            setOnClickListener(card)
            card.imageButton.setImageResource(card.cardImage)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            for (card in cardList) {
                card.imageButton.setImageResource(R.drawable.hearth_cardback)
            }
        }, 1000)
    }


    private fun generateRandomizedCardList(): List<FlipedCard> {
        val cardImages = listOf(
            R.drawable.alex,
            R.drawable.dr_boom,
            R.drawable.dummy,
            R.drawable.leeroy

        ).shuffled()

        return listOf(
            FlipedCard(findViewById(R.id.carta), cardImages[0]),
            FlipedCard(findViewById(R.id.carta2), cardImages[1]),
            FlipedCard(findViewById(R.id.carta3), cardImages[2]),
            FlipedCard(findViewById(R.id.carta4), cardImages[3]),
            FlipedCard(findViewById(R.id.carta5), cardImages[0]),
            FlipedCard(findViewById(R.id.carta6), cardImages[1]),
            FlipedCard(findViewById(R.id.carta7), cardImages[2]),
            FlipedCard(findViewById(R.id.carta8), cardImages[3])
        )
    }

    private fun setOnClickListener(card: FlipedCard) {
        card.imageButton.setOnClickListener {
            card.imageButton.setImageResource(card.cardImage)
            if (cartaGirada == null) {
                cartaGirada = card
                cartaGirada!!.imageButton.isClickable = false
            } else {

                if (cartaGirada!!.cardImage != card.cardImage) { // nos hemos equivocado de carta
                    Handler(Looper.getMainLooper()).postDelayed({
                        card.imageButton.setImageResource(R.drawable.hearth_cardback)
                        cartaGirada!!.imageButton.setImageResource(R.drawable.hearth_cardback)
                        cartaGirada!!.imageButton.isClickable = true
                        cartaGirada = null
                    },500)

                }
                else {
                    count_card += 2
                    if(count_card == 8) finish_game()
                    cartaGirada = null

                }

            }
        }
    }
}
