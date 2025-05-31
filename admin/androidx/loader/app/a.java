package androidx.loader.app;

import androidx.lifecycle.g0;
import androidx.lifecycle.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {
    public static <T extends o & g0> a b(T t10) {
        return new b(t10, ((g0) t10).getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
