package example.di

import example.AppDb
import example.categories.CategoriesRepository
import example.categories.list.CategoriesViewModel
import example.categories.model.CategoryDao
import example.common.ui.calendar.DatePickerViewModel
import example.events.EventsRepository
import example.events.creation.CreateEventViewModel
import example.events.list.EventsViewModel
import example.events.models.SpendEventDao
import org.koin.dsl.module
import example.platform.DeviceInfo
import example.root.RootViewModel
import example.settings.SettingsViewModel
import example.storage.DbAdapters
import example.storage.SettingsManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.ext.getFullName

object CoreModule {
    val deviceInfo = module {
        single { DeviceInfo() }
        factory { Dispatchers.Default + SupervisorJob() }
    }
}
object StorageModule {
    val settings = module {
        single { SettingsManager(get()) }
    }

    val db = module {
        single {
            AppDb(get(), DbAdapters.categoryDbAdapter, DbAdapters.eventDbAdapter)
        }
    }

    val dao = module {
        single { CategoryDao(get(), get()) }
        single { SpendEventDao(get(), get()) }
    }
}

object RepositoriesModule {
    val repositories = module {
        single { CategoriesRepository(get()) }
        single { EventsRepository(get()) }
    }
}

object ViewModelsModule {
    val viewModels = module {
        single { RootViewModel(get()) }
        factory { SettingsViewModel(get(), get()) }
        single(DatePickerSingleQualifier) { DatePickerViewModel() }
        factory(DatePickerFactoryQualifier) { DatePickerViewModel() }
        factory { EventsViewModel(get(), get()) }
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
