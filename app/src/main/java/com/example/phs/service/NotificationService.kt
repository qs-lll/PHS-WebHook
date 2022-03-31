package com.example.phs.service

import android.app.Notification
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NotificationService : NotificationListenerService() {
    val TAG = this.javaClass.name


    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        Log.d(TAG, "onNotificationPosted")
        val notification = sbn.notification
        val packageName = sbn.packageName
        val time = sbn.postTime
        val title = notification.extras.getString(Notification.EXTRA_TITLE)
        var text:String=StringBuilder().apply {
            try {
                append(notification.extras.getString(Notification.EXTRA_TEXT).toString())
            } catch (e:Exception) {
                notification.extras.getInt(Notification.EXTRA_TEXT).toString()
            }
        }.toString()
        Log.e(TAG,"${packageName+title+text+time}")
//        DbUtils.saveNotification(NotificationInfo(packageName, title, text, time))
//        val blackList: List<AppInfo> = DbUtils.getApp()
//        for (app in blackList) {
//            if (packageName == app.getPackageName()) {
//                Log.d(NotificationListenerService.TAG, "$packageName 拦截：$title: $text")
//                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
//                    cancelNotification(sbn.key)
//                } else {
//                    cancelNotification(sbn.packageName, sbn.tag, sbn.id)
//                }
//                if (SettingUtils.getInstance().isNotify()) {
//                    createNotification(app.getAppName(), packageName, title, text)
//                }
//            }
//        }
    }


}