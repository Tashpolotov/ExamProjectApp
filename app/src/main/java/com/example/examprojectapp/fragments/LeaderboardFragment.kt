package com.example.examprojectapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.domain.model.TestResult
import com.example.examprojectapp.R
import com.example.examprojectapp.databinding.FragmentLeaderboardBinding
import com.example.examprojectapp.fragments.adapter.CompletedTestsAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeaderboardFragment : Fragment() {
    private lateinit var binding: FragmentLeaderboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        binding.nesc.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                bottomNavigationView.visibility = View.GONE
            } else if (scrollY < oldScrollY) {

                bottomNavigationView.visibility = View.VISIBLE
            }
        }

        // Получите SharedPreferences
        val sharedPreferences = requireContext().getSharedPreferences("test_results", Context.MODE_PRIVATE)

        // Получите список ключей для результатов тестов
        val testResultKeys = sharedPreferences.all.keys.filter { it.startsWith("test_id_") }

        // Создайте список с результатами тестов
        val testResults = mutableListOf<TestResult>()

        for (testKey in testResultKeys) {
            val testId = sharedPreferences.getString("$testKey", null)
            val testName = sharedPreferences.getString("test_name_$testId", null)
            val correctAnswersCount = sharedPreferences.getInt("correct_answers_count_$testId", 0)

            if (testId != null && testName != null && correctAnswersCount > 0) {
                // Если есть сохраненные результаты и название теста, добавьте их в список
                val testResult = TestResult(testId, testName, correctAnswersCount)
                testResults.add(testResult)
            }
        }
        val uniqueTestResults = testResults.distinctBy { it.testName }
        // Найдите RecyclerView в макете и настройте адаптер
        val recyclerView = binding.rv
        val adapter = CompletedTestsAdapter()
        recyclerView.adapter = adapter

        // Передайте данные в адаптер
        adapter.submitList(uniqueTestResults)
    }

}