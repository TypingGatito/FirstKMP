package example.categories

import example.categories.model.Category
import example.categories.model.CategoryDao
import example.extensions.appLog
import kotlinx.coroutines.flow.flow

class CategoriesRepository(
    private val dao: CategoryDao
) {

    fun getAllFlow() = dao.getAllFlow()

    suspend fun create(category: Category){
        dao.insert(category)
    }

}