package com.miftahuraziz.bottomnavandfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar

//    companion object {
//        const val EXTRA_EMAIL = "extra_email"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val navbar: BottomNavigationView = findViewById(R.id.navbar)

        toolbar = supportActionBar!!
        navbar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

//        val tvName: TextView = findViewById(R.id.name_received)
//        val name = intent.getStringExtra(EXTRA_EMAIL)
//        val text = "$name"
//        tvName.text = text
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                toolbar.title = "Home"
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                toolbar.title = "Profile"
                val profileFragment = ProfileFragment.newInstance()
                openFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}