package io.kobby.mergdataapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import io.kobby.mergdataapp.R
import io.kobby.mergdataapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)

    }
}