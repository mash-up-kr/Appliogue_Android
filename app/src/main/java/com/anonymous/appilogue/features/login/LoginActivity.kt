package com.anonymous.appilogue.features.login

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.anonymous.appilogue.R
import com.anonymous.appilogue.databinding.ActivityLoginBinding
import com.anonymous.appilogue.features.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController: NavController = Navigation.findNavController(this, R.id.nav_host)
    }

}