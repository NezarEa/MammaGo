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
import android.widget.TextView

class SignUpFragment : Fragment() {

    private lateinit var step1: TextView
    private lateinit var step2: TextView
    private lateinit var step3: TextView
    private lateinit var step4: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        step1 = view.findViewById(R.id.step1)
        step2 = view.findViewById(R.id.step2)
        step3 = view.findViewById(R.id.step3)
        step4 = view.findViewById(R.id.step4)

        // Initialize fragment with the first step
        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.host_connection, AccountFragment())
                .commit()
            updateStepColors(1) // Step 1 is active initially
        }

        return view
    }

    // Function to transition to the next step with custom action
    fun goToNextStep(step: Int, transactionAction: (() -> Unit)? = null) {
        val fragment = when (step) {
            1 -> PersonalFragment()  // For step 1, show the PersonalFragment
            2 -> BabyFragment()      // For step 2, show the BabyFragment
            3 -> ComfirmFragment()  // For step 3, show the ComfirmFragment
            else -> AccountFragment()  // If it's the first step, keep it on AccountFragment
        }

        // Fragment transaction to replace the current fragment
        childFragmentManager.beginTransaction()
            .replace(R.id.host_connection, fragment)
            .addToBackStack(null)
            .commit()

        // Perform any action after the transition
        transactionAction?.invoke()

        // Update the step indicators after the fragment transition
        updateStepColors(step)
    }

    // Function to update the colors of the steps
    private fun updateStepColors(currentStep: Int) {
        // Reset all steps to inactive
        step1.setBackgroundResource(R.drawable.circle_inactive)
        step2.setBackgroundResource(R.drawable.circle_inactive)
        step3.setBackgroundResource(R.drawable.circle_inactive)
        step4.setBackgroundResource(R.drawable.circle_inactive)

        step1.setTextColor(resources.getColor(R.color.inactive_text))
        step2.setTextColor(resources.getColor(R.color.inactive_text))
        step3.setTextColor(resources.getColor(R.color.inactive_text))
        step4.setTextColor(resources.getColor(R.color.inactive_text))

        // Activate the current step
        when (currentStep) {
            1 -> {
                step1.setBackgroundResource(R.drawable.circle_active)
                step1.setTextColor(resources.getColor(R.color.white))
            }
            2 -> {
                step2.setBackgroundResource(R.drawable.circle_active)
                step2.setTextColor(resources.getColor(R.color.white))
            }
            3 -> {
                step3.setBackgroundResource(R.drawable.circle_active)
                step3.setTextColor(resources.getColor(R.color.white))
            }
            4 -> {
                step4.setBackgroundResource(R.drawable.circle_active)
                step4.setTextColor(resources.getColor(R.color.white))
            }
        }
    }
}
