package com.example.android.anko.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.anko.sample.sign_in.SignInActivity
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    startActivity(intentFor<SignInActivity>())
  }

}