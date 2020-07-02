package com.example.secondapp

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class PersonaAdapter(val onPersonClick:(Persona)->Unit , val context: Context) : RecyclerView.Adapter<PersonaAdapter.PersonaViewwHolder>() {

    private var dataset = emptyList<Persona>()
    class PersonaViewwHolder(val context: Context, itemView:View , val onPersonClick: (Persona) -> Unit):RecyclerView.ViewHolder(itemView) {
        val texViewNombre = itemView.findViewById<TextView>(R.id.textViewNombre)
        val texViewApellido = itemView.findViewById<TextView>(R.id.textViewApellido)
        val texViewAltura = itemView.findViewById<TextView>(R.id.textViewAltura)
        val texViewEdat = itemView.findViewById<TextView>(R.id.textViewEdad)

        fun bindPerson(persona:Persona) {
            texViewNombre.text = persona.nombre
            texViewApellido.text = persona.Apellido
            texViewEdat.text = String.format(context.getString(R.string.edad), persona.Edat.toString())
            texViewAltura.text = String.format(context.getString(R.string.altura),persona.Altura.toString())
            itemView.setOnClickListener() {
                onPersonClick(persona)

            }
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewwHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.persona_item, parent , false)
        return PersonaViewwHolder(context, view , onPersonClick)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: PersonaViewwHolder, position: Int) {
        holder.bindPerson(dataset[position])
    }

    fun setData(list: List<Persona>) {
        dataset = list
        notifyDataSetChanged()
    }

    fun onPersonaClick() {

    }

}