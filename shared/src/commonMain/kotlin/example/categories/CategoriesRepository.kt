package example.categories

import example.categories.model.Category
import example.extensions.appLog
import kotlinx.coroutines.flow.flow

class CategoriesRepository {

    fun getAllFlow() = flow { emit(Category.getStubs()) }

    suspend fun create(category: Category){
        appLog("created category: $category")
    }
}