package com.example.composeexercise

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Constant {
    const val INTENT_EXTRA_DOG_DATA = "intent_extra_dog_data"
}

fun <T> Activity.startActivitySimply(clazz: Class<T>) {
    startActivity(Intent(this, clazz))
}

fun Activity.startActivityByIntent(intent: Intent) {
    startActivity(intent)
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
 * 根据已经占用的宽度，计算水平方向的 padding 值
 *
 * @param occupyWidth 已占用宽度
 * @param context window所在的context
 * */
fun availableHorizontalPadding(occupyWidth: Dp, context: Context): Dp {
    // 获取屏幕宽度
    val windowWidth = getWindowWidth(context)
    return if (windowWidth == 0) {
        0.dp
    } else {
        // (屏幕宽度 - item宽度)再除以2，得到列表的item左右剩余的空间，这也是标题左边应该padding的距离
        Dp(pxToDp(windowWidth - dpToPx(occupyWidth.value)) / 2)
    }
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

/**
 * 状态栏设置为白底黑字
 * copy from：https://www.jianshu.com/p/e0830a6fc5a8?u_atoken=30218a3f-5b18-427b-9d2a-ff4e53d85428&u_asession=01-tgmVs6AMR-S4wSU54GYP-dzmsBbTn1kEg4G0qfq83pHUNu52wg7JSUz3YZoMp6jX0KNBwm7Lovlpxjd_P_q4JsKWYrT3W_NKPr8w6oU7K9_IcYi4rc-Dh5Uz_yY2h6T9Z8yatDP0qApUVWMROZyFmBkFo3NEHBv0PZUm6pbxQU&u_asig=05Du4XJ0fK6lLGPpLPouPbTxXu6f-fTDJV4UYr4o-z1oD4zqU9Jc4A6UTUobpglWHegCboY-JlyJt3RcsWJ-dRYGfiJtDQHoMXjbdxMqa7lmd0pgr6SqiGCI1RU9aXDd2Dfy2xxAhyDAivp8xW6gXDZXv1Z_13uLmxhHmKA6NiryP9JS7q8ZD7Xtz2Ly-b0kmuyAKRFSVJkkdwVUnyHAIJzQp3iewCZEXlOz1NcjKBt14rQwA3zZLpHhus8BQnBwj5Cs-hAuami3wC_ze-3aLJqu3h9VXwMyh6PgyDIVSG1W_mUroPc1WmcnjIJMqiup-_A_EfRCNG5Eh4CmV7Kcr195_qa9e1pTJo15tBOmkgeEyyFZaKEBfOJBUlo3H97PYGmWspDxyAEEo4kbsryBKb9Q&u_aref=sTg7kdTB9LF3jU5IgyKlZO4FrBE%3D
 * */
fun Window.adaptStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        //After LOLLIPOP not translucent status bar
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        //Then call setStatusBarColor.
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        setStatusBarColor(Color.WHITE)
        //设置状态栏字体颜色
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}