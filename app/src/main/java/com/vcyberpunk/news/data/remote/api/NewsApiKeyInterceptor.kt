package com.vcyberpunk.news.data.remote.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import com.vcyberpunk.news.BuildConfig

class NewsApiKeyInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val newUrl = originalRequest.url
            .newBuilder()
            .addQueryParameter(KEY_PARAM, BuildConfig.NEWS_API_KEY)
            .build()

        val newRequest = originalRequest
            .newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

    private companion object {
        const val KEY_PARAM = "apiKey"
    }
}