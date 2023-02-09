package io.kobby.mergdataapp.ui.form

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import io.kobby.mergdataapp.R
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


binding.apply {

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.formFlow.collectLatest { result ->
                    when (result) {
                        is Resource.Success -> {
                            textViewForm.text = result.data.toString()
                            Log.d(TAG, result.data.toString())
                        }
                        is Resource.Loading -> {
                            textViewForm.text = "Loading"
                            Log.d(TAG, "Loading!")
                        }
                        is Resource.Failure -> {
                            textViewForm.text = result.errorMsg
                            Log.d(TAG, result.errorMsg)
                        }
                        is Resource.Exception -> {
                            result.throwable.localizedMessage?.let {
                                textViewForm.text = it
                                Log.d(TAG, it) }

                        }

                    }

                }

            }
        }
}




    }
}