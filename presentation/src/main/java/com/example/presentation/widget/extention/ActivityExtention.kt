package com.example.presentation.widget.extention

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

//Activity Intent
fun AppCompatActivity.startActivityWithFinish(context: Context, activity: Class<*>) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    this.finish()
}
