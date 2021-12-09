package com.zaelani.pendeteksigempadantsunami.ui.dirasakan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zaelani.pendeteksigempadantsunami.R
import com.zaelani.pendeteksigempadantsunami.data.local.entity.DirasakanEntity
import com.zaelani.pendeteksigempadantsunami.databinding.ItemGempaBinding

class DirasakanAdapter : RecyclerView.Adapter<DirasakanAdapter.DirasakanViewHolder>(){
    private var listGempa = ArrayList<DirasakanEntity>()

    inner class DirasakanViewHolder(private val binding: ItemGempaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(gempaDirasakan: DirasakanEntity){
            with(binding){
                tvTime.text = gempaDirasakan.tanggal + " " + gempaDirasakan.jam
                tvKedalaman.text = itemView.resources.getString(R.string.text_kedalaman, gempaDirasakan.kedalaman)
                tvMagnitudo.text = itemView.resources.getString(R.string.text_magnitudo, gempaDirasakan.magnitude)
                tvLocation.text = itemView.resources.getString(R.string.text_wilayah, gempaDirasakan.wilayah)
                tvPotensiDirasakan.text = itemView.resources.getString(R.string.text_dirasakan, gempaDirasakan.dirasakan)
            }
        }
    }

    fun setListGempa(gempaDirasakan: List<DirasakanEntity>){
        this.listGempa.clear()
        this.listGempa.addAll(gempaDirasakan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirasakanAdapter.DirasakanViewHolder {
        val itemGempaBinding = ItemGempaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DirasakanViewHolder(itemGempaBinding)
    }

    override fun onBindViewHolder(holder: DirasakanAdapter.DirasakanViewHolder, position: Int) {
        val gempaDirasakan = listGempa[position]
        holder.bind(gempaDirasakan)
    }

    override fun getItemCount(): Int  = listGempa.size
}