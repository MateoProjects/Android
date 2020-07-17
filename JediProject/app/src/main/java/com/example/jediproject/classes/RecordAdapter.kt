package com.example.jediproject.classes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jediproject.R

class RecordAdapter(val context: Context) : RecyclerView.Adapter<RecordAdapter.RecordViewHolder>() {
    private var dataset = estadistiquesDb.getAll()
    class RecordViewHolder(val context: Context, itemView: View):RecyclerView.ViewHolder(itemView){
        val texViewNom = itemView.findViewById<TextView>(R.id.nom_record)
        val textViewScore = itemView.findViewById<TextView>(R.id.time_record)
        val textViewDate = itemView.findViewById<TextView>(R.id.date_record)


        fun bindRecord (record: Record) {
            texViewNom.text = record.name
            textViewDate.text = record.date
            textViewScore.text = record.score
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.record_layout, parent, false)
        return RecordViewHolder(
            context,
            view
        )
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bindRecord(dataset[position])
    }

    fun setData(data:List<Record>) {
        dataset = data.sortedBy { it.score }
        notifyDataSetChanged()
    }





}