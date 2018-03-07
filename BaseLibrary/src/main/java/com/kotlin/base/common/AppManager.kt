package com.kotlin.base.common

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * Activity管理类(单例)
 * Created by ZFL on 2018/3/7
 */
class AppManager private constructor() {

    private val activityStack: Stack<Activity> = Stack();

    companion object {
        val instance: AppManager by lazy { AppManager() }
    }

    /*
    入栈
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /*
    出栈
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    /*
    获取栈顶activity
     */
    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    /*
    清空栈
     */
    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }

    /*
     退出应用程序
    */
    fun exitApp(context: Context) {
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }


}