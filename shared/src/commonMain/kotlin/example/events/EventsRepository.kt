package example.events

import example.events.models.SpendEvent
import example.events.models.SpendEventDao

class EventsRepository(
    private val dao: SpendEventDao
) {

    fun getAllFlow() = dao.getAllFlow()

    suspend fun create(spendEvent: SpendEvent) = dao.insert(spendEvent)
}