package com.ekotech.api

data class NetworkOptions(
    val apiKey: String,
    val hash: String,
    val timeStamp: Long,
    val offSet: Int
)