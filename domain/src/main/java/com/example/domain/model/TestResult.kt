package com.example.domain.model

data class TestResult(
    val testId: String, // Идентификатор теста
    val testName: String, // Название теста
    val correctAnswersCount: Int // Количество правильных ответов
)
