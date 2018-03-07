package com.kotlin.base.utils

import android.text.Editable
import android.text.TextWatcher

/**
 * TextWatcher默认实现
 * Created by ZFL on 2018/3/7
 */
open class DefaultTextWacther : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}