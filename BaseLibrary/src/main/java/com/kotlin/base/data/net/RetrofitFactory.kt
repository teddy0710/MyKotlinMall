package com.kotlin.base.data.net

import com.kotlin.base.common.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 单例
 * Created by ZFL on 2018/3/5
 */
class RetrofitFactory private constructor() {
    /**
     * 伴生对象类似于静态，by lazy 线程安全
     */
    companion object {
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(Constant.SERVER_ADDRESS)//URL
                .addConverterFactory(GsonConverterFactory.create())//数据转换工厂
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//与Rx结合的适配工厂
                .client(initClient())
                .build()
    }

    private fun initClient(): OkHttpClient? {
        return OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())//日志拦截器
                .connectTimeout(10, TimeUnit.SECONDS)//设置超时时间
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build()
    }

    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun <T> create(service: Class<T>):T {
        return retrofit.create(service)
    }
}