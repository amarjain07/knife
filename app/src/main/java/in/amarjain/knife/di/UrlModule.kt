package `in`.amarjain.knife.di

import `in`.amarjain.knife.utils.KnifeUrlProvider
import `in`.amarjain.knife.utils.UrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class UrlModule {
    @Provides
    fun urlProvider(): UrlProvider = KnifeUrlProvider()
}