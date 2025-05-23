package com.mammago

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.mammago.Content.Dashbord.SignUpFragment
import com.mammago.Content.OnBoardingFragment
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Handle edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPref = getSharedPreferences("app_prefs", MODE_PRIVATE)

        // Check user state and show the appropriate fragment
        checkUserState()
    }

    private fun checkUserState() {
        val fragment = when {
            !sharedPref.getBoolean("onboarding_complete", false) -> {
                OnBoardingFragment() // Show onboarding if not completed
            }
            else -> {
                SignUpFragment() // Show SignUp if onboarding is complete (no authentication needed)
            }
        }
        // Show fragment only if it's not already the current one
        if (fragment::class.java != supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.javaClass) {
            showFragment(fragment)
        }
    }

    // Function to show fragment in the activity
    fun showFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment) // Replace current fragment
        if (addToBackStack) {
            transaction.addToBackStack(null) // Add to back stack if needed
        }
        transaction.commit()
    }

    // Handle onboarding completion
    fun completeOnboarding() {
        sharedPref.edit { putBoolean("onboarding_complete", true) }
        showFragment(SignUpFragment(), addToBackStack = false)
    }
}
