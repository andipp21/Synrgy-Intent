package com.example.synrgy_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.synrgy_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botNav = binding.botnav

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val bundelFragment = BundelFragment()
        val serializableFragment = SerializableFragment()
        val parcelableFragment = ParcelableFragment()
        val dialFragment = DialFragment()
        val whatsappFragment = WhatsappFragment()

        //default fragment
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flcon, bundelFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        botNav.setOnNavigationItemSelectedListener {
            return@setOnNavigationItemSelectedListener when (it.itemId) {
                R.id.navBundle -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.flcon, bundelFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                R.id.navSerializable -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.flcon, serializableFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                R.id.navParcelable -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.flcon, parcelableFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                R.id.navDial -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.flcon, dialFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                R.id.navWA -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.flcon, whatsappFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
}
