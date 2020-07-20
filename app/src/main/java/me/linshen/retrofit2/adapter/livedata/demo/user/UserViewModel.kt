package me.linshen.retrofit2.adapter.livedata.demo.user

import androidx.lifecycle.ViewModel
import me.linshen.retrofit2.adapter.livedata.demo.repository.UserRepository

/**
 * We use a ViewModel so everything should work fine with activity/fragment's lifecycle
 */
class UserViewModel(val userRepository: UserRepository) : ViewModel()