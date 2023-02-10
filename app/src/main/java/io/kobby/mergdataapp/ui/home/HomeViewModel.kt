package io.kobby.mergdataapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
   private val _homeEventChannel = Channel<HomeEvent>()
    val homeEventChannel = _homeEventChannel.receiveAsFlow()

    fun buttonTestTwoClicked() = viewModelScope.launch {
        _homeEventChannel.send(HomeEvent.NavigateToForm("testjson2.json"))
    }

    fun buttonTestOneClicked() = viewModelScope.launch {
        _homeEventChannel.send(HomeEvent.NavigateToForm("testjson1.json"))
    }




       sealed class HomeEvent {
        data class NavigateToForm( var endpoint: String) : HomeEvent()
    }
}