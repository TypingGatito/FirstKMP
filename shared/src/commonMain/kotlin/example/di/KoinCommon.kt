package example.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import org.koin.core.module.Module

expect val platformModule: Module

inline fun <reified T> getKoinInstance(qualifier: Qualifier? = null) : T {
    return object : KoinComponent {
        val value : T by inject()
    }.value
}

fun initKoin(
    appModule : Module = module {  }
) = startKoin {
    modules (
        CoreModule.deviceInfo,
        StorageModule.settings,
        platformModule,
        appModule,
        ViewModelsModule.viewModels,
        RepositoriesModule.repositories
    )
}