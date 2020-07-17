package com.example.jediproject.classes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jediproject.R
import kotlin.reflect.KFunction0

class FriendAdapter(
    val onFriendClick: (Friend)->Unit,
    val context: Context
) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {
    private var dataset = friendDB.getAll()
    class FriendViewHolder(val context: Context, itemView: View , val onFriendClick:(Friend)->Unit ):RecyclerView.ViewHolder(itemView){
        val texViewNom = itemView.findViewById<TextView>(R.id.nom_friend)
        val textViewCognom = itemView.findViewById<TextView>(R.id.cognom_friend)
        val textViewEdat = itemView.findViewById<TextView>(R.id.edat_friend)
        val textViewJoc = itemView.findViewById<TextView>(R.id.videojoc_friend)

        fun bindRecord (friend: Friend) {
            texViewNom.text = friend.name
            textViewCognom.text = friend.Cognom
            textViewJoc.text = friend.videojoc
            textViewEdat.text = friend.edat.toString()
            itemView.setOnClickListener() {
                onFriendClick(friend)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendAdapter.FriendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friends_layout, parent, false)
        return FriendViewHolder(
            context,
            view , onFriendClick
        )
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bindRecord(dataset[position])
    }

    fun setData(data:List<Friend>) {
        dataset = data.sortedBy { it.name }
        notifyDataSetChanged()
    }
}