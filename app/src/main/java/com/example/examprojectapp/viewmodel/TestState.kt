package com.example.examprojectapp.viewmodel

import com.example.domain.model.HomeModel1
import com.example.domain.model.HomeModel2
import com.example.domain.model.QuestionsModel

data class TestState(
    val home1 : List<HomeModel1> = emptyList(),
    val home2 : List<HomeModel2> = emptyList(),
    val exam : List<HomeModel2> = emptyList(),
    val questions : List<QuestionsModel> = emptyList(),
)