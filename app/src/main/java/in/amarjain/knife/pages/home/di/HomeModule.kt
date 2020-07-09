package `in`.amarjain.knife.pages.home.di

import `in`.amarjain.knife.pages.home.model.HomeApi
import `in`.amarjain.knife.pages.home.model.HomeRepository
import `in`.amarjain.knife.pages.home.model.HomeRepositoryImpl
import `in`.amarjain.knife.pages.home.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Retrofit

@InstallIn(ActivityComponent::class)
@Module
class HomeModule {
    @Provides
    @ActivityScoped
    fun api(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)

    @Provides
    @ActivityScoped
    fun repository(api: HomeApi): HomeRepository = HomeRepositoryImpl(api)

    @Provides
    @ActivityScoped
    fun viewModel(repository: HomeRepository): HomeViewModel = HomeViewModel(repository)
}