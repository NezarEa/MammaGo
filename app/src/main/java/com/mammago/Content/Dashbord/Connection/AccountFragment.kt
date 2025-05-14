package com.mammago.Content.Dashbord.Connection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mammago.Content.Dashbord.SignUpFragment
import com.mammago.R

class AccountFragment : Fragment() {

    private lateinit var nextButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        // Find the Next button
        nextButton = view.findViewById(R.id.Next)

        // Set a click listener for the Next button
        nextButton.setOnClickListener {
            // Find the parent SignUpFragment and call the goToNextStep method
            (parentFragment as? SignUpFragment)?.goToNextStep(1)
        }

        return view
    }
}
