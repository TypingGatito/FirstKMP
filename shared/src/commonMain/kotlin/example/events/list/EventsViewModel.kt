package example.events.list

import example.base.BaseViewModel
import example.base.BaseViewState
import example.categories.CategoriesRepository
import example.categories.model.Category
import example.common.ui.calendar.model.CalendarDay
import example.common.ui.calendar.model.CalendarLabel
import example.events.EventsRepository
import example.events.models.SpendEvent
import example.events.models.SpendEventUI
import example.events.models.toCalendarLabel
import example.events.models.toUI
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class EventsViewModel(
    private val eventsRepository: EventsRepository,
    private val categoriesRepository: CategoriesRepository
) : BaseViewModel<EventsViewModel.State, Nothing>() {

    override fun initialState() = State.NONE

    init {
        activate()
    }

    fun selectDay(day: CalendarDay) {
        updateState { copy(selectedDay = day) }
    }

    fun createEvent(newEvent: SpendEvent) {
        viewModelScope.launch { eventsRepository.create(newEvent) }
    }

    private fun activate() {
        combine(
            eventsRepository.getAllFlow(),
            categoriesRepository.getAllFlow()
        ) { events, categories ->
            val labels = mapEventsCategoriesToLabels(events, categories)
            updateState {
                copy(
                    events = events,
                    categories = categories,
                    calendarLabels = labels
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun mapEventsCategoriesToLabels(
        events: List<SpendEvent>,
        categories: List<Category>
    ): List<CalendarLabel> {
        return events.map { event ->
            val category = categories.firstOrNull {
                it.id == event.categoryId
            } ?: Category.NONE
            event.toCalendarLabel(category)
        }
    }
    data class State(
        val selectedDay: CalendarDay?,
        val events: List<SpendEvent>,
        val categories: List<Category>,
        val calendarLabels: List<CalendarLabel>
    ) : BaseViewState {

        val eventsByDay: List<SpendEventUI>
            get() = events.filter { it.date == selectedDay?.date }
                .map { spendEvent ->
                    spendEvent.toUI(
                        categories.firstOrNull { it.id == spendEvent.categoryId } ?: Category.NONE
                    )
                }

        companion object {
            val NONE = State(
                selectedDay = null,
                events = emptyList(),
                categories = emptyList(),
                calendarLabels = emptyList()
            )
        }
    }
}







