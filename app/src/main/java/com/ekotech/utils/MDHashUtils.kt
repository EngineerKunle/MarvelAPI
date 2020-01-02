package com.ekotech.utils

import java.io.UnsupportedEncodingException
import java.security.MessageDigest

fun String.convertToMD5(): String? {
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