// Copyright 2025-present 650 Industries. All rights reserved.

package expo.modules.testexpoui

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import expo.modules.ui.ExpoUIView

class TestExpoUiModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("TestExpoUi")

    OnCreate {
      registerCustomBorderModifier()
    }

    OnDestroy {
      unregisterCustomBorderModifier()
    }

    ExpoUIView<MyCustomViewProps>("MyCustomView") {
      Content { props ->
        MyCustomViewContent(props)
      }
    }
  }
}
