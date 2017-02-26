package com.example.android.anko.sample.sign_in

import com.example.android.anko.sample.R
import org.jetbrains.anko.*

/**
 * @author vsouhrada
 * @since 0.1.0
 * @see[AnkoComponent]
 * @see[SignInActivity]
 */
class SingInView : AnkoComponent<SignInActivity> {

  override fun createView(ui: AnkoContext<SignInActivity>) = with(ui) {
    verticalLayout {
      lparams(width  = matchParent, height = matchParent)

      editText {
        lparams(width = matchParent, height = wrapContent)
        id = R.id.usernameEditText
        hintResource = R.string.sign_in_username
        textSize = 24f
      }

      editText {
        lparams(width = matchParent, height = wrapContent)
        id = R.id.passwordEditText
        hintResource = R.string.signIn_password
        textSize = 24f
      }

      button {
        lparams(width = matchParent, height = wrapContent)
        id = R.id.signIn_button
        textResource = R.string.signIn_button
      }
    }
  }

}