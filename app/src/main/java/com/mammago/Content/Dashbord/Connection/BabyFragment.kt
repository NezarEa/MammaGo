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

class BabyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_baby, container, false)

        // Set up baby gender spinner
        val genderSpinner = view.findViewById<Spinner>(R.id.spinner_baby_gender)
        val genderOptions = listOf("Select Gender", "Male", "Female", "Other")
        genderSpinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, genderOptions).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Set up medication spinner
        val medicationSpinner = view.findViewById<Spinner>(R.id.spinner_medication)
        val medicationOptions = listOf("None", "Prenatal Vitamins", "Iron Supplement", "Other")
        medicationSpinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, medicationOptions).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Set up health diagnosis spinner
        val diagnosisSpinner = view.findViewById<Spinner>(R.id.spinner_diagnosis)
        val diagnosisOptions = listOf("Healthy", "Premature", "Underweight", "Other")
        diagnosisSpinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, diagnosisOptions).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Next button handling
        view.findViewById<Button>(R.id.Next).setOnClickListener {
            (parentFragment as? SignUpFragment)?.goToNextStep(3)
        }

        return view
    }
}
