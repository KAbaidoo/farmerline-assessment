package io.kobby.mergdataapp.ui.form

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import io.kobby.mergdataapp.R
import io.kobby.mergdataapp.databinding.FragmentHomeBinding

class FormFragment : Fragment(R.layout.fragment_form) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)

    }
}