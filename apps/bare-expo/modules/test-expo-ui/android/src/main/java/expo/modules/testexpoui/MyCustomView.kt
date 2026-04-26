// Copyright 2025-present 650 Industries. All rights reserved.

package expo.modules.testexpoui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import expo.modules.kotlin.views.ComposeProps
import expo.modules.kotlin.views.FunctionalComposableScope
import expo.modules.ui.ModifierList
import expo.modules.ui.ModifierRegistry
import expo.modules.ui.UIComposableScope

data class MyCustomViewProps(
  val title: String = "",
  val modifiers: ModifierList = emptyList()
) : ComposeProps

@Composable
fun FunctionalComposableScope.MyCustomViewContent(props: MyCustomViewProps) {
  val modifier = ModifierRegistry.applyModifiers(
    props.modifiers,
    appContext,
    composableScope,
    globalEventDispatcher
  )

  Column(modifier = modifier) {
    Text(
      text = props.title,
      style = MaterialTheme.typography.titleMedium
    )
    Children(UIComposableScope())
  }
}
