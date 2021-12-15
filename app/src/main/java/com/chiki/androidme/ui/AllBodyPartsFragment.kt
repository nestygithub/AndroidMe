package com.chiki.androidme.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.chiki.androidme.databinding.FragmentAllBodyPartsBinding
import com.chiki.androidme.viewmodels.AllPartsViewModel

class AllBodyPartsFragment : Fragment() {

    //ViewModels
    private val allPartsViewModel: AllPartsViewModel by activityViewModels()

    //Binding
    private var _binding:FragmentAllBodyPartsBinding? = null
    private val binding get() = _binding!!

    //Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAllBodyPartsBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.allPartsViewModel = allPartsViewModel
        binding.lifecycleOwner = this
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}