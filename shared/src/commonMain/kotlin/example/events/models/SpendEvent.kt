package example.events.models

import events.EventDb
import example.categories.model.Category
import example.common.ui.calendar.model.CalendarLabel
import example.extensions.now
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import kotlin.collections.List

data class SpendEvent (
    val id: String,
    val categoryId: String,
    val title: String,
    val cost: Double,
    val date: LocalDate,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        val NONE = SpendEvent(
            id = "",
                    categoryId = "",
                    title = "",
                    cost = 0.0,
                    date = LocalDate.now(),
                    createdAt = LocalDateTime.now(),
                    updatedAt = LocalDateTime.now()
        )

    }

}



fun SpendEvent.toUI(category: Category) = SpendEventUI(
    id = id,
    category = category,
    title = title,
    cost = cost
)

fun SpendEvent.toCalendarLabel(category: Category) = CalendarLabel(
    id = id,
    colorHex = category.colorHex,
    localDate = date
)

fun SpendEvent.toDb() = EventDb(
    id = id,
    categoryId = categoryId,
    title = title,
    cost = cost,
    date = date,
    createdAt = createdAt,
    updatedAt = updatedAt,
    note = "note"
)

fun EventDb.toEntity() = SpendEvent(
    id = id,
    categoryId = categoryId,
    title = title.orEmpty(),
    cost = cost ?: 0.0,
    date = date,
    createdAt = createdAt,
    updatedAt = updatedAt,
)