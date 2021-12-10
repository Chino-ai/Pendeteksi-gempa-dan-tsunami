package com.zaelani.pendeteksigempadantsunami.ui.dirasakan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaelani.pendeteksigempadantsunami.databinding.FragmentDirasakanBinding
import com.zaelani.pendeteksigempadantsunami.viewmodel.ViewModelFactory

class DirasakanFragment : Fragment() {

    private var _fragmentDirasakanBinding: FragmentDirasakanBinding? = null
    val fragmentDirasakanBinding get() = _fragmentDirasakanBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _fragmentDirasakanBinding = FragmentDirasakanBinding.inflate(layoutInflater, container, false)
        return fragmentDirasakanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            showProgressBar(true)

            val dirasakanAdapter = DirasakanAdapter()
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[DirasakanViewModel::class.java]
            viewModel.getGempaDirasakan().observe(viewLifecycleOwner, {gempaDirasakan ->
                showProgressBar(false)
                dirasakanAdapter.setListGempa(gempaDirasakan)
                dirasakanAdapter.notifyDataSetChanged()
            })

            with(fragmentDirasakanBinding.rvGempa){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = dirasakanAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentDirasakanBinding = null
    }

    private fun showProgressBar(state: Boolean) {
        if (state) {
            fragmentDirasakanBinding.progressBar.visibility = View.VISIBLE
        } else {
            fragmentDirasakanBinding.progressBar.visibility = View.GONE
        }

    }
}