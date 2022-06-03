package kg.itc.funTime.ui.funTime.company

import android.util.Log
import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.itc.funTime.data.models.CompanyEntity
import kg.itc.funTime.domain.use_cases.GetCompanyAsLiveDataUseCase
import kg.itc.funTime.domain.use_cases.GetCompanyUseCase
import kg.itc.funTime.ui.base.BaseVM
import kg.itc.funTime.ui.base.Event
import javax.inject.Inject

@HiltViewModel
class CompanyVM @Inject constructor(
    private val getCompanyUseCase: GetCompanyUseCase,
    private val getCompanyAsLiveDataUseCase: GetCompanyAsLiveDataUseCase
) : BaseVM() {

        val companies : LiveData<List<CompanyEntity>> = getCompanyAsLiveDataUseCase()

        init {
            getCompany()
        }

        fun getCompany(){
            _event.value = Event.ShowLoading
            disposable.add(
                getCompanyUseCase()
                    .doOnTerminate {
                         _event.value = Event.StopLoading
                    }
                    .subscribe({
                               Log.d("cdc","sucsess")
                    },
                    {
                        handleError(it)
                        Log.d("cdc","cdcn")
                    })
            )
        }
}