package com.ekotech.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class MDHashUtilsTest {
    @Test
    fun convertToMD5Successful() {
        val mockAPIKey = "MOCKEDAPIKEYS"
        val privateMockedPrivateKey = "privateK3y"
        val mockedTimestamp = "1"

        val mockedStringKeys = mockedTimestamp + privateMockedPrivateKey + mockAPIKey
        val expectedValue = "3558a751d9d4ca35682f3cdd857332bf"

        assertEquals(mockedStringKeys.convertToMD5(), expectedValue)
    }
}