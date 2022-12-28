package com.example.coroutineexamples

import com.example.myapplication.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object Retrofithelper {
//    val baseUrl ="https://newsapi.org/"
    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}