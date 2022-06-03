package kg.itc.funTime.ui.funTime.company

import kg.itc.funTime.databinding.FragmentCompaniesBinding
import kg.itc.funTime.ui.OnClick
import kg.itc.funTime.ui.base.BaseFragment
import kg.itc.funTime.ui.main.rv.CompanyAdapter

class TypesFragment : BaseFragment<TypesOfCompanyVM,FragmentCompaniesBinding>(
    TypesOfCompanyVM::class.java,),CompanyAdapter.Listener
{
    private lateinit var listener : OnClick
    private val companyAdapter: CompanyAdapter = CompanyAdapter(this)

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupView()
//        subscribeToLiveData()
//
//        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.btnNav)
//        menu.visibility = View.VISIBLE
//    }
//
//    private fun setupView(){
//        with(binding){
//            Log.e("recycle company","Ok")
//            recyclerCompany.adapter = companyAdapter
//            recyclerCompany.layoutManager = LinearLayoutManager(activity)
//        }
//    }
//
//    private fun subscribeToLiveData() {
//        viewModel.companies.observe(viewLifecycleOwner) {
//           companyAdapter.setData(it)
//            Log.e("setData Comp Fr","Ok - $it")
//        }
//
//    }
//
    override fun onClick(index: String) {
//        viewModel.companies.value?.get(index)?.let {
//            listener.openFragment(CompanyFragment(),true)
//        }
    }

}
