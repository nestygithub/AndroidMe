package com.chiki.androidme.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.chiki.androidme.adapters.BodyPartAdapter
import com.chiki.androidme.databinding.FragmentMasterListBinding
import com.chiki.androidme.viewmodels.AllPartsViewModel

class MasterListFragment : Fragment() {
    //ViewModels
    private val allPartsViewModel: AllPartsViewModel by activityViewModels()

    //Binding
    private var _binding:FragmentMasterListBinding? = null
    private val binding get() = _binding!!

    //Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMasterListBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = BodyPartAdapter{position->
            allPartsViewModel.onGridBodyPartClicked(position)
        }
        binding.allPartsViewModel = allPartsViewModel
        binding.lifecycleOwner = this

        //Observers
        allPartsViewModel.navigateToAllPartsFragment.observe(viewLifecycleOwner){navigate->
            if (navigate){
                navigateToAllPartsFragment()
                allPartsViewModel.doneNavigateToAllPartsFragment()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Actions
    private fun navigateToAllPartsFragment(){
        val action = MasterListFragmentDirections.actionMasterListFragmentToAllBodyPartsFragment()
        findNavController().navigate(action)
    }
}