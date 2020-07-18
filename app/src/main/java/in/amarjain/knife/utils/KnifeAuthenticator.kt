package `in`.amarjain.knife.utils

import okhttp3.*
import javax.net.ssl.HttpsURLConnection

class KnifeAuthenticator(private val authController: AuthController) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        authController.goToLogin()
        return null
    }
}