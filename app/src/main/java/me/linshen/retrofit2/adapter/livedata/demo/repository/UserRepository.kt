package me.linshen.retrofit2.adapter.livedata.demo.repository

import me.linshen.retrofit2.adapter.livedata.demo.api.GithubService

/**
 * A repository should be a singleton
 */
class UserRepository private constructor(private val githubService: GithubService) {

    fun getUser(login: String) = githubService.getUser(login)

    companion object {
        @Volatile
        private var INSTANCE: UserRepository? = null

        @JvmStatic
        fun getInstance(orderService: GithubService): UserRepository {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                return UserRepository(orderService).also {
                    INSTANCE = it
                }
            }
        }
    }

}