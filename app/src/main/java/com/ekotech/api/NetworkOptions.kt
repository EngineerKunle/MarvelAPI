package com.ekotech.api

data class NetworkOptions(
    private var apiKey: String,
    private var hash: String,
    private var timeStamp: Int,
    private var offSet: Int
)