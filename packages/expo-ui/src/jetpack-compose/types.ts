import type { ModifierConfig } from '../types';

/**
 * Common props that can be applied to any Jetpack Compose view.
 * Extend this when authoring a custom Compose view in your own Expo module
 * so that callers can pass `modifiers` and `testID` like they do for the
 * built-in `@expo/ui/jetpack-compose` components.
 */
export interface CommonViewModifierProps {
  /**
   * Used to locate this view in end-to-end tests.
   */
  testID?: string;

  /**
   * Array of view modifiers to apply to this view.
   * Modifiers are applied in the order they appear in the array.
   *
   * @example
   * ```tsx
   * import { background, clip, padding, Shapes } from '@expo/ui/jetpack-compose/modifiers';
   *
   * <Text modifiers={[
   *   background('#FF0000'),
   *   padding(16, 16, 16, 16),
   *   clip(Shapes.RoundedCorner(12)),
   * ]}>
   *   Hello World
   * </Text>
   * ```
   */
  modifiers?: ModifierConfig[];
}
