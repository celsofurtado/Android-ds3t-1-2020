package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.app.data.AppDataBase
import com.example.app.fragments.ConsolesFragment
import com.example.app.fragments.GamesFragment
import com.example.app.fragments.HomeFragment
import com.example.app.model.Console
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import org.jetbrains.anko.doAsync
import java.time.LocalDate

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var gamesFragment: GamesFragment
    private lateinit var consolesFragment: ConsolesFragment
    private lateinit var homeFragment: HomeFragment
    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_drawer_layout)

//        doAsync {
//            AppDataBase.get(application)
//                .consoleDao()
//                .insertConsole(arrayListOf(
//                    Console(300, "X-Box 360", "Microsoft", "2013-11-05"),
//                    Console(400, "Mega Drive", "Sega", "2017-03-03"))
//                )
//        }

        gamesFragment = GamesFragment()
        consolesFragment = ConsolesFragment()
        homeFragment = HomeFragment()

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.title = "Home"

        var toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        setFragment(homeFragment)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_games -> {
                toolbar.title = "Meus Jogos"
                setFragment(gamesFragment)
            }
            R.id.menu_consoles -> {
                toolbar.title = "Meus Consoles"
                setFragment(consolesFragment)
            }
            R.id.menu_home -> {
                toolbar.title = "Home"
                setFragment(homeFragment)
            }
        }

        // Definir qual menuItem será selecionado quando usar o navigationView(DrawerLayout)
        var menuItem = bottomNavigationView.menu.findItem(item.itemId)
        menuItem.setChecked(true)

        return true
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }

}