package com.example.examprojectapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examprojectapp.R
import com.example.examprojectapp.databinding.FragmentQuestionListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionListFragment : Fragment() {

    private lateinit var binding:FragmentQuestionListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuestionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = requireContext().getSharedPreferences("save_result", Context.MODE_PRIVATE)


        val correctAnswersCount = arguments?.getInt("correctAnswersCount", 0) ?: 0
        val totalQuestions = arguments?.getInt("totalQuestions", 0) ?: 0

        val resultText = "$correctAnswersCount/$totalQuestions"
        binding.tvResult.text = resultText

        val editor = sharedPref.edit()
        editor.putInt("correctAnswersCount", correctAnswersCount)
        editor.putInt("totalQuestions", totalQuestions)
        editor.apply()

        binding.btnMenu.setOnClickListener {
            requireActivity().finishAffinity()
        }

        binding.btnRestart.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fr_container, HomeFragment())
                .addToBackStack(null)
                .commit()

        }

    }

}