package com.example.pendeteksigempadantsunami.ui.edukasi.pilihan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pendeteksigempadantsunami.data.local.EdukasiKategoriEntity
import com.example.pendeteksigempadantsunami.data.local.EdukasiPilihanEntity
import com.example.pendeteksigempadantsunami.databinding.ItemKategoriEdukasiBinding
import com.example.pendeteksigempadantsunami.databinding.ItemPilihanEdukasiBinding
import java.util.ArrayList

class EdukasiPilihanAdapter :  RecyclerView.Adapter<EdukasiPilihanAdapter.PilihanViewHolder>() {


    private var listPilihan = ArrayList<EdukasiPilihanEntity>()

    fun setPilihan(pilihan: List<EdukasiPilihanEntity>?) {
        if (pilihan == null) return
        this.listPilihan.clear()
        this.listPilihan.addAll(pilihan)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PilihanViewHolder {
        val itemPilihanEdukasi =
            ItemPilihanEdukasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PilihanViewHolder(itemPilihanEdukasi)
    }

    override fun onBindViewHolder(holder: PilihanViewHolder, position: Int) {
        val edukasi = listPilihan[position]
        holder.bind(edukasi)
    }

    override fun getItemCount(): Int = listPilihan.size

    class PilihanViewHolder(private val binding: ItemPilihanEdukasiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(edukasiPilihanEntity: EdukasiPilihanEntity) {
            with(binding) {

            }
        }
    }
}