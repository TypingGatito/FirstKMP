package example.events

import example.events.models.SpendEvent
import example.extensions.appLog
import kotlinx.coroutines.flow.flow

class EventsRepository {

    fun getAllFlow() = flow { emit(SpendEvent.getStubs()) }

    fun create(spendEvent: SpendEvent) = appLog("create event $spendEvent")
}