package com.example.jediproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jediproject.R
import com.example.jediproject.classes.Record
import com.example.jediproject.classes.RecordAdapter
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.realm.Realm
import okhttp3.*
import java.io.IOException


class EstGlobalsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var  adapter : RecordAdapter
    val client = OkHttpClient()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val realm: Realm = Realm.getDefaultInstance()
        adapter = RecordAdapter(context!!)
        val view =  inflater.inflate(R.layout.fragment_est_globals, container, false)
        super.onCreate(savedInstanceState)
        recyclerView = view!!.findViewById(R.id.recyclerViewTest2)
        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.addItemDecoration(DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
        val text = view.findViewById<TextView>(R.id.text_estadistiques_buides_glob)
        val image = view.findViewById<ImageView>(R.id.no_estadistiques_glob)
        getAll(text,image)
        return view

    }

    fun getAll(text:TextView, image:ImageView) {


        val requestGet = Request.Builder().get().url("http://52.47.125.164:8080/scores").build()
        image.visibility = View.VISIBLE
        text.visibility = View.VISIBLE

        client.newCall(requestGet).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                text.visibility = View.INVISIBLE
                image.visibility = View.INVISIBLE
                val responseBody = response.body!!

                val json = Gson().fromJson(responseBody.string(), JsonObject::class.java)
                val jsonScores = json.getAsJsonArray("records")

                val newScores = mutableListOf<Record>()
                for (scoreJson in jsonScores) {
                    newScores.add(Gson().fromJson(scoreJson, Record::class.java))
                }
                println(newScores.size.toString())
                // success
                activity!!.runOnUiThread(Runnable {
                    adapter.setData(newScores)

                }
                )

            }

            override fun onFailure(call: Call, e: IOException) {

            }
        })

    }
}