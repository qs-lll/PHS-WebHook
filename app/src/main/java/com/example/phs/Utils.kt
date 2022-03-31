package com.example.phs

import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun notificationListenerEnable(context: Context): Boolean {
    var enable = false
    val flat: String =
        Settings.Secure.getString(context.contentResolver, "enabled_notification_listeners")
    if (flat != null) {
        enable = flat.contains(context.packageName)
    }
    return enable
}

fun toast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun toast(context: Context, id: Int) {
    Toast.makeText(context, id, Toast.LENGTH_SHORT).show()
}

fun snack(view: View,action: (snack:Snackbar) -> Unit) {
    Snackbar.make(
        view,
        R.string.needpermission,
        Snackbar.LENGTH_LONG
    ).apply {
        action(this)
        show()
    }
}