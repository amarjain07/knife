package `in`.amarjain.knife.di

import `in`.amarjain.knife.utils.*
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {

    @Provides
    fun headerInterceptor(): HeaderInterceptor = HeaderInterceptor()

    @Provides
    fun authController(@ApplicationContext context: Context): AuthController =
        AuthControllerImpl(context)

    @Provides
    fun authInterceptor(authController: AuthController): KnifeAuthenticator =
        KnifeAuthenticator(authController)

    @Provides
    fun okHttpClient(
        headerInterceptor: HeaderInterceptor,
        knifeAuthenticator: KnifeAuthenticator
    ): OkHttpClient = OkHttpClient
        .Builder()
        .authenticator(knifeAuthenticator)
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