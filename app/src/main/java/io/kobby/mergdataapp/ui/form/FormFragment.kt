package io.kobby.mergdataapp.ui.form

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import io.kobby.mergdataapp.R
import io.kobby.mergdataapp.data.api.model.Form
import io.kobby.mergdataapp.databinding.FragmentFormBinding
import io.kobby.mergdataapp.util.Resource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

import org.koin.androidx.viewmodel.ext.android.viewModel

const val TAG = "FORM_FRAGMENT"

class FormFragment : Fragment(R.layout.fragment_form) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFormBinding.bind(view)

        val viewModel: FormViewModel by viewModel()
        val formAdapter = FormAdapter()


        binding.apply {

            recyclerView.apply {
                adapter = formAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.formFlow.collectLatest { result ->
                        when (result) {
                            is Resource.Success -> {
                                val form = result.data as Form
                                val res = form.questions?.sortedBy { it.question_number }

                                progressBar.isVisible = false
                                textViewError.isVisible = false


                                formAdapter.submitList(res)
                            }
                            is Resource.Loading -> {
                                progressBar.isVisible = true
                            }
                            is Resource.Failure -> {
                                progressBar.isVisible = false
                                textViewError.isVisible = true
                                textViewError.text = result.errorMsg
                            }
                            is Resource.Exception -> {
                                result.throwable.localizedMessage?.let {
                                    progressBar.isVisible = false
                                    textViewError.isVisible = true
                                    textViewError.text = it

                                }

                            }
                        }

                    }

                }
            }



        }

    }
}