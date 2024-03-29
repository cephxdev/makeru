package dev.cephx.makeru;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Bindable<T extends Bindable<T>> {
    @Contract("-> this")
    @NotNull
    T add();
    @Contract("_, _ -> this")
    @NotNull
    T bind(int index, @NotNull Object value);
    @Contract("_, _ -> this")
    @NotNull
    T bindNull(int index, @NotNull Class<?> type);
}
