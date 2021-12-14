package com.zaelani.pendeteksigempadantsunami.ui.magnitude

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zaelani.pendeteksigempadantsunami.R
import com.zaelani.pendeteksigempadantsunami.data.local.entity.MagnitudoEntity
import com.zaelani.pendeteksigempadantsunami.databinding.ItemGempaBinding
import com.zaelani.pendeteksigempadantsunami.ui.detailgempa.DetailGempaActivity

class MagnitudoAdapter : RecyclerView.Adapter<MagnitudoAdapter.MagnitudoViewHolder>(){
    private var listGempa = ArrayList<MagnitudoEntity>()

    fun setListGempa(gempaMagnitudo: List<MagnitudoEntity>){
        this.listGempa.clear()
        this.listGempa.addAll(gempaMagnitudo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagnitudoViewHolder {
        val itemGempaBinding = ItemGempaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MagnitudoViewHolder(itemGempaBinding)
    }

    override fun onBindViewHolder(holder: MagnitudoViewHolder, position: Int) {
        val gempaMagnitudo = listGempa[position]
        holder.bind(gempaMagnitudo)
    }

    override fun getItemCount(): Int = listGempa.size

    inner class MagnitudoViewHolder(private val binding: ItemGempaBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(gempaMagnitudo: MagnitudoEntity){
            with(binding){
                tvTime.text = gempaMagnitudo.tanggal + " " + gempaMagnitudo.jam
                tvMagnitudo.text = gempaMagnitudo.magnitude
                tvLocation.text = gempaMagnitudo.wilayah
                tvKedalaman.text = gempaMagnitudo.kedalaman
                tvPotensiDirasakan.text = gempaMagnitudo.potensi
            }
            itemView.setOnClickListener{
                val intent = Intent(itemView.context, DetailGempaActivity::class.java)
                intent.putExtra(DetailGempaActivity.EXTRA_DETAIL_GEMPA, gempaMagnitudo)
                itemView.context.startActivity(intent)
            }
        }
    }
}