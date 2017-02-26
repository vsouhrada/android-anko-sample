package com.example.android.anko.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.anko.sample.sign_in.SignInActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    startActivity(Intent(this, SignInActivity::class.java))
  }

}