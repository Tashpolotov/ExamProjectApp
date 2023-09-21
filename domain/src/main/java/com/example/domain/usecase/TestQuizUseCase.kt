package com.example.domain.usecase

import com.example.domain.repository.TestQuizRepository

class TestQuizUseCase(private val repository: TestQuizRepository) {

    operator fun invoke(){
        repository.getHome1()
        repository.getHome2()
        repository.getExam()
        repository.getQuestions()
        repository.searchHome1(query = String())

    }
}