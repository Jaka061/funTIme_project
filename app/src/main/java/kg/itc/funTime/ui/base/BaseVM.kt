package kg.itc.funTime.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import kg.itc.funTime.R
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
open class BaseVM @Inject constructor() : ViewModel() {

    protected val disposable by lazy {
        CompositeDisposable()
    }

    protected val _event by lazy {
        MutableLiveData<BaseEvent>()
    }
    val event: LiveData<BaseEvent>
    get() = _event

    private val _isLoading by lazy {
        MutableLiveData(false)
    }
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    protected fun showLoading(){
        _isLoading.value = true
    }

    protected fun hideLoading(){
        _isLoading.value = false
    }

    protected fun handleError(it: Throwable) {
        _event.value = when(it) {
            is UnknownHostException -> Event.ShowToast(R.string.no_internet)
            else -> Event.ShowToast(R.string.app_name)
        }
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()

    }
    fun clearEvents() {
        _event.value = null
    }
}