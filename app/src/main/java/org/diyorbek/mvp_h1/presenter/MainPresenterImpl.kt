package org.diyorbek.mvp_h1.presenter

import org.diyorbek.mvp_h1.model.Data
import org.diyorbek.mvp_h1.model.User
import org.diyorbek.mvp_h1.network.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenterImpl(private val mainView: MainView):MainPresenter {
    override fun getAllUserList() {
        RetroInstance.retrofitInstance().getAllUsers().enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (response.isSuccessful){
                    mainView.onUsersGetSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                mainView.onUsersGetFailure(t.message!!)
                throw t
            }
        })
    }
}