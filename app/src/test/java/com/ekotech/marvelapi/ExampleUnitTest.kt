package com.ekotech.marvelapi

import org.junit.Test

import org.junit.Assert.*
import java.io.UnsupportedEncodingException
import java.security.MessageDigest

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun check_expected_hasValue() {
        assertEquals(4, 2 + 2)
        val something = "aa1b32a0248108b895cebe343dfddbd6"
        val ts = "1"
        val privateKey = "d6b2403aa882aa2e8bfa294c429e83e20a0ebf64"
        val fullKey = ts + privateKey + something
        val matchExp = "858a0159841d0e36e4fc758cee5846d5"

        assertEquals(fullKey.md5(), matchExp)

    }

    private fun String.md5(): String? {
        try {
            val md = MessageDigest.getInstance("MD5")
            val array = md.digest(this.toByteArray())
            val sb = StringBuffer()
            for (i in array.indices) {
                sb.append(Integer.toHexString(array[i].toInt() and 0xFF or 0x100).substring(1, 3))
            }
            return sb.toString()
        } catch (e: java.security.NoSuchAlgorithmException) {
        } catch (ex: UnsupportedEncodingException) {
        }
        return null
    }
}
