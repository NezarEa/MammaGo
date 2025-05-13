package com.mammago.Content.Dashbord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mammago.Content.Dashbord.Connection.AccountFragment
import com.mammago.Content.Dashbord.Connection.BabyFragment
import com.mammago.Content.Dashbord.Connection.ComfirmFragment
import com.mammago.Content.Dashbord.Connection.PersonalFragment
import com.mammago.R


class SignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.host_connection, AccountFragment())
                .commit()
        }

        return view
    }

    fun goToNextStep(step: Int) {
        val fragment = when (step) {
            1 -> PersonalFragment()
            2 -> BabyFragment()
            3 -> ComfirmFragment()
            else -> AccountFragment()
        }

        childFragmentManager.beginTransaction()
            .replace(R.id.host_connection, fragment)
            .addToBackStack(null)
            .commit()
    }

}