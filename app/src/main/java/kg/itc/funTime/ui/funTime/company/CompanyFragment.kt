package kg.itc.funTime.ui.funTime.company

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kg.itc.funTime.R
import kg.itc.funTime.databinding.FragmentCompaniesBinding
import kg.itc.funTime.ui.OnClick
import kg.itc.funTime.ui.base.BaseFragment
import kg.itc.funTime.ui.main.rv.CompanyAdapter

@AndroidEntryPoint
class CompanyFragment : BaseFragment<CompanyVM, FragmentCompaniesBinding>
    (CompanyVM::class.java),CompanyAdapter.Listener
{
    private lateinit var listener : OnClick
    private val companyAdapter : CompanyAdapter = CompanyAdapter(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()

        val view = requireActivity().findViewById<BottomNavigationView>(R.id.btnNav)
        view.visibility = View.VISIBLE
    }

    private fun subscribeToLiveData() {
        viewModel.companies.observe(viewLifecycleOwner) {
            companyAdapter.setData(it)
            Log.e("setData Fr","Ok - $it")
        }
    }

    override fun onClick(index: String) {
//        viewModel.companies.value?.get(index)?.let {
//            //listener.openFragment(CompanyFragment(),true)
//        }
    }

}