package kg.itc.funTime.ui.funTime.users.login

import dagger.hilt.android.AndroidEntryPoint
import kg.itc.funTime.databinding.FragmentRegistrationBinding
import kg.itc.funTime.ui.base.BaseFragment

@AndroidEntryPoint
class RegistrationFragment :BaseFragment<RegistrationVM,FragmentRegistrationBinding>(RegistrationVM::class.java)  {
}