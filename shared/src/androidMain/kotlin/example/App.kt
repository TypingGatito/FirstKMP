package example

import android.app.Application
import android.content.Context
import example.di.initKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(appModule =
        module{
            single<Context> { this@App.applicationContext }
        })

        instance = this
    }

    companion object {
        lateinit var instance: App
    }
}