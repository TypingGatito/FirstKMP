package example.di

import org.koin.dsl.module
import example.platform.DeviceInfo
import example.root.RootViewModel
import example.settings.SettingsViewModel
import example.storage.SettingsManager

object CoreModule {
    val deviceInfo = module {
        single { DeviceInfo() }
    }
}
object StorageModule {
    val settings = module {
        single { SettingsManager(get()) }
    }
}

object ViewModelsModule {
    val viewModels = module {
        single {RootViewModel(get())}
        factory { SettingsViewModel(get(), get())}
    }
}