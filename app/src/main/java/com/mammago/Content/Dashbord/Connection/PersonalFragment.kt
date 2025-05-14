package com.mammago.Content.Dashbord.Connection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.mammago.R
import com.mammago.Content.Dashbord.SignUpFragment

class PersonalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal, container, false)

        val genderSpinner = view.findViewById<Spinner>(R.id.password_spinner)
        val options = listOf("Select Gender", "Female", "Male", "Other")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter

        // Handle next button click
        view.findViewById<Button>(R.id.Next).setOnClickListener {
            (parentFragment as? SignUpFragment)?.goToNextStep(2)
        }

        return view
    }
}
