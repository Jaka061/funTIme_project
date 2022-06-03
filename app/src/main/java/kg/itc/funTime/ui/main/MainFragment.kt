package kg.itc.funTime.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kg.itc.funTime.R
import kg.itc.funTime.databinding.FragmentMainBinding
import kg.itc.funTime.ui.OnClick
import kg.itc.funTime.ui.base.BaseFragment
import kg.itc.funTime.ui.funTime.company.TypesOfCompanyFragment

@AndroidEntryPoint
class MainFragment: BaseFragment<MainVM, FragmentMainBinding>
    (MainVM::class.java)
{
    private lateinit var companyListener : OnClick
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        companyListener = context as OnClick
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        Log.e("Main fragm","open")

        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.btnNav)
        menu.visibility = View.GONE

        binding.apply {
            btnNext.setOnClickListener {
                companyListener.openFragment(TypesOfCompanyFragment(),false)
                Log.e("Main Type","open")
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.clearEvents()
    }
}