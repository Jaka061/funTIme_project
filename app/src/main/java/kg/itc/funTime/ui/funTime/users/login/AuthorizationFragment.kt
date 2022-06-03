package kg.itc.funTime.ui.funTime.users.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import kg.itc.funTime.R
import kg.itc.funTime.databinding.FragmentAuthorizationBinding
import kg.itc.funTime.databinding.FragmentRegistrationBinding
import kg.itc.funTime.ui.OnClick
import kg.itc.funTime.ui.base.BaseFragment
import kg.itc.funTime.ui.funTime.company.TypesOfCompanyFragment

class AuthorizationFragment : BaseFragment<AuthorizationVM, FragmentAuthorizationBinding>(AuthorizationVM::class.java) {
    private lateinit var listener : OnClick
    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentAuthorizationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.btnNav)
        menu.visibility = View.GONE



        binding.apply {
            signIn.setOnClickListener {
                if(login.text.toString().isNotEmpty() && password.text.toString().isNotEmpty() ) {

                    listener.openFragment(TypesOfCompanyFragment(), false)
                    Log.e("Open Type", "open")
                }
                else{
                    Log.e("pppppppppp", "open")
                }
            }
            signUp1.setOnClickListener {
                listener.openFragment(RegistrationFragment(), false)
                Log.e("Open Regis", "open")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.clearEvents()
    }
}