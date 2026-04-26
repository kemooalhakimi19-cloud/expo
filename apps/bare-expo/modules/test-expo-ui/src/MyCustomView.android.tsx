import { type CommonViewModifierProps } from '@expo/ui/jetpack-compose';
import { createViewModifierEventListener } from '@expo/ui/jetpack-compose/modifiers';
import { requireNativeView } from 'expo';

export interface MyCustomViewProps extends CommonViewModifierProps {
  title: string;
  children?: React.ReactNode;
}

const NativeMyCustomView = requireNativeView<MyCustomViewProps>('TestExpoUi', 'MyCustomView');

export function MyCustomView({ modifiers, ...restProps }: MyCustomViewProps) {
  return (
    <NativeMyCustomView
      modifiers={modifiers}
      {...(modifiers ? createViewModifierEventListener(modifiers) : undefined)}
      {...restProps}
    />
  );
}
