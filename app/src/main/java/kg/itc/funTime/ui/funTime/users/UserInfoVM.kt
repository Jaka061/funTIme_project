package kg.itc.funTime.ui.funTime.users

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.itc.funTime.domain.use_cases.GetCompanyUseCase
import kg.itc.funTime.ui.base.BaseVM
import javax.inject.Inject

@HiltViewModel
class UserInfoVM @Inject constructor(private val getCompanyUseCase: GetCompanyUseCase):BaseVM(){
}