package com.example.firstaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navigation_view.setCheckedItem(R.id.mainFragment)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_view.setNavigationItemSelectedListener {menuItem ->
            drawerLayout.closeDrawer(GravityCompat.START)

            when(menuItem.itemId) {

                R.id.mainFragment -> {
                    mainActivity()
                    true
                }
                R.id.firstFragment -> {
                    calculadora()
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
                else -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

            }
        }
        mainActivity()
    }

    fun cardGame() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, CartaViewFragment()).commit()

    }

    fun estadistiques() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, EstadistiquesFragment()).commit()

    }

    fun calculadora () {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, CalculadoraFragment()).commit()
    }

    fun mainActivity() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, MainFragment()).commit()
    }

    fun estadistiquesGlobals() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, GlobalEstadistics()).commit()

    }

    fun maps() {
        supportFragmentManager.beginTransaction().replace(R.id.MainActivity, Maps()).commit()

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
}