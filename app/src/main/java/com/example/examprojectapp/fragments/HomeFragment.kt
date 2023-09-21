package com.example.examprojectapp.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.widget.NestedScrollView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.HomeModel1
import com.example.examprojectapp.R
import com.example.examprojectapp.databinding.FragmentHomeBinding
import com.example.examprojectapp.fragments.adapter.Home1Adapter
import com.example.examprojectapp.fragments.adapter.Home2Adapter
import com.example.examprojectapp.viewmodel.TestQuizViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    private val viewModel by viewModels<TestQuizViewModel>()
    private val adapter1 = Home1Adapter(this::onClick)
    private val adapter2 = Home2Adapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initSearch()

        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        binding.nesc.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                bottomNavigationView.visibility = View.GONE
            } else if (scrollY < oldScrollY) {

                bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }

    private fun initSearch() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Ничего не делаем перед изменением текста
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Ничего не делаем при изменении текста
            }

            override fun afterTextChanged(s: Editable?) {
                // Проверяем, является ли текст пустым
                if (s.isNullOrEmpty()) {
                    // Текстовое поле пустое, восстанавливаем все заметки
                    viewModel.loadHome1()
                    viewModel.loadHome2()
                    Log.d("MyApp", "Поиск: Пустой запрос, загрузка всех элементов")
                } else {
                    // Текст введен, выполняем поиск
                    viewModel.searchHome1(query = s.toString())
                    Log.d("MyApp", "Поиск: Запрос - ${s.toString()}")
                }
            }
        })
    }



    private fun initAdapter() {
        binding.rv1.adapter = adapter1
        binding.rv2.adapter = adapter2
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.testQuiz.collect{
                adapter1.submitList(it.home1)
                adapter2.submitList(it.home2)
            }
        }
        viewModel.loadHome1()
        viewModel.loadHome2()
    }

    private fun onClick(model:HomeModel1) {
        val bundle = Bundle()
        val fragment = QuestionFragment()

        bundle.putString("id", model.id)
        bundle.putString("name", model.title)
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}