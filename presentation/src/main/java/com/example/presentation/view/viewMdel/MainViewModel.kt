package com.example.presentation.view.viewMdel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainLoveResponse
import com.example.domain.usecase.CheckLoveCalculatorUseCase
import com.example.domain.utils.ErrorType
import com.example.domain.utils.RemoteErrorEmitter
import com.example.domain.utils.ScreenState
import com.example.presentation.widget.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkLoveCalculatorUseCase: CheckLoveCalculatorUseCase
) : ViewModel(), RemoteErrorEmitter {

    private var _apiCallEvent = MutableLiveData<Event<ScreenState>>()   // 내부용
    val apiCallEvent: LiveData<Event<ScreenState>> get() = _apiCallEvent // 외부용

    var apiCallResult = DomainLoveResponse("","",0,"")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMesses = "none"

    var manNameResult = "man"
    var womanNameResult = "woman"
    
    fun checkLoveCalculator(host: String, key: String, mName: String, wName: String) =
        viewModelScope.launch {
            checkLoveCalculatorUseCase.excute(this@MainViewModel, host, key, mName, wName)
                .let {
                    response ->
                    if(response != null){
                        apiCallResult = response
                        _apiCallEvent.value = Event(ScreenState.LOADING)
                    } else
                        _apiCallEvent.value = Event(ScreenState.ERROR)

                }
        }


    override fun onError(msg: String) {
        apiErrorMesses = msg

    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }


}
