package com.example.domain.model

data class QuestionsModel(
    val id:String,
    val nameTest:String,
    val questions:String,
    val answer:List<String>,
    val currentAnswer:String
)
