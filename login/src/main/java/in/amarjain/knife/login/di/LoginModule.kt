package `in`.amarjain.knife.login.di

import `in`.amarjain.knife.login.model.LoginApi
import `in`.amarjain.knife.login.model.LoginRepository
import `in`.amarjain.knife.login.model.LoginRepositoryImpl
import `in`.amarjain.knife.login.viewmodel.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Retrofit

@InstallIn(ActivityComponent::class)
@Module
class LoginModule {
    @InstallIn(ActivityComponent::class)
    @Module
    class HomeModule {
        @Provides
        @ActivityScoped
        fun api(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)

        @Provides
        @ActivityScoped
        fun repository(api: LoginApi): LoginRepository = LoginRepositoryImpl(api)

        @Provides
        @ActivityScoped
        fun viewModel(repository: LoginRepository): LoginViewModel = LoginViewModel(repository)
    }
}