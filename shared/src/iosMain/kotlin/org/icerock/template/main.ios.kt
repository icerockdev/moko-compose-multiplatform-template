package org.icerock.template

import App
import androidx.compose.ui.window.ComposeUIViewController
import dev.icerock.moko.resources.desc.desc
import com.myapplication.common.MR

actual fun getMokoResourcesText(): String = MR.strings.moko_resources_title.desc().localized()

fun MainViewController() = ComposeUIViewController { App() }