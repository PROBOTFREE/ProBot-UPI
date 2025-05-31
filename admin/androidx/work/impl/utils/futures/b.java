package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;

enum b implements Executor {
    INSTANCE;

    public void execute(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "DirectExecutor";
    }
}
