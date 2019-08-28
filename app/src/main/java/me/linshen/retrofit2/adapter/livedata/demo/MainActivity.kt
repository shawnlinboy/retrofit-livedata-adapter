package me.linshen.retrofit2.adapter.livedata.demo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import me.linshen.retrofit2.adapter.ApiSuccessResponse
import me.linshen.retrofit2.adapter.livedata.demo.api.RetrofitProvider
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            it.isEnabled = false
            indeterminateBar.visibility = View.VISIBLE
            RetrofitProvider.provideGithubService().getUser("shawnlinboy").observe(this,
                Observer { response ->
                    it.isEnabled = true
                    indeterminateBar.visibility = View.GONE
                    when (response) {
                        is ApiSuccessResponse -> {
                           textView.text = getString(R.string.result_template, response.body.name,
                               response.body.blog)
                        }
                        else -> {
                        }
                    }
                })
        }
    }
}
