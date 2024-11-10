package example.categories.model

import example.extensions.now
import kotlinx.datetime.LocalDateTime

data class Category (
    val id: String,
    val title: String,
    val description: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val colorHex: String
) {
    companion object {
        val NONE = Category(
            id = "NONE_CATEGORY",
            title = "",
            description = "",
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
            colorHex = ""
        )


        fun getStubs() = List(20) { index ->
            NONE.copy(id = index.toString(), title = "category $index")
        }
    }
}