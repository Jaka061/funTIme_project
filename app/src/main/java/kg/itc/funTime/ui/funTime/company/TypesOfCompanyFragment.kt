package kg.itc.funTime.ui.funTime.company

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kg.itc.funTime.R
import kg.itc.funTime.databinding.FragmentCompaniesBinding
import kg.itc.funTime.ui.OnClick
import kg.itc.funTime.ui.base.BaseFragment
import kg.itc.funTime.ui.main.rv.TypesAdapter

@AndroidEntryPoint
class TypesOfCompanyFragment: BaseFragment<TypesOfCompanyVM,FragmentCompaniesBinding>
    (TypesOfCompanyVM::class.java) , TypesAdapter.Listener {

    private lateinit var listener : OnClick
    private var _binding: FragmentCompaniesBinding? = null
    private val binding get() = _binding!!
    private val typesAdapter: TypesAdapter = TypesAdapter(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as OnClick
        } catch (e: Exception){ print("Activity must implement FragmentListener")}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentCompaniesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCompaniesBinding.bind(view)

        val view = requireActivity().findViewById<BottomNavigationView>(R.id.btnNav)
        view.visibility = View.VISIBLE

        setupViews()
        subscribeToLiveData()
    }

    private fun setupViews(){
        with(binding){
            recyclerCompany.adapter = typesAdapter
            val layoutManager = LinearLayoutManager(activity)
            recyclerCompany.layoutManager = layoutManager
            recyclerCompany.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))

            //viewModel.getTypes()

        }
    }

    private fun subscribeToLiveData(){
        viewModel.types.observe(viewLifecycleOwner) {
            typesAdapter.setData(it)
        }

//        viewModel.event.observe(viewLifecycleOwner) {
//            when (it) {
////                is Event.ShowToast -> showToast(getString(it.resId))
//                is Event.ShowLoading -> binding.swiperefresh.isRefreshing = true
//                is Event.HideLoading -> binding.swiperefresh.isRefreshing = false
//                else -> {}
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.clearEvents()
    }


    override fun onClick(index: String) {
//        viewModel.getPostByIndex(index)?.let {
//            listener.openFragment(CommentListFragment.newInstance(it))
//        }
    }


}
