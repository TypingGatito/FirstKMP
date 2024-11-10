package example.di

import example.categories.CategoriesRepository
import example.categories.list.CategoriesViewModel
import example.common.ui.calendar.DatePickerViewModel
import example.events.EventsRepository
import example.events.creation.CreateEventViewModel
import example.events.list.EventsViewModel
import org.koin.dsl.module
import example.platform.DeviceInfo
import example.root.RootViewModel
import example.settings.SettingsViewModel
import example.storage.SettingsManager
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.ext.getFullName

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

object RepositoriesModule {
    val repositories = module {
        single { CategoriesRepository() }
        single { EventsRepository() }
    }
}

object ViewModelsModule {
    val viewModels = module {
        single {RootViewModel(get())}
        factory { SettingsViewModel(get(), get())}
        single { DatePickerViewModel() }
        single { CategoriesViewModel(get()) }
        single { EventsViewModel(get(), get()) }
        single { CategoriesViewModel(get()) }
        factory { CreateEventViewModel() }
    }
}

object DatePickerSingleQualifier: Qualifier {
    override val value: QualifierValue
        get() = this::class.getFullName()
}

object DatePickerFactoryQualifier: Qualifier {
    override val value: QualifierValue
        get() = this::class.getFullName()
}
