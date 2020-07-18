package `in`.amarjain.knife.login.model

interface LoginRepository {
    suspend fun login(email: String, password: String): LoginResponse
}

class LoginRepositoryImpl(private val api: LoginApi) : LoginRepository {
    override suspend fun login(email: String, password: String): LoginResponse {
        return api.login(LoginRequest(email, password))
    }
}