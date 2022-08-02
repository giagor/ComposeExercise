package com.example.composeexercise

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.WindowManager

fun <T> Activity.startActivity(clazz: Class<T>) {
    startActivity(Intent(this, clazz))
}

fun dpToPx(value: Float): Float = TypedValue.applyDimension(
    // dp * metrics.density = px
    TypedValue.COMPLEX_UNIT_DIP, value, Resources.getSystem().displayMetrics
)

fun pxToDp(value: Float): Float {
    val metrics = Resources.getSystem().displayMetrics
    return value / metrics.density
}

/**
 * 获取窗口的宽度
 *
 * @return 若获取成功，则返回窗口的宽度；若获取失败，则返回0
 * */
fun getWindowWidth(context: Context): Int {
    val windowManager: WindowManager? =
        context.getSystemService(Context.WINDOW_SERVICE) as? WindowManager
    if (windowManager != null) {
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        return metrics.widthPixels
    }
    return 0
}