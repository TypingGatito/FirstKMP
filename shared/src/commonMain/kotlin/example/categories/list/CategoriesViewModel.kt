package example.categories.list

import example.base.BaseViewModel
import example.base.BaseViewState
import example.categories.CategoriesRepository
import example.categories.model.Category
import example.extensions.now
import example.categories.create.CreateCategoryData
import example.categories.create.toCategory
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime

class CategoriesViewModel (
    private val repository: CategoriesRepository
) : BaseViewModel<CategoriesViewModel.State, Nothing>(){

    override fun initialState() = State.NONE

    init {
        activate()
    }

    private fun activate(){
        repository.getAllFlow().onEach {
            updateState { copy(categoties = it) }
        }.launchIn(viewModelScope)
    }

    fun createCategory(data: CreateCategoryData){
        val now = LocalDateTime.now()
        val category = data.toCategory(now)
        viewModelScope.launch {
            repository.create(category)
        }
    }

    data class State(
        val categoties: List<Category>
    ) : BaseViewState {

        companion object {
            val NONE = State(emptyList())
        }
    }
}