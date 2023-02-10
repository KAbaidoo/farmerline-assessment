package io.kobby.mergdataapp.ui.form


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import io.kobby.mergdataapp.data.FormRepository
import kotlinx.coroutines.flow.*



class FormViewModel( state: SavedStateHandle,private val repository: FormRepository) : ViewModel() {

    val formFlow = state.getStateFlow("endpoint","").flatMapLatest {
        repository.getForm(it)
    }






}