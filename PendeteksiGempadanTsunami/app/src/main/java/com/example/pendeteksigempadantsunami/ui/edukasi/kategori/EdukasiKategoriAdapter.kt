package com.example.pendeteksigempadantsunami.ui.edukasi.kategori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pendeteksigempadantsunami.data.local.DirasakanEntity
import com.example.pendeteksigempadantsunami.data.local.EdukasiKategoriEntity
import com.example.pendeteksigempadantsunami.databinding.ItemDirasakanBinding
import com.example.pendeteksigempadantsunami.databinding.ItemKategoriEdukasiBinding
import com.example.pendeteksigempadantsunami.ui.gempa.dirasakan.DirasakanAdapter
import java.util.ArrayList

class EdukasiKategoriAdapter : RecyclerView.Adapter<EdukasiKategoriAdapter.KategoriViewHolder>() {

    private var listKategori = ArrayList<EdukasiKategoriEntity>()

    fun setKategori(kategori: List<EdukasiKategoriEntity>?) {
        if (kategori == null) return
        this.listKategori.clear()
        this.listKategori.addAll(kategori)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KategoriViewHolder {
        val itemKategoriBinding =
            ItemKategoriEdukasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KategoriViewHolder(itemKategoriBinding)
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        val dirasakan = listKategori[position]
        holder.bind(dirasakan)
    }

    override fun getItemCount(): Int = listKategori.size

    class KategoriViewHolder(private val binding: ItemKategoriEdukasiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(kategoriEntity: EdukasiKategoriEntity) {
            with(binding) {

            }
        }
    }
}