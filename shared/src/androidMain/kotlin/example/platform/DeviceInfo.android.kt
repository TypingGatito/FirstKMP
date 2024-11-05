package example.platform

import android.content.res.Resources
import android.os.Build
import kotlin.math.roundToInt

actual class DeviceInfo actual constructor(){
    private val displayMetrics = Resources.getSystem().displayMetrics

    actual val osName: String
        get() = "Android"
    actual val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val model: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val cpu: String
        get() = Build.SUPPORTED_ABIS.firstOrNull() ?: "Unknown cpu"
    actual val screenWidth: Int
        get() = displayMetrics.widthPixels
    actual val screenHeight: Int
        get() = displayMetrics.heightPixels
    actual val screenDestiny: Int
        get() = displayMetrics.density.roundToInt()

    actual fun getSummary(): String = "" +
            "osName: $osName\n" +
            "osVersion: $osVersion\n" +
            "model: $model\n" +
            "cpu: $cpu\n" +
            "screenWidth: $screenWidth\n" +
            "screenHeight: $screenHeight\n" +
            "screenDestiny: $screenDestiny"

}