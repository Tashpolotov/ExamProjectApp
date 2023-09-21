package com.example.examprojectapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.HomeModel2
import com.example.examprojectapp.R
import com.example.examprojectapp.databinding.FragmentExamBinding
import com.example.examprojectapp.fragments.adapter.ExamAdapter
import com.example.examprojectapp.viewmodel.TestQuizViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExamFragment : Fragment() {

    private lateinit var binding: FragmentExamBinding
    private val viewModel by viewModels<TestQuizViewModel>()
    private val adapter = ExamAdapter(this::onClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentExamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        binding.nesc.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                bottomNavigationView.visibility = View.GONE
            } else if (scrollY < oldScrollY) {

                bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }

    private fun initAdapter() {
        binding.rv.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.testQuiz.collect {
                adapter.submitList(it.exam)
            }
        }
        viewModel.loadExam()
    }

    private fun onClick(model:HomeModel2) {
        val fragment = QuestionFragment()
        val bundle = Bundle()
        bundle.putString("name", model.title)
        bundle.putString("idExam", model.id)
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
