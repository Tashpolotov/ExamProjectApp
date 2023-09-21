package com.example.domain.repository

import com.example.domain.model.HomeModel1
import com.example.domain.model.HomeModel2
import com.example.domain.model.QuestionsModel

interface  TestQuizRepository {

    fun getHome1():List<HomeModel1>

    fun getHome2():List<HomeModel2>

    fun getExam():List<HomeModel2>

    fun getQuestions(): List<QuestionsModel>

    fun searchHome1(query:String):List<HomeModel1>


}