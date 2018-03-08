package com.kotlin.user.service.impl

import com.kotlin.base.ext.convert
import com.kotlin.base.ext.convertBoolean
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.data.repository.UploadTokenRepository
import com.kotlin.user.data.repository.UserRepository
import com.kotlin.user.injection.module.UploadModule
import com.kotlin.user.service.UploadService
import com.kotlin.user.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * Created by ZFL on 2018/3/5
 */
class UploadServiceImpl @Inject constructor() : UploadService {


    @Inject
    lateinit var repository: UploadTokenRepository

    override fun getUploadToken(): Observable<String> {
        return repository.getUploadToken().convert()
    }

}