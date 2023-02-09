package io.kobby.mergdataapp.ui.form


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.kobby.mergdataapp.data.FormRepository
import io.kobby.mergdataapp.data.api.model.Form
import io.kobby.mergdataapp.util.Resource

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class FormViewModel( state: SavedStateHandle,private val repository: FormRepository) : ViewModel() {

    val formFlow = state.getStateFlow("endpoint","").flatMapLatest {
        repository.getForm(it)
    }






}