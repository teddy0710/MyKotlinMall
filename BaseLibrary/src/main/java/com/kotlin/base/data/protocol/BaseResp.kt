package com.kotlin.base.data.protocol

/**
 * Created by TEDDY on 2018/3/5.
 */
/**
 * 返回状态，返回消息，具体返回实体类
 */
class BaseResp<out T>(val status: Int, val message: String, val data: T) {
}