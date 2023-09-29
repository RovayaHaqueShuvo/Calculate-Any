package org.freedu.allcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import org.freedu.allcalculation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        var navController = findNavController(R.id.fragmentContainerView)
        binding.bottombar.setupWithNavController(navController)


        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout, R.string.nav_open, R.string.nav_close)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.drawerNav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_Fragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }

                R.id.scientificFragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.tempFragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.white ->{
                    binding.drawerLayout.setBackgroundColor(getResources().getColor(R.color.white))
                    binding.bottombar.setBackgroundColor(getResources().getColor(R.color.white))
                    binding.drawerLayout.closeDrawers()
                }
                R.id.black ->{
                    binding.drawerLayout.setBackgroundColor(getResources().getColor(R.color.black))
                    binding.bottombar.setBackgroundColor(getResources().getColor(R.color.black))
                    binding.drawerLayout.closeDrawers()
                }
                R.id.red ->{
                    binding.drawerLayout.setBackgroundColor(getResources().getColor(R.color.red))
                    binding.bottombar.setBackgroundColor(getResources().getColor(R.color.red))
                    binding.drawerLayout.closeDrawers()
                }
                R.id.setting ->{
                    binding.drawerLayout.closeDrawers()
                }
                R.id.logout ->{
                    binding.drawerLayout.closeDrawers()
                }
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            true
        }else super.onOptionsItemSelected(item)
    }

}