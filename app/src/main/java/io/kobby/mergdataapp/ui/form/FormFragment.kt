package io.kobby.mergdataapp.ui.form

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import io.kobby.mergdataapp.R
import io.kobby.mergdataapp.data.api.model.Form
import io.kobby.mergdataapp.data.api.model.Question
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
        layoutManager=LinearLayoutManager(requireContext())
        setHasFixedSize(true)
    }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.formFlow.collectLatest { result ->
                    when (result) {
                        is Resource.Success -> {
                            progressBar.visibility = View.INVISIBLE
                         val form =  result.data as Form
                            formAdapter.submitList(form.questions)
                        }
                        is Resource.Loading -> {
                            progressBar.visibility = View.VISIBLE
                        }
                        is Resource.Failure -> {
                            progressBar.visibility = View.INVISIBLE
                            textViewError.text = result.errorMsg
                        }
                        is Resource.Exception -> {
                            result.throwable.localizedMessage?.let {
                                Log.d(TAG, it) }

                        }

                    }

                }

            }
        }
}




    }

}