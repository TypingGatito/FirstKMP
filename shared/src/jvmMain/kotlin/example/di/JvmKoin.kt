package example.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import example.AppDb
import example.common.ui.atoms.AppCard
import org.koin.core.module.Module
import org.koin.dsl.module
import java.util.prefs.Preferences

actual val platformModule: Module = module {
    single<Settings> {
        PreferencesSettings(Preferences.userRoot())
    }

    single<SqlDriver> {
        val driver = JdbcSqliteDriver("jdbc:sqlight:AppDb.db")
        AppDb.Schema.create(driver)

        driver
    }
}