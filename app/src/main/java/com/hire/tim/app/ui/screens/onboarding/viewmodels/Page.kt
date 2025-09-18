package com.hire.tim.app.ui.screens.onboarding.viewmodels

import androidx.annotation.DrawableRes
import com.hire.tim.app.R
import com.hire.tim.app.ui.screens.onboarding.viewmodels.Page

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int

)

val pages: List<Page> = listOf(
    Page(title ="Oh Hello there,", description = "I'm Tim and I'm an Android Developer.", image = R.drawable.splash_screen_logo_light),
    Page(title ="Oh Hello there,", description = "I'm Tim and I'm an Android Developer.", image = R.drawable.splash_screen_logo_light),
    Page(title ="Oh Hello there,", description = "I'm Tim and I'm an Android Developer.", image = R.drawable.splash_screen_logo_light),
)