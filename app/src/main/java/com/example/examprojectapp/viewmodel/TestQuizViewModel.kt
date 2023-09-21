package com.example.examprojectapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.TestQuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestQuizViewModel @Inject constructor(private val repository: TestQuizRepository) :ViewModel() {


    private val _testQuiz = MutableStateFlow(TestState())
    val testQuiz : StateFlow<TestState> = _testQuiz.asStateFlow()


    fun loadQuestions(){
        val questions = repository.getQuestions()
        _testQuiz.value = _testQuiz.value.copy(questions = questions)
    }

    fun loadHome1(){
        val home = repository.getHome1()
        _testQuiz.value = _testQuiz.value.copy(home1 = home)
    }

    fun loadHome2(){
        val home = repository.getHome2()
        _testQuiz.value = _testQuiz.value.copy(home2 = home)
    }

    fun loadExam(){
        val exam = repository.getExam()
        _testQuiz.value = _testQuiz.value.copy(exam =  exam)
    }

    fun searchHome1(query: String){
        viewModelScope.launch {
            try {
                val searchHome1 = repository.searchHome1(query)
                _testQuiz.value = TestState(home1 = searchHome1)
            } catch (e:Exception){

            }

        }
    }
}