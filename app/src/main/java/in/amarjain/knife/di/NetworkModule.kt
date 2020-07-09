package `in`.amarjain.knife.di

import `in`.amarjain.knife.utils.HeaderInterceptor
import `in`.amarjain.knife.utils.UrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {

    @Provides
    fun headerInterceptor(): HeaderInterceptor = HeaderInterceptor()

    @Provides
    fun okHttpClient(headerInterceptor: HeaderInterceptor): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(headerInterceptor)
        .build()

    @Provides
    fun retrofit(
        urlProvider: UrlProvider,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit
        .Builder()
        .baseUrl(urlProvider.base())
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}