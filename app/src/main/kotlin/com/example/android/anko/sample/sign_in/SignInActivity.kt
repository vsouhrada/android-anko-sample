package com.example.android.anko.sample.sign_in

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.anko.sample.sign_in.bl.ISignInBL
import com.example.android.anko.sample.sign_in.bl.SignInBL
import com.example.android.anko.sample.sign_in.model.AuthCredentials
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class SignInActivity : AppCompatActivity() {

  private val signInBL: ISignInBL = SignInBL()
  private lateinit var view: SingInView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    view = SingInView()
    view.setContentView(this)
  }

  fun authorizeUser(username: String, password: String) {
    doAsync {
      val authorized = signInBL.checkUserCredentials(AuthCredentials(username = username, password = password))

      activityUiThread {
        if (authorized) toast("Signed!!!") else view.showAccessDeniedAlertDialog()
      }
    }
  }
}
