package com.globant.mariorangel.data.network.interceptors

import com.globant.mariorangel.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HashInterceptor : Interceptor {

    companion object {
        private const val APIKEY = "apikey"
        private const val HASH = "hash"
        private const val TIMESTAMP = "ts"
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()

        val url = request.url().newBuilder()
                .addQueryParameter(APIKEY, BuildConfig.APIKEY)
                .addQueryParameter(TIMESTAMP, "1")
                .addQueryParameter(HASH, BuildConfig.HASH)
                .build()

        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}