package kg.itc.funTime.ui.funTime.company

import android.content.Context
import dagger.hilt.android.AndroidEntryPoint
import kg.itc.funTime.databinding.FragmentEntertainmentBinding
import kg.itc.funTime.ui.OnClick
import kg.itc.funTime.ui.base.BaseFragment
import kg.itc.funTime.ui.main.rv.TypesAdapter

@AndroidEntryPoint
class EntertainmentsFragment: BaseFragment<CompanyVM, FragmentEntertainmentBinding>
    (CompanyVM::class.java) , TypesAdapter.Listener
{
    private lateinit var listener : OnClick
    private val typesAdapter : TypesAdapter = TypesAdapter(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.btnNav)
//        menu.visibility = View.VISIBLE
//
//        viewModel.getCompany()
//        setupView()
//        subscribeToLiveData()
//
//    }
//
//    private fun setupView(){
//        with(binding){
//            Log.e("view","Ok ")
//            //listener.openFragment(CompanyFragment(),true)
//            recyclerEntertainment.adapter = typesAdapter
//            recyclerEntertainment.layoutManager = LinearLayoutManager(activity)
//            viewModel.getCompany()
//        }
//    }
//    private fun subscribeToLiveData() {
//        viewModel.companies.observe(viewLifecycleOwner) {
//            typesAdapter.setData(it)
//            Log.e("setData Fr","Ok - $it")
//        }
//
//    }
//
    override fun onClick(index: String) {
//        viewModel.companies.value?.get(index)?.let {
//            listener.openFragment(TypesFragment(),true)
//        }
    }
}