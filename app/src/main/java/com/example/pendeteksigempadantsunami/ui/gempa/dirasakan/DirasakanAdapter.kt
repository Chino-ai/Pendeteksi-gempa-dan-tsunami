package com.example.pendeteksigempadantsunami.ui.gempa.dirasakan


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pendeteksigempadantsunami.data.local.DirasakanEntity
import com.example.pendeteksigempadantsunami.databinding.ItemDirasakanBinding
import java.util.ArrayList


class DirasakanAdapter : RecyclerView.Adapter<DirasakanAdapter.DirasakanViewHolder>() {

    private var listDirasakan = ArrayList<DirasakanEntity>()

    fun setDirasakan(courses: List<DirasakanEntity>?) {
        if (courses == null) return
        this.listDirasakan.clear()
        this.listDirasakan.addAll(courses)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DirasakanViewHolder {
        val itemDirasakanBinding =
            ItemDirasakanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DirasakanViewHolder(itemDirasakanBinding)
    }

    override fun onBindViewHolder(holder: DirasakanViewHolder, position: Int) {
        val dirasakan = listDirasakan[position]
        holder.bind(dirasakan)
    }

    override fun getItemCount(): Int = listDirasakan.size

    class DirasakanViewHolder(private val binding: ItemDirasakanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dirasakanEntity: DirasakanEntity) {
            with(binding) {

            }
        }
    }


}