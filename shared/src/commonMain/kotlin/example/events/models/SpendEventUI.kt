package example.events.models

import example.categories.model.Category

data class SpendEventUI(
    val id: String,
    val category: Category,
    val title: String,
    val cost: Double
)
