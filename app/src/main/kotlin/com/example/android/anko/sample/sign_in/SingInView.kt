package com.example.android.anko.sample.sign_in

import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.widget.EditText
import com.example.android.anko.sample.R
import org.jetbrains.anko.*

/**
 * @author vsouhrada
 * @since 0.1.0
 * @see[AnkoComponent]
 * @see[SignInActivity]
 */
class SingInView : AnkoComponent<SignInActivity> {

    private lateinit var ankoContext: AnkoContext<SignInActivity>

    override fun createView(ui: AnkoContext<SignInActivity>) = with(ui) {
        ankoContext = ui

        verticalLayout {
            this.gravity = Gravity.CENTER
            lparams(width = matchParent, height = matchParent)

            scrollView {
                lparams(width = matchParent, height = wrapContent)

                verticalLayout {
                    lparams(width = matchParent, height = matchParent)

                    verticalLayout {
                        id = R.id.formLogin
                        gravity = Gravity.CENTER
                        padding = dip(20)
                        lparams(width = dip(300), height = matchParent) {
                            this.gravity = Gravity.CENTER
                            // API >= 16
                            doFromSdk(version = Build.VERSION_CODES.JELLY_BEAN) {
                                background = ContextCompat.getDrawable(ctx, android.R.color.white)
                            }
                            clipToPadding = false
                            bottomMargin = dip(16)
                        }

                        val username = editText {
                            lparams(width = matchParent, height = wrapContent)
                            id = R.id.usernameEditText
                            hintResource = R.string.sign_in_username
                        }

                        val password = editText {
                            lparams(width = matchParent, height = wrapContent)
                            id = R.id.passwordEditText
                            hintResource = R.string.signIn_password
                        }

                        button {
                            lparams(width = matchParent, height = wrapContent)
                            id = R.id.signIn_button
                            textResource = R.string.signIn_button

                            onClick {
                                handleOnSignInButtonPressed(username = username.text.toString(), password = password.text.toString())
                            }
                        }
                    }.applyRecursively { view ->
                        when (view) {
                            is EditText -> view.textSize = 24f
                        }
                    }
                }
            }
        }
    }

    private fun handleOnSignInButtonPressed(username: String, password: String) {
        with(ankoContext) {
            if (username.isBlank() or password.isBlank()) {
                alert(title = R.string.sigIn_alert_invalid_user_title,
                        message = R.string.sigIn_alert_invalid_user_message) {

                    positiveButton(R.string.dialog_button_close) {}
                }.show()
            } else {
                owner.authorizeUser(username, password)
            }
        }
    }

    fun showAccessDeniedAlertDialog() {
        with(ankoContext) {
            alert(title = R.string.sigIn_alert_access_denied_title,
                    message = R.string.sigIn_alert_access_denied_msg) {

                positiveButton(R.string.dialog_button_close) {}
            }.show()
        }
    }

}