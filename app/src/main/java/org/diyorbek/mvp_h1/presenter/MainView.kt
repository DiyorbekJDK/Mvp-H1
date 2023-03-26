package org.diyorbek.mvp_h1.presenter

import org.diyorbek.mvp_h1.model.Data
import org.diyorbek.mvp_h1.model.User

interface MainView {

    fun onUsersGetSuccess(user: List<Data>)
    fun onUsersGetFailure(error: String)

}