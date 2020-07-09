package `in`.amarjain.knife.utils

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val url = original
            .url()
            .newBuilder()
            .addQueryParameter(Constant.IMAGE_SEARCH_KEY, Constant.IMAGE_SEARCH_VALUE)
            .build()
        val request = original
            .newBuilder()
            .url(url)
            .method(original.method(), original.body())
            .build()
        return chain.proceed(request)
    }
}