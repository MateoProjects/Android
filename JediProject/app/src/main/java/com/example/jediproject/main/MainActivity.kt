package com.example.firstaplication

import EstadistiquesFragment
import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import com.example.jediproject.dialogs.LogoutDialog
import com.example.jediproject.R
import com.example.jediproject.classes.Friend
import com.example.jediproject.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        val name = sharedPref!!.getString("NAME" , "")

        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout,
            R.string.open,
            R.string.close
        )

        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navigation_view.setCheckedItem(R.id.mainFragment)

        if(name.toString().isNotEmpty()) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            mainActivity()
        }
        else {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            register()
        }
        navigation_view.setNavigationItemSelectedListener {menuItem ->
            drawerLayout.closeDrawer(GravityCompat.START)

            when(menuItem.itemId) {

                R.id.mainFragment -> {
                    mainActivity()
                    true
                }

                R.id.secondFragment -> {
                    cardGame()
                    true

                }
                R.id.thirdFragment -> {
                    estadistiques()
                    true
                }

                R.id.fourfragment -> {
                    estadistiquesGlobals()
                    true
                }

                R.id.maps -> {
                    maps()
                    true
                }

                R.id.logout -> {
                    logout()
                    true
                }

                R.id.social-> {
                    friends()
                    true
                }
                else -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

            }
        }
    }

    fun cardGame() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, CartaViewFragment()).commit()

    }

    fun estadistiques() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, EstadistiquesFragment()).commit()

    }
    fun mainActivity() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity,
            MainFragment()
        ).commit()
    }

    fun estadistiquesGlobals() {
       supportFragmentManager.beginTransaction().replace(R.id.MainActivity, EstGlobalsFragment()).commit()

    }

    fun maps() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, MapsFragment()).commit()

    }

    fun register() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity,
            RegisterFragment()
        ).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {

                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun logout () {
        LogoutDialog().newInstance(this , this).show()
    }

    fun friends() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, FriendsFragment()).commit()
    }

    fun addFriends() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, AddFriendFragment()).commit()

    }

    fun deleteFriends() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, DeleteFriendFragment()).commit()

    }

    fun viewFriend(friend: Friend) {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, FriendFragment(friend)).commit()

    }
}