package example.categories.model

import categories.CategoryDb
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

    }
}

fun CategoryDb.toEntity() = Category(
    id = id,
    title = title.orEmpty(),
    description = description.orEmpty(),
    createdAt = createdAt,
    updatedAt = updatedAt,
    colorHex = colorHex,
)


fun Category.toDb() = CategoryDb(
    id = id,
    title = title,
    description = description,
    createdAt = createdAt,
    updatedAt = updatedAt,
    colorHex = colorHex,
)