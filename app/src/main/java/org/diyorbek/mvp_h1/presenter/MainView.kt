package org.diyorbek.mvp_h1.presenter

import org.diyorbek.mvp_h1.model.Data

interface MainView {

    fun onUsersGetSuccess(user: List<Data>)
    fun onUsersGetFailure(error: String)

}