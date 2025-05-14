package com.mammago.Content.Dashbord.Connection

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mammago.Content.Dashbord.HomeFragment
import com.mammago.R
import com.mammago.Content.Dashbord.SignUpFragment
import com.mammago.MainActivity

class ComfirmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_comfirm, container, false)

        // Delay transition for 5 seconds (5000 milliseconds)
        Handler(Looper.getMainLooper()).postDelayed({
            (activity as? MainActivity)?.showFragment(HomeFragment())
        }, 5000)

        return view
    }
}
