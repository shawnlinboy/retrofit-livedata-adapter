 retrofit-livedata-adapter
========

This library mostly mirrors code from [googlesamples/android-architecture-components][1], which can add [LiveData][2] support for Retrofit.

In a sense, this can be viewed as an official support.

Download
--------

``` groovy
implementation 'me.linshen.retrofit2:adapter-livedata:1.0.0'
```

Usage
--------

``` kotlin

Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(GithubService::class.java)
            .getUser("shawnlinboy").observe(this,
                Observer { response ->
                    when (response) {
                        is ApiSuccessResponse -> {
                          //success response
                        }
                        else -> {
                            //failed response
                        }
                    }
                })
```

 [1]: https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample
 [2]:https://developer.android.com/topic/libraries/architecture/livedata