package org.diyorbek.mvp_h1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import org.diyorbek.mvp_h1.adapter.UserAdapter
import org.diyorbek.mvp_h1.databinding.ActivityMainBinding
import org.diyorbek.mvp_h1.model.Data
import org.diyorbek.mvp_h1.model.User
import org.diyorbek.mvp_h1.presenter.MainPresenter
import org.diyorbek.mvp_h1.presenter.MainPresenterImpl
import org.diyorbek.mvp_h1.presenter.MainView

class MainActivity : AppCompatActivity(), MainView {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val userAdapter by lazy { UserAdapter() }
    private lateinit var presenter: MainPresenterImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenterImpl(this)
        binding.rv.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        presenter.getAllUserList()

    }

    override fun onUsersGetSuccess(user: List<Data>) {
        userAdapter.submitList(user)
        binding.progressBar.isVisible = false
    }

    override fun onUsersGetFailure(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        Log.d("@@@", "onUsersGetFailure: $error")
    }
}