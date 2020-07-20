package me.linshen.retrofit2.adapter.livedata.demo.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_user.*
import me.linshen.retrofit2.adapter.ApiSuccessResponse
import me.linshen.retrofit2.adapter.livedata.demo.R
import me.linshen.retrofit2.adapter.livedata.demo.api.RetrofitProvider
import me.linshen.retrofit2.adapter.livedata.demo.repository.UserRepository

class UserFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return UserViewModel(
                    UserRepository.getInstance(RetrofitProvider.provideGithubService())) as T
            }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = UserFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            it.isEnabled = false
            indeterminateBar.visibility = View.VISIBLE
            userViewModel.userRepository.getUser("shawnlinboy").observe(viewLifecycleOwner,
                Observer { response ->
                    it.isEnabled = true
                    indeterminateBar.visibility = View.GONE
                    when (response) {
                        is ApiSuccessResponse -> {
                            textView.text = getString(
                                R.string.result_template, response.body.name,
                                response.body.blog
                            )
                        }
                        else -> {
                        }
                    }
                })
        }
    }

}