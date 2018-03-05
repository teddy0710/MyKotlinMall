package com.kotlin.base.data.protocol

/**
 * Created by TEDDY on 2018/3/5.
 */
class BaseResp<out T>(val status:Int, val message:String, val data:T) {
}