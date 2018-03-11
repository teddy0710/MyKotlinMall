package com.kotlin.provider.common

import com.kotlin.base.common.BaseConstant
import com.kotlin.base.utils.AppPrefsUtils

/**
 * Created by TEDDY on 2018/3/12.
 */
fun isLogined(): Boolean {
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}