package com.zaelani.pendeteksigempadantsunami.ui.magnitude

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaelani.pendeteksigempadantsunami.databinding.FragmentMagnitudoBinding
import com.zaelani.pendeteksigempadantsunami.viewmodel.ViewModelFactory

class MagnitudoFragment : Fragment() {
    private var _fragmentMagnitudoBinding: FragmentMagnitudoBinding? = null
    val fragmentMagnitudoBinding get() = _fragmentMagnitudoBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _fragmentMagnitudoBinding = FragmentMagnitudoBinding.inflate(layoutInflater, container, false)
        return fragmentMagnitudoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            showProgressBar(true)

            val magnitudoAdapter = MagnitudoAdapter()
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MagnitudoViewModel::class.java]
            viewModel.getGempaMagnitudo().observe(viewLifecycleOwner, {gempaMagnitudo ->
                showProgressBar(false)
                magnitudoAdapter.setListGempa(gempaMagnitudo)
                magnitudoAdapter.notifyDataSetChanged()
            })

            with(fragmentMagnitudoBinding.rvGempa){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = magnitudoAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentMagnitudoBinding = null
    }

    private fun showProgressBar(state: Boolean) {
        if (state) {
            fragmentMagnitudoBinding.progressBar.visibility = View.VISIBLE
        } else {
            fragmentMagnitudoBinding.progressBar.visibility = View.GONE
        }

    }
}