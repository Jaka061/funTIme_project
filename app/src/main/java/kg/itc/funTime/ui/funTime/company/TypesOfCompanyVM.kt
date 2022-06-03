package kg.itc.funTime.ui.funTime.company

import android.util.Log
import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.itc.funTime.data.models.TypesEntity
import kg.itc.funTime.domain.use_cases.GetTypesAsLiveDataUseCase
import kg.itc.funTime.domain.use_cases.GetTypesUseCase
import kg.itc.funTime.ui.base.BaseVM
import kg.itc.funTime.ui.base.Event
import javax.inject.Inject

@HiltViewModel
class TypesOfCompanyVM @Inject constructor(
    private val getTypesAsLiveDataUseCase : GetTypesAsLiveDataUseCase,
    private val getTypesUseCase: GetTypesUseCase,
): BaseVM() {

    val types: LiveData<List<TypesEntity>> = getTypesAsLiveDataUseCase()

    init {
        getTypes()
    }

    fun getTypes() {
        _event.value = Event.ShowLoading
        disposable.add(
            getTypesUseCase()
                .doOnTerminate {
                    _event.value = Event.StopLoading
                }
                .subscribe({
                    Log.d("type","sucsess")
                },{
                    handleError(it)
                })
        )
    }

    fun getPostByIndex(index: String): String? {
        return types.value?.getOrElse(index)
    }

}

private fun Any?.getOrElse(index: String): String {
    return index
}



