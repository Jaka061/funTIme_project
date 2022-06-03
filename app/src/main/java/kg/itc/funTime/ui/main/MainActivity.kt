package kg.itc.funTime.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kg.itc.funTime.R
import kg.itc.funTime.databinding.ActivityMainBinding
import kg.itc.funTime.ui.OnClick
import kg.itc.funTime.ui.funTime.company.CompanyFragment
import kg.itc.funTime.ui.funTime.company.SearchingFragment
import kg.itc.funTime.ui.funTime.company.TypesOfCompanyFragment
import kg.itc.funTime.ui.funTime.users.UserInfoFragment

@AndroidEntryPoint
class MainActivity: AppCompatActivity(),OnClick {
    private lateinit var binding: ActivityMainBinding
    lateinit var clickView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            Log.e("main","ok")
            openFragment(MainFragment(), false)
        }

        binding.run {
            supportActionBar?.hide()
            clickView = binding.btnNav

            clickView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.search -> {
                        openFragment(SearchingFragment(), false)
                    }
                    R.id.home -> {
                        Log.e("home","ok")
                        openFragment(TypesOfCompanyFragment(), false)
                    }
                    R.id.profile -> {
                        openFragment(UserInfoFragment(), false)
                    }
                }
                true
            }
        }
    }

    override fun openFragment(fragment: Fragment, addToBackStack: Boolean?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .apply {
                if(addToBackStack == true) {
                    addToBackStack("")
                }
            }
            .commit()
    }
}
