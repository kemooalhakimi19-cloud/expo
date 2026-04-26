// Copyright 2025-present 650 Industries. All rights reserved.

package expo.modules.testexpoui

import android.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import expo.modules.kotlin.records.recordFromMap
import expo.modules.ui.ModifierRegistry
import expo.modules.ui.compose

internal data class CustomBorderModifierParams(
  @Field val color: Color? = null,
  @Field val width: Int = 2,
  @Field val cornerRadius: Int = 0
) : Record

@Composable
internal fun rememberCustomBorderModifier(map: Map<String, Any?>): Modifier {
  val params = recordFromMap<CustomBorderModifierParams>(map)
  val color = params.color?.compose ?: return Modifier
  return Modifier.border(
    BorderStroke(params.width.dp, color),
    shape = RoundedCornerShape(params.cornerRadius.dp)
  )
}

internal fun registerCustomBorderModifier() {
  ModifierRegistry.register("customBorder") { map, _, _, _ ->
    rememberCustomBorderModifier(map)
  }
}

internal fun unregisterCustomBorderModifier() {
  ModifierRegistry.unregister("customBorder")
}
