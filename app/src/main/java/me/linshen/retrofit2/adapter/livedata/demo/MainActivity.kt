package me.linshen.retrofit2.adapter.livedata.demo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import me.linshen.retrofit2.adapter.ApiSuccessResponse
import me.linshen.retrofit2.adapter.livedata.demo.api.RetrofitProvider
import me.linshen.retrofit2.adapter.livedata.demo.user.UserFragment
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            replace(R.id.container, UserFragment.newInstance())
        }
    }
}
