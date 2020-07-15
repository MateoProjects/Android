package com.example.firstaplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_carta_view.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class CartaViewFragment : Fragment() {

    // data variables
    private var cartaGirada: FlipedCard? = null
    private var cardList = emptyList<FlipedCard>()
    private var count_card : Int = 0
    // UI compoenents
    private lateinit var buttonBack: View
    private lateinit var buttonStart: View




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_carta_view, container, false)
        loadComponents(view)
        setUpClickListeners(view)
        return view
    }


    private fun loadComponents(view:View) {
        buttonBack = view.findViewById<Button>(R.id.back_main)
        buttonStart = view!!.findViewById<Button>(R.id.start) // he creat aquest button
    }




    private fun setUpClickListeners(view: View) {
        buttonBack.setOnClickListener {
            BackDialog().newInstance(view.context , activity!!).show()

        }

        buttonStart.setOnClickListener{
            cronometre.format = "Time: %s"
            cronometre.base = (SystemClock.elapsedRealtime())
            cronometre.start()
            startGame(view) // he mogut unicament start game al listener aqui i poc mes
        }



    }


    private fun finish_game() {
        cronometre.stop()
        val client = OkHttpClient()
        val jsonMediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
        val rec = Record("Ramon" , cronometre.text.toString().replace("Time: " , "") , SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().time))
        val recordJson = Gson().toJson(rec).toRequestBody(jsonMediaType)
        println(recordJson)
        val requestPost = Request
            .Builder()
            .post(recordJson)
            .url("http://52.47.125.164:8080/scores")
            .build()

        client.newCall(requestPost).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Error al añadir nuevo record!")
                println(e.toString())
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    println("Nuevo record añadido correctamente!")
                    //Toast.makeText(context , "Record Global Añadidod" , Toast.LENGTH_SHORT).show()
                } else {
                    println("Error al añadir nuevo record!")
                    println(response.toString())
                    println(response.body?.string())
                }
            }
        })


    }
    private fun startGame(view: View) {
        cardList = generateRandomizedCardList(view)
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


    private fun generateRandomizedCardList(view: View): List<FlipedCard> {
        val cardImages = listOf(
            R.drawable.alex,
            R.drawable.dr_boom,
            R.drawable.dummy,
            R.drawable.leeroy

        ).shuffled()

        return listOf(
            FlipedCard(view.findViewById(R.id.carta), cardImages[0]),
            FlipedCard(view.findViewById(R.id.carta2), cardImages[1]),
            FlipedCard(view.findViewById(R.id.carta3), cardImages[2]),
            FlipedCard(view.findViewById(R.id.carta4), cardImages[3]),
            FlipedCard(view.findViewById(R.id.carta5), cardImages[0]),
            FlipedCard(view.findViewById(R.id.carta6), cardImages[1]),
            FlipedCard(view.findViewById(R.id.carta7), cardImages[2]),
            FlipedCard(view.findViewById(R.id.carta8), cardImages[3])
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





