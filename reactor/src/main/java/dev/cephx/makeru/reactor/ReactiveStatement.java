package dev.cephx.makeru.reactor;

import dev.cephx.makeru.Readable;
import dev.cephx.makeru.Bindable;
import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveStatement extends Executable, Bindable<ReactiveStatement> {
    @NotNull
    Flux<? extends ReactiveResult<? extends Readable>> executeAsQuery();

    @NotNull
    Mono<Long> executeAsUpdate();
}
