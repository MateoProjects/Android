package com.example.firstaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.view.isVisible

class CartaView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carta_view)
        val back = findViewById<Button>(R.id.back_main)
        var carta1: Boolean = false;
        val list: List<FlipedCard> = listOf(
            FlipedCard(findViewById<ImageButton>(R.id.carta)),
            FlipedCard(findViewById<ImageButton>(R.id.carta2)),
            FlipedCard(findViewById<ImageButton>(R.id.carta3)),
            FlipedCard(findViewById<ImageButton>(R.id.carta4)),
            FlipedCard(findViewById<ImageButton>(R.id.carta5)),
            FlipedCard(findViewById<ImageButton>(R.id.carta6)),
            FlipedCard(findViewById<ImageButton>(R.id.carta7)),
            FlipedCard(findViewById<ImageButton>(R.id.carta8)),
            FlipedCard(findViewById<ImageButton>(R.id.carta9))
        )

        var list2: List<Int> = listOf(R.drawable.alex , R.drawable.dr_boom, R.drawable.dummy, R.drawable.hex,
                                      R.drawable.leeroy , R.drawable.lord , R.drawable.mana , R.drawable.hex , R.drawable.dr_boom).shuffled()
        var x = 0
        for (card in list) {
            setOnClick(card, list2[x])
            ++x


        }

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {}
            startActivity(intent)
        }
    }


    private fun setOnClick(flipedCard: FlipedCard, id: Int) {
        flipedCard.imageButton.setOnClickListener {
            if (!flipedCard.fliped) {
                flipedCard.imageButton.setImageResource(R.drawable.hearth_cardback)
            } else {
                flipedCard.imageButton.setImageResource(id)
                //flipedCard.imageButton.isVisible = false

            }
            flipedCard.fliped = !flipedCard.fliped
        }

    }
}