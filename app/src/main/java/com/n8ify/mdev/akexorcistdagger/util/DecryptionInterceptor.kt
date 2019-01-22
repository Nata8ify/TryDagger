package com.n8ify.mdev.akexorcistdagger.util

import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Response
import okhttp3.ResponseBody
import java.nio.charset.Charset
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class DecryptionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response : Response = chain.proceed(chain.request())
        var contentType = response.header("Content-Type")
        if(contentType.isNullOrBlank()){
            contentType = "application/json"
        }

        val initVector = IvParameterSpec("wantamariearrrrr".toByteArray(Charset.forName("UTF-8")))
        val secretKeySpec = SecretKeySpec("wantamariearrrrr".toByteArray(Charset.forName("UTF-8")), "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, initVector)

//        val finalContent = android.util.Base64.encode(cipher.doFinal(response.body()!!.bytes()), android.util.Base64.DEFAULT)
//        val reallyFinalContent = cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, initVector)
        return response/*.newBuilder().body(ResponseBody.create(MediaType.parse(contentType), String(reallyFinalContent))).build()*/
    }
}