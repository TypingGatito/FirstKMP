package example.platform

actual class DeviceInfo actual constructor(){
    actual val osName: String
        get() = System.getProperty("os.name") ?: "Desktop"
    actual val osVersion: String
        get() = System.getProperty("os.version") ?: "Unknown version"
    actual val model: String
        get() = "Desktop"
    actual val cpu: String
        get() = System.getProperty("os.arch") ?: "Unknown arch"
    actual val screenWidth: Int
        get() = 0
    actual val screenHeight: Int
        get() = 0
    actual val screenDestiny: Int
        get() = 0

    actual fun getSummary(): String =
        "osName: $osName\n" +
                "osVersion: $osVersion\n" +
                "model: $model\n" +
                "cpu: $cpu\n" +
                "screenWidth: $screenWidth"

}