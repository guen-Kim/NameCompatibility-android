package com.example.presentation.view

import androidx.activity.viewModels
import com.example.domain.model.FirebaseState
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivitySplashBinding
import com.example.presentation.view.viewMdel.SplashViewModel
import com.example.presentation.widget.extention.startActivityWithFinish
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    private val splashViewModel by viewModels<SplashViewModel>()
    private val appVersion = "1.0.0"
    override fun init() {
        splashViewModel.checkAppVersion().apply {
            when (state) {
                FirebaseState.FAILURE -> longShowToast("파이어베이스를 상태 확인해 주세요.")

                FirebaseState.SUCCESS -> {
                    if (result == appVersion) {
                        this@SplashActivity.startActivityWithFinish(this@SplashActivity, MainActivity::class.java)
                    }
                }
                else -> longShowToast("앱 버전이 다릅니다.")
            }
        }
    }
}