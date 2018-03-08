package com.kotlin.user.service

import com.kotlin.user.data.protocol.UserInfo
import rx.Observable

/**
 * Created by ZFL on 2018/3/5
 */
interface UploadService {
    fun getUploadToken(): Observable<String>
}