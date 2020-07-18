package `in`.amarjain.knife.utils

import `in`.amarjain.knife.login.view.LoginActivity
import android.app.Activity
import android.content.Context
import android.content.Intent

interface AuthController {
    fun goToLogin()
}

class AuthControllerImpl(private val context: Context) : AuthController {
    override fun goToLogin() {
        context.startActivity(Intent(context, LoginActivity::class.java).apply {
            if (context !is Activity) {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        })
    }
}