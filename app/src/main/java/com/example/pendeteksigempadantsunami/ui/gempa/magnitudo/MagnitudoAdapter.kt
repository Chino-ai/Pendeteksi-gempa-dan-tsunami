package com.example.pendeteksigempadantsunami.ui.gempa.magnitudo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pendeteksigempadantsunami.data.local.MagnitudoEntity
import com.example.pendeteksigempadantsunami.databinding.ItemMagnitudoBinding
import java.util.ArrayList

class MagnitudoAdapter : RecyclerView.Adapter<MagnitudoAdapter.MagnitudoViewHolder>() {


    private var listMagnitudo = ArrayList<MagnitudoEntity>()

    fun setMagnitudo(courses: List<MagnitudoEntity>?) {
        if (courses == null) return
        this.listMagnitudo.clear()
        this.listMagnitudo.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagnitudoViewHolder {
        val itemMagnitudoBinding =
            ItemMagnitudoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MagnitudoViewHolder(itemMagnitudoBinding)
    }

    override fun onBindViewHolder(holder: MagnitudoViewHolder, position: Int) {
        val magnitudo = listMagnitudo[position]
        holder.bind(magnitudo)
    }

    override fun getItemCount(): Int = listMagnitudo.size

    class MagnitudoViewHolder(private val binding: ItemMagnitudoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(magnitudoEntity: MagnitudoEntity) {
            with(binding) {

            }
        }
    }
}