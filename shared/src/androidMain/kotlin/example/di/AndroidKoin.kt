package example.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import example.AppDb
import org.koin.dsl.module

actual val platformModule = module {
    single { get<Context>().getSharedPreferences("appSettings", Context.MODE_PRIVATE)}
    single<Settings> { SharedPreferencesSettings(get()) }
    single <SqlDriver> { AndroidSqliteDriver(AppDb.Schema, get(), "AppDb") }
}