package com.example.firstaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.realm.Realm
import okhttp3.*
import java.io.IOException


class GlobalEstadistics : Fragment() {
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
        val view =  inflater.inflate(R.layout.fragment_global_estadistics, container, false)
        super.onCreate(savedInstanceState)
        recyclerView = view!!.findViewById(R.id.recyclerViewTest2)
        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.addItemDecoration(DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
        getAll()
        return view

    }

    fun getAll() {


            val requestGet = Request.Builder().get().url("http://52.47.125.164:8080/scores").build()

            client.newCall(requestGet).enqueue(object : Callback {
                override fun onResponse(call: Call, response: Response) {
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
                    println(e.toString())
                }
            })

    }


}


