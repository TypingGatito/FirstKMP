package example.root.model

import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource
import example.MR

data class BottomBarItem (
    val title: StringResource,
    val appTab: AppTab,
    val icon: ImageResource
) {
    companion object {
        fun getItems() = listOf(
            BottomBarItem(MR.strings.events, AppTab.Events, MR.images.ic_calendar),
            BottomBarItem(MR.strings.categories, AppTab.Categories, MR.images.ic_folder),
            BottomBarItem(MR.strings.settings, AppTab.Settings, MR.images.ic_settings)
        )
    }
}