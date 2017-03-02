package com.example.android.anko.sample.sign_in.bl

import com.example.android.anko.sample.sign_in.model.AuthCredentials

/**
 * @author vsouhrada
 * @since
 */
class SignInBL : ISignInBL {

  override fun checkUserCredentials(credentials: AuthCredentials): Boolean {
    return ("frosty".equals(credentials.username) && "snowman".equals(credentials.password))
  }
}