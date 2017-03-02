package com.example.android.anko.sample.sign_in.bl

import com.example.android.anko.sample.sign_in.model.AuthCredentials

/**
 * @author vsouhrada
 * @since 0.1.0
 */
interface ISignInBL {

  fun checkUserCredentials(credentials: AuthCredentials): Boolean

}