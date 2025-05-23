package com.mammago.Content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mammago.MainActivity
import com.mammago.R
import com.mammago.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startButton.setOnClickListener {
            navigateToConnection()
        }
    }

    private fun navigateToConnection() {
        // Use only the activity method for navigation
        (activity as? MainActivity)?.completeOnboarding()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}