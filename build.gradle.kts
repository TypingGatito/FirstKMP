// apply false распространяет для дочерних, но не для этого
plugins {
    alias(libs.plugins.multiplatform) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
}




val myTask = "myTask1"
val myTask2 = "myTask2"

// второе является именем ключа.
// Можно обращаться по переменной или по строке
val myGroup = "my"

val key = "key"
tasks.register(myTask) {
    println("$name init")

    this.doFirst() {
        println("$name do work 1")
        //project.ext.set(key, "new val")
    }
    this.doFirst() {
        println("$name do work 2")
    }

    this.doLast() {
        println("$name do work 2")
    }

}

// конфигурирует только те, что были выше
//tasks.forEach {task ->
//    if (task.name.contains("my")) {
//        task.group = myGroup
//    }
//}


// конфигурирует все
//tasks - живая коллекция
tasks.configureEach {
    if (name.contains("my")) {
        group = myGroup
    }
}

tasks.register(myTask2) {
    println("$name init")

    dependsOn(myTask)

    this.doFirst() {
        println("${project.findProperty(key)}")
    }

}
