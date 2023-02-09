package io.kobby.mergdataapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import io.kobby.mergdataapp.R
import io.kobby.mergdataapp.databinding.FragmentHomeBinding

import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)

        val viewModel: HomeViewModel by viewModel()

        binding.apply {
            buttonTest1.setOnClickListener {
                viewModel.buttonTestOneClicked()
            }
            buttonTest2.setOnClickListener {
                viewModel.buttonTestTwoClicked()
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.homeEventChannel.collect { event ->
                when (event) {
                    is HomeViewModel.HomeEvent.NavigateToForm -> {
                        val action =
                            HomeFragmentDirections.actionHomeFragmentToFormFragment(event.endpoint)
                        findNavController().navigate(action)
                    }
                }
            }
        }


    }
}