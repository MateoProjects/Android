package com.example.firstaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm


class EstadistiquesFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var  adapter : RecordAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val realm: Realm = Realm.getDefaultInstance()

        adapter = RecordAdapter(context!!)
        val view =  inflater.inflate(R.layout.fragment_estadistiques, container, false)
        super.onCreate(savedInstanceState)
        recyclerView = view!!.findViewById(R.id.recyclerViewTest)
        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.addItemDecoration(DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
        adapter.setData(estadistiquesDb.getAll())

        realm.where(Record::class.java)
            .findAllAsync()
            .addChangeListener { record ->
                println(record)
            }
        return view
    }


}