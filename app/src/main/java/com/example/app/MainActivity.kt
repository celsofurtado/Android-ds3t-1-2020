package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.app.fragments.ConsolesFragment
import com.example.app.fragments.GamesFragment
import com.example.app.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var gamesFragment: GamesFragment
    private lateinit var consolesFragment: ConsolesFragment
    private lateinit var homeFragment: HomeFragment
    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_drawer_layout)

        gamesFragment = GamesFragment()
        consolesFragment = ConsolesFragment()
        homeFragment = HomeFragment()

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)

        setFragment(homeFragment)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_games -> {
                setFragment(gamesFragment)
            }
            R.id.menu_consoles -> {
                setFragment(consolesFragment)
            }
            R.id.menu_home -> {
                setFragment(homeFragment)
            }
        }

        return true
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }
}